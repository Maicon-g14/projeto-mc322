package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes;
import java.util.Random;

import br.unicamp.mc322.lab10.projeto.Map;
import br.unicamp.mc322.lab10.projeto.mapObjects.Command;

public class CpuHero extends HeroController {
	
	public CpuHero(Hero personagem) {
		super(personagem);
	}


	public void playTurn(Map mapa){
		Command newCommand = Command.MOVE_DOWN;
		getCharacter().move(newCommand, mapa);
	}
	
	
}
