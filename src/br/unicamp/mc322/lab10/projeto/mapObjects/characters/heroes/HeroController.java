package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes;

import java.util.Random;
import java.util.Scanner;

import br.unicamp.mc322.lab10.projeto.Map;
import br.unicamp.mc322.lab10.projeto.mapObjects.Command;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;

public abstract class HeroController implements Controller {
	private Hero personagem;
	protected static final int MOVE_DICES = 2;
	protected Command direction;
	protected int remainingSteps;
	protected boolean moving = false; 
	
	public HeroController(Hero personagem) {
		this.personagem = personagem;
	}

	public int rollRedDices(int n) {
		int result = 0;
		Random gerador = new Random();
		for(int i = 0; i < n; i ++) {
			result += 1 + gerador.nextInt(6);
		}
		return result;
	}
	
	public int rollAttackDices() {
		//rola todos os dados de ataque do personagem e retorna o numero de caveiras obtidas
		return rollWhiteDices(personagem.getAttackDices(),WhiteDiceSides.ATTACK);
	}
	
	public int rollDefenseDices() {
		//rola todos os dados de defesa do personagem e retorna o numero de escudos obtidos
		return rollWhiteDices(personagem.getDefenseDices(),WhiteDiceSides.HERO_DEFENSE);
	}
	
	public Hero getCharacter() {
		return personagem;
	}

	public void attack(Controller target) {
		//rola os dados de ataque do personagem, faz o alvo rolar os dados de defesa e chama a função de ataque do personagem
		int skulls = rollAttackDices();
		int shields = rollDefenseDices();
		if (skulls > shields)
			personagem.attack(target.getCharacter(), skulls - shields);
	}
	
	public void addToInventory(CanCarry item) {
		/* Adiciona um item qualquer(carregavel) ao inventario, se for equipamento e melhor que o atual,
		 * equipa automaticamente */
		getCharacter().addToInventory(item);
	}
	
	public void askPotion() {
		getCharacter().askPotion();
	}
	
	public boolean playTurn(Map map){
		/* Turno do jogador */
		boolean turn;
		Scanner scanner = new Scanner(System.in);
		
		if(!moving) {
			turn = action(map,scanner);
			
			if(!turn)
				return turn;
			
			newDirection(map,scanner);
		} else {
			callMove(map);
			turn = action(map,scanner);
		}
		
		if(--remainingSteps <= 0)
			moving = false;
		
		return turn;
	}
	
	protected void callMove(Map map) {
		/* Chama movimentacao do player, se encontrar com obstaculo, desativa sinal
		 * de que esta se movimentando */
		if(!getCharacter().move(direction, map))
			moving = false;
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

	protected abstract void newDirection(Map map, Scanner scanner);		//possibilidade de controlar todos os demais herois
	
	protected abstract boolean action(Map map, Scanner scanner);
}
