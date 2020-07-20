//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

public class Main {

	public static void main(String[] args) {
	
		HeroQuest game = new HeroQuest(GameMode.STANDART, MapMode.PREDEFINED, PlayableClasses.WIZARD, "Mago implacavel");
	
		game.startGame();
	}

}
