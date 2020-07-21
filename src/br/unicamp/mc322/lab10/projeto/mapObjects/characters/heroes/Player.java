package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes;
import java.util.Scanner;

import br.unicamp.mc322.lab10.projeto.mapObjects.Command;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.SpellCaster;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.Map;

public class Player extends HeroController {
	
	
	public Player(Hero personagem, String name) {
		super(personagem);
		personagem.setPlayerName(name,personagem.getId());
	}
	
	private int getFinalSteps(Scanner scanner, int maxSteps) {
		/* Pergunta ao player quantidade de passos que quer dar */
		int amount = maxSteps+1;
		
		do {
			System.out.println("Quantidade de passos (max: " + maxSteps + "): ");
			
			if(!scanner.hasNextInt())
				scanner.next();
			else
				amount = scanner.nextInt();
		
		} while(amount > maxSteps || amount < 0);
		
		System.out.println("lado: "+amount);
		
		return amount;
	}
	
	public void readMovementDirection(Scanner scanner) {
		/* Pergunta ao player lado para se mover */
		
		
		char in; //= scanner.nextLine();
		
		do {
			System.out.println("Lado para se mover(WASD): ");
			in = scanner.next().toUpperCase().charAt(0);
		
		} while(in != 'W' && in != 'A' && in != 'S' && in != 'D');
		
		System.out.println("lado: "+in);
		switch(in) {
			case 'W' : 
				direction = Command.MOVE_UP;
				break;
			case 'S' : 
				direction = Command.MOVE_DOWN;
				break;
			case 'D' : 
				direction = Command.MOVE_RIGHT;
				break;
			case 'A' : 
				direction = Command.MOVE_LEFT;
				break;
		}
	}
	
	protected void action(Map map, Scanner scanner) {
		/* Pergunta ao player se quer fazer outra acao alem de andar */
		System.out.println("Acao nesse turno: ");
		String entrada = scanner.nextLine();
		
		switch(entrada.toUpperCase()) {
		/*case "P" : return Command.SEARCH;
		case "M" : return Command.USE_MAGIC;
		case "A" : return Command.ATTACK;
		case "I" : return Command.USE_ITEM;
		default : return null;*/
		}
	}
	
	protected void newDirection(Map map, Scanner scanner) {
		/* Define direcao e distancia que o personagem deve andar ao longo dos trunos */
		readMovementDirection(scanner);
		
		int steps = rollRedDices(MOVE_DICES);		//rola dados de movimento
		remainingSteps = getFinalSteps(scanner,steps);
		
		moving = true;
		callMove(map);
	}
	
	public Spell chooseSpell(Spell[] spells) {
		int n;
		Spell chosenSpell;
		displaySpells();
		n = numberFromKeyboard();
		if(n < spells.length) {
			chosenSpell = spells[n];
			return chosenSpell;
		}
		return null;
	}
	
	public void treasureSearch(Map mapa) {
		//Procurar um tesouro no mapa, tem chance de encontrar um monstro
	}	
	
}