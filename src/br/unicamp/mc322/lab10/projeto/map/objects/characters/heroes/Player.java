package br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.Command;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.classes.SpellCaster;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.AreaSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SelfSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellTypes;

import java.util.Scanner;

public class Player extends HeroController {

	public Player(Hero person, String name) {
		super(person);
		person.setPlayerName(name);
	}

	@Override
	public boolean playTurn(Map map) {
		/* Turno de um person, caso ja nao esteja em movimento,
		 * consiste em uma acao e a possibilidade de se movimentar */
		boolean turn = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Seu turno " + getCharacter().getName() + ":");

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

	public Spell chooseSpell(Spell[] spells, Scanner scanner) {
		int n;
		Spell chosenSpell;

		if (spells == null) {
			System.out.println("Voce nao sabe nenhum feitico!");
			return null;
		}

		SpellCaster caster = (SpellCaster) getCharacter();

		displaySpells();
		System.out.println("Selecione o numero da magia: ");
		n = scanner.nextInt();
		n--;

		if (n > 0 && n < caster.getQtdSpells()) {
			chosenSpell = spells[n];
			return chosenSpell;
		}

		return null;
	}
	
	private void displaySpells() {
		Spell[] spellList;
		if(GameTypeObjects.isMagicUser(getCharacter())) {
			SpellCaster caster = (SpellCaster)getCharacter();
			spellList = caster.getSpells();
			for(int i = 0; i < caster.getQtdSpells(); i++) {
				System.out.println(i+1 + ". " + spellList[i].getName());
			}
		}
	}
	
	private void useMagic(Map map, Scanner scanner) {

		if (GameTypeObjects.isMagicUser(getCharacter())) {		//se atacante for do tipo que usa magias
			
			SpellCaster caster = (SpellCaster) getCharacter();
			Spell spell = chooseSpell(caster.getSpells(), scanner);		//sobrescrever essa parte pro npc
			
			if (spell == null) {
				return;
			}
			
			int dice = rollRedDices(1);		//rolagem do dado que define se a magia foi sucesso ou nao

			if (spell.getSpellType() == SpellTypes.SUPPORT) {
				System.out.println(getCharacter().getName() + " tenta usar o feitico " + spell.getName() + " em si mesmo!");
				if (spell.getId() == GameTypeObjects.TELEPORT) {
					caster.castSpell(map, this, (SelfSpell) spell, dice, scanner);
				} else {
					caster.castSpell(this, (SelfSpell) spell, dice);		//magias de support sao sempre utilizadas no proprio usuario
				}
			} else if (spell.getSpellType() == SpellTypes.ATTACK) {
				castAttack(map,spell,dice,caster);
			
			} else if (spell.getSpellType() == SpellTypes.AREA_ATTACK) {
				castAreaAttack(map,(AreaSpell) spell,dice,caster);
			}
		}

	}

	public void readMovementDirection(Scanner scanner) {
		/* Pergunta ao player lado para se mover */
		char in;

		System.out.println("Lado para se mover: (W, A, S ou D)");
		in = scanner.next().toUpperCase().charAt(0);

		if (in != 'W' && in != 'A' && in != 'S' && in != 'D') {
			in = ' ';
		}

		switch (in) {
			case 'W':
				direction = Command.MOVE_UP;
				break;
			case 'S':
				direction = Command.MOVE_DOWN;
				break;
			case 'D':
				direction = Command.MOVE_RIGHT;
				break;
			case 'A':
				direction = Command.MOVE_LEFT;
				break;
			case ' ':
				direction = Command.STOP;
				break;
			default:
				break;
		}
	}

	private boolean action(Map map, Scanner scanner) {
		/* Pergunta ao player se quer fazer outra acao alem de andar */
		System.out.println("Acao: (P = procurar, A = atacar, M = usar magia, U = usar item)");
		String entrada = scanner.nextLine();

		switch (entrada.toUpperCase()) {
			case "P":
				map.search(getCharacter());
				break;
			case "M":
				useMagic(map, scanner);
				break;
			case "A":
				map.callAttack(this);
				break;
			case "U":
				return map.use(getCharacter());
			default:
				break;
		}

		return true;
	}

	private void newDirection(Map map, Scanner scanner) {
		/* Define direcao e distancia que o person deve andar ao longo dos trunos */
		readMovementDirection(scanner);

		if (direction != Command.STOP) {
			int steps = rollRedDices(MOVE_DICES);        //rola dados de movimento
			remainingSteps = getFinalSteps(scanner, steps);

			moving = true;
			callMove(map);
		}
	}

	private int getFinalSteps(Scanner scanner, int maxSteps) {
		/* Pergunta ao player quantidade de passos que quer dar */
		int amount = maxSteps + 1;

		do {
			System.out.print("Quantidade de passos (max: " + maxSteps + "): ");

			if (!scanner.hasNextInt())
				scanner.next();
			else
				amount = scanner.nextInt();

		} while (amount > maxSteps || amount < 0);

		return amount;
	}


}