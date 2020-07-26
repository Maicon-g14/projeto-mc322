//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

import java.util.Scanner;

import br.unicamp.mc322.lab10.projeto.map.MapMode;

public class Main {
	
	private static GameMode readGameMode(Scanner scanner) {
		int mode = 0;
		
		do {
			System.out.println("Escolha a dificuldade do jogo:\n 1. Padrão.\n 2. Difícil.");

			if (!scanner.hasNextInt())
				scanner.next();
			else
				mode = scanner.nextInt();

		} while (mode != 1 && mode != 2);
		
		if (mode == 1)
			return GameMode.STANDARD;
		
		return GameMode.HARD;
	}
	
	private static MapMode readMapMode(Scanner scanner) {
		int mapType = 0;
		
		do {
			System.out.println("Escolha o tipo de mapa do jogo:\n 1. Pré-definido.\n 2. Aleatório.");

			if (!scanner.hasNextInt())
				scanner.next();
			else
				mapType = scanner.nextInt();

		} while (mapType != 1 && mapType != 2);
		
		if (mapType == 1)
			return  MapMode.PREDEFINED;
		
		return MapMode.RANDOM;
	}
	
	private static PlayableClasses readPlayerClass(Scanner scanner) {
		int player = 0;
		
		do {
			System.out.println("Escolha o heroi que deseja controlar:\n 1. Anao\n 2. Barbaro\n 3. Elfo\n 4. Mago");

			if (!scanner.hasNextInt())
				scanner.next();
			else
				player = scanner.nextInt();

		} while (player != 1 && player != 2 && player != 3 && player != 4);
		
		switch(player) {
		case 1:
			return PlayableClasses.DWARF;
		case 2:
			return PlayableClasses.BARBARIAN;
		case 3:
			return PlayableClasses.ELF;
		}
		
		return PlayableClasses.WIZARD;
	}
	
	private static String readPlayerName(Scanner scanner) {
		String name = null;
		
		System.out.println("Digite um nome para o seu personagem: ");
		
		do {
		
			name = scanner.nextLine();

		} while (name.isEmpty());
		
		return name;
	}

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("--- Hero Quest ---");
				
		GameMode gameMode = readGameMode(scanner);
		MapMode mapMode = readMapMode(scanner);
		PlayableClasses playerClass = readPlayerClass(scanner);
		String playerName = readPlayerName(scanner);
		
		HeroQuest game = new HeroQuest(gameMode, mapMode, playerClass, playerName);

		game.startGame();
		
		scanner.close();
	}

}
