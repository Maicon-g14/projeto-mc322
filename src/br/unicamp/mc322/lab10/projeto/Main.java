//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

import br.unicamp.mc322.lab10.projeto.map.MapMode;

public class Main {

	public static void main(String[] args) {
		HeroQuest game = new HeroQuest(GameMode.STANDARD, MapMode.PREDEFINED, PlayableClasses.ELF, "Mago implacavel");

		game.startGame();
	}

}
