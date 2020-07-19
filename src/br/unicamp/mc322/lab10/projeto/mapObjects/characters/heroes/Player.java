package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes;
import java.util.Scanner;

import br.unicamp.mc322.lab10.projeto.mapObjects.Command;
import br.unicamp.mc322.lab10.projeto.Map;

public class Player extends HeroController {
	private static final int MOVE_DICES = 2;
	private Command direction;
	private int remainingSteps;
	private boolean moving = false; 
	
	
	public Player(Hero personagem, String name) {
		super(personagem);
		personagem.setPlayerName(name,personagem.getId());
	}
	
	public void readMovementDirection(Scanner scanner) {
		/* Pergunta ao player lado para se mover */
		System.out.println("Lado para se mover(WASD): ");
		
		String in = scanner.nextLine();
		
		switch(in.toUpperCase()) {
			case "W" : 
				direction = Command.MOVE_UP;
				break;
			case "S" : 
				direction = Command.MOVE_DOWN;
				break;
			case "D" : 
				direction = Command.MOVE_RIGHT;
				break;
			case "A" : 
				direction = Command.MOVE_LEFT;
				break;
		}
	}
	
	private void action(Map map, Scanner scanner) {
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
		
		return amount;
	}
	
	public void playTurn(Map map){
		/* Turno do jogador */
		Scanner scanner = new Scanner(System.in);
		
		if(!moving) {
			action(map,scanner);
			newDirection(map,scanner);
		} else {
			getCharacter().move(direction, map);
			action(map,scanner);
		}
		
		if(--remainingSteps <= 0)
			moving = false;
	}
	
	private void newDirection(Map map, Scanner scanner) {
		/* Define direcao e distancia que o personagem deve andar ao longo dos trunos */
		readMovementDirection(scanner);
		
		int steps = rollRedDices(MOVE_DICES);		//rola dados de movimento
		remainingSteps = getFinalSteps(scanner,steps);
		
		getCharacter().move(direction, map);
		moving = true;
	}
	
	public void treasureSearch(Map mapa) {
		//Procurar um tesouro no mapa, tem chance de encontrar um monstro
	}	
	
}