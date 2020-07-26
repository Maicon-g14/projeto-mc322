//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

import br.unicamp.mc322.lab10.projeto.map.MapMode;

public class Main {

	public static void main(String[] args) {
		HeroQuest game = new HeroQuest(GameMode.STANDARD, MapMode.RANDOM, PlayableClasses.WIZARD, "Mago implacavel");

		game.startGame();
	}

}
