package br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.Command;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.classes.SpellCaster;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;

import java.util.Scanner;

public class Player extends HeroController {

	public Player(Hero personagem, String name) {
		super(personagem);
		personagem.setPlayerName(name);
	}
	
	@Override
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

	public Spell chooseSpell(Spell[] spells) {
		int n;
		Spell chosenSpell;
		SpellCaster caster = (SpellCaster)getCharacter();
		
		displaySpells();
		System.out.println("Selecione o numero da magia: ");
		n = numberFromKeyboard();
		
		if (n < caster.getQtdSpells()) {
			chosenSpell = spells[n];
			return chosenSpell;
		}

		return null;
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
			default:
				break;
		}
	}

	private boolean action(Map map, Scanner scanner) {
		/* Pergunta ao player se quer fazer outra acao alem de andar */
		System.out.println("Acao: (P = procurar, A = atacar, M = usar magia, , U = usar item)");
		String entrada = scanner.nextLine();

		switch (entrada.toUpperCase()) {
			case "P":
				map.search(getCharacter());
				break;
			case "M":
				useMagic(map);
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
		/* Define direcao e distancia que o personagem deve andar ao longo dos trunos */
		readMovementDirection(scanner);

		if(direction != Command.STOP) {
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
			System.out.println("Quantidade de passos (max: " + maxSteps + "): ");

			if (!scanner.hasNextInt())
				scanner.next();
			else
				amount = scanner.nextInt();

		} while (amount > maxSteps || amount < 0);

		System.out.println("lado: " + amount);

		return amount;
	}

}