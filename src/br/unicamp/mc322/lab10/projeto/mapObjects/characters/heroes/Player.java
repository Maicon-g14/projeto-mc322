package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes;
import java.util.Scanner;

import br.unicamp.mc322.lab10.projeto.mapObjects.Command;
import br.unicamp.mc322.lab10.projeto.Map;

public class Player extends HeroController {
	
	public Player(Hero personagem, String name) {
		super(personagem);
		personagem.setPlayerName(name,personagem.getId());
	}
	
	public Command readCommandFromKeyboard(Scanner scanner) {
		/* Pergunta ao player a acao que pretende fazer */
		String entrada;
		System.out.println("Acao pretendida: ");
		entrada = scanner.nextLine();
		switch(entrada.toUpperCase()) {
		case "W" : return Command.MOVE_UP;
		case "S" : return Command.MOVE_DOWN;
		case "D" : return Command.MOVE_RIGHT;
		case "A" : return Command.MOVE_LEFT;
		case "P" : return Command.SEARCH;
		default : return null;
		}
	}


	public void playTurn(Map mapa){
		int steps = rollDices(2);
		while(steps > 0) {
			Scanner scanner = new Scanner(System.in);
			Command newCommand = readCommandFromKeyboard(scanner);
			if(newCommand != null) {
				switch(newCommand) {
				//Adicionar outras açoes que o jogador podera fazer
					case SEARCH : treasureSearch(mapa);
					default :	{
									getCharacter().move(newCommand, mapa);
									steps--;
								}
				}
			}
		}
	}
	
	
	public void treasureSearch(Map mapa) {
		//Procurar um tesouro no mapa, tem chance de encontrar um monstro
	}
	
	
	
}