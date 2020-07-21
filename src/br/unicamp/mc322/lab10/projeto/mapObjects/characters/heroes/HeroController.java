package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes;

import java.util.Random;
import java.util.Scanner;

import br.unicamp.mc322.lab10.projeto.Map;
import br.unicamp.mc322.lab10.projeto.mapObjects.Command;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.SpellCaster;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.SpellTypes;

import java.util.Scanner;

public abstract class HeroController implements Controller {
	private Hero personagem;
	protected static final int MOVE_DICES = 2;
	protected Command direction;
	protected int remainingSteps;
	protected boolean moving = false; 
	
	
	public HeroController(Hero personagem) {
		this.personagem = personagem;
	}

	public Hero getCharacter() {
		return personagem;
	}
	
	public int rollRedDices(int n) {
		int result = 0;
		Random gerador = new Random();
		for(int i = 0; i < n; i ++) {
			result += 1 + gerador.nextInt(6);
		}
		return result;
	}
	
	private int rollWhiteDices(int qtde, WhiteDiceSides lookingFor) {
		/* rola n d6 com 1 lado parar monster defense, 2 lados para hero defense e 3 para ataque.
		 * Sendo especificado o que o invocador busca, faz a soma das n ocorrencias aleat�rias
		 * e a retorna. 
		 * Ex: funcao eh chamada buscando o ataque do jogador com 6 dados,
		 * logo sao rolados 6 dados e eh somado a quantidade de vezes que cada dado obteve a face
		 * ataque. */	
		int sum = 0, number;
		Random dice = new Random();
        
        for(int i = 0; i < qtde; i++) {
            number = dice.nextInt(6) + 1;
            
            if (number == 1 && lookingFor == WhiteDiceSides.MONSTER_DEFENSE)
            	sum += 1;
            
            else if ((number == 2 || number == 3) && lookingFor == WhiteDiceSides.HERO_DEFENSE)
            	sum += 1;
            
            else if (lookingFor == WhiteDiceSides.ATTACK)
            	sum += 1;
        }
        
        return sum;
	}
	
	public int rollAttackDices() {
		//rola todos os dados de ataque do personagem e retorna o numero de caveiras obtidas
		return rollWhiteDices(personagem.getAttackDices(),WhiteDiceSides.ATTACK);
	}
	
	public int rollDefenseDices() {
		//rola todos os dados de defesa do personagem e retorna o numero de escudos obtidos
		return rollWhiteDices(personagem.getDefenseDices(),WhiteDiceSides.HERO_DEFENSE);
	}
	
	public void attack(Controller target) {
		//rola os dados de ataque do personagem, faz o alvo rolar os dados de defesa e chama a função de ataque do personagem
		int skulls = rollAttackDices();
		int shields = target.rollDefenseDices();
		if (skulls > shields)
			personagem.attack(target.getCharacter(), skulls - shields);
	}
	
	public void addToInventory(CanCarry item) {
		/* Adiciona um item qualquer(carregavel) ao inventario, se for equipamento e melhor que o atual,
		 * equipa automaticamente */
		getCharacter().addToInventory(item);
	}
	
	public void usePotion() {
		getCharacter().usePotion();
	}
	
	protected void callMove(Map map) {
		/* Chama movimentacao do player, se encontrar com obstaculo, desativa sinal
		 * de que esta se movimentando */
		if(!getCharacter().move(direction, map))
			moving = false;
	}
	
	public void playTurn(Map map){
		/* Turno do jogador */
		Scanner scanner = new Scanner(System.in);
		
		if(!moving) {
			//action(map,scanner);
			newDirection(map,scanner);
		} else {
			callMove(map);
			//action(map,scanner);
		}
		
		if(--remainingSteps <= 0)
			moving = false;
	}
	
	public void useMagic() {
		int n = 0;//precisa ser lido do teclado o indice da magia na lista de magias do personagem
		SpellCaster caster;
		Spell spell;
		Controller target;
		Controller[] adjacentTargets;
		int dice;
		if (personagem.getType() == GameTypeObjects.ELF || personagem.getType() == GameTypeObjects.WIZARD) {
			caster = (SpellCaster)personagem;
			spell = chooseSpell(caster.getSpells());
			dice = rollRedDices(1); //rolagem do dado que define se a magia foi sucesso ou não
			
			if(spell.getSpellType() == SpellTypes.SUPPORT) {
				caster.castSpell(this, spell, dice);//magias de support são sempre utilizadas no próprio usuario
				
			}else if(spell.getSpellType() == SpellTypes.ATTACK) {
				target = findTarget();//chamar funcao que escolhe o alvo
				caster.castSpell(target, spell, dice);
				
			}
		}
		
	}
	
	//Leitura de um numero do teclado, pode ser removida se houver uma classe mais apropriada para ela
	public int numberFromKeyboard() {
		Scanner leitor = new Scanner(System.in);
		int entrada;
		entrada = leitor.nextInt();
		return entrada;
	}
	
	public void displaySpells() {
		
	}
	
	public abstract Spell chooseSpell(Spell[] spells);
	
	protected abstract void newDirection(Map map, Scanner scanner);		//possibilidade de controlar todos os demais herois
	
	protected abstract void action(Map map, Scanner scanner);
}
