package br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.Command;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.classes.SpellCaster;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellTypes;

import java.util.Random;
import java.util.Scanner;

public abstract class HeroController implements Controller {

	private Hero personagem;
	protected Command direction;
	protected int remainingSteps;
	protected boolean moving = false;

	protected static final int MOVE_DICES = 2;

	public HeroController(Hero personagem) {
		this.personagem = personagem;
	}

	public boolean playTurn(Map map) {
		/* Turno de um personagem, caso ja nao esteja em movimento,
		 * consiste em uma acao e a possibilidade de se movimentar */
		boolean turn = true;
		Scanner scanner = new Scanner(System.in);

		if (!moving) {
			turn = action(map, scanner);

			if (!turn) {
				return turn;
			}

			newDirection(map, scanner);
		} else if (!callMove(map)) {
			moving = false;
		}

		if (--remainingSteps <= 0) {
			moving = false;
		}

		return turn;
	}

	public int rollRedDices(int n) {
		int result = 0;
		Random gerador = new Random();

		for (int i = 0; i < n; i++) {
			result += 1 + gerador.nextInt(6);
		}

		return result;
	}

	public int rollAttackDices() {
		//rola todos os dados de ataque do personagem e retorna o numero de caveiras obtidas
		return rollWhiteDices(personagem.getAttackDices(), WhiteDiceSides.ATTACK);
	}

	public int rollDefenseDices() {
		//rola todos os dados de defesa do personagem e retorna o numero de escudos obtidos
		return rollWhiteDices(personagem.getDefenseDices(), WhiteDiceSides.HERO_DEFENSE);
	}

	//Leitura de um numero do teclado, pode ser removida se houver uma classe mais apropriada para ela
	public int numberFromKeyboard() {
		@SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);

		int entrada;
		entrada = leitor.nextInt();

		return entrada;
	}

	public Hero getCharacter() {
		return personagem;
	}

	public void attack(Controller target) {
		//rola os dados de ataque do personagem, faz o alvo rolar os dados de defesa e chama a função de ataque do personagem
		int skulls = rollAttackDices();
		int shields = rollDefenseDices();

		if (skulls > shields) {
			personagem.attack(target.getCharacter(), skulls - shields);
		}
	}

	public void addToInventory(CanCarry item) {
		/* Adiciona um item qualquer(carregavel) ao inventario, se for equipamento e melhor que o atual,
		 * equipa automaticamente */
		getCharacter().addToInventory(item);
	}

	public void askPotion() {
		getCharacter().askPotion();
	}


	public void useMagic(Map map) {
		SpellCaster caster;
		Spell spell;
		Controller target;
		int dice;

		if (isMagicUser()) {
			caster = (SpellCaster) personagem;
			spell = chooseSpell(caster.getSpells());
			dice = rollRedDices(1); //rolagem do dado que define se a magia foi sucesso ou não

			if (spell.getSpellType() == SpellTypes.SUPPORT) {
				caster.castSpell(this, spell, dice);//magias de support são sempre utilizadas no próprio usuario

			} else if (spell.getSpellType() == SpellTypes.ATTACK) {
				target = map.findTarget(this);//chamar funcao que escolhe o alvo
				caster.castSpell(target, spell, dice);

			}
		}

	}

	public void displaySpells() {
		Spell[] spellList;
		if(isMagicUser()) {
			SpellCaster caster = (SpellCaster)personagem;
			spellList = caster.getSpells();
			for(int i = 0; i < caster.getQtdSpells(); i++) {
				System.out.println(i + "- " + spellList[i].getName());
			}
		}
	}

	protected boolean callMove(Map map) {
		/* Chama movimentacao do player, se encontrar com obstaculo, desativa sinal
		 * de que esta se movimentando e para a movimentacao*/
		if (!getCharacter().move(direction, map)) {
			moving = false;
			return false;
		}
		
		return true;
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

		for (int i = 0; i < qtde; i++) {
			number = dice.nextInt(6) + 1;

			if (((number == 1 && lookingFor == WhiteDiceSides.MONSTER_DEFENSE) ||
					((number == 2 || number == 3) && lookingFor == WhiteDiceSides.HERO_DEFENSE)) ||
					(lookingFor == WhiteDiceSides.ATTACK)) {
				sum += 1;
			}
		}

		return sum;
	}
	
	private boolean isMagicUser() {
		if(personagem.getId() == GameTypeObjects.ELF || personagem.getId() == GameTypeObjects.WIZARD)
			return true;
		return false;
	}

	public abstract Spell chooseSpell(Spell[] spells);

	protected abstract void newDirection(Map map, Scanner scanner);        //possibilidade de controlar todos os demais herois

	protected abstract boolean action(Map map, Scanner scanner);
}
