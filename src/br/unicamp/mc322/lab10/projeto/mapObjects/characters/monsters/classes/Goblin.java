package br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.classes;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.Monster;

public class Goblin extends Monster {

	private static final char SPRITE = 'G';
	private static final String NAME = "Goblin";
	private static final GameTypeObjects ID = GameTypeObjects.GOBLIN;
	private static final int ATTACK_DICES = 2;
	private static final int DEFENSE_DICES = 2;
	private static final int HP = 6;
	private static final int MP = 1;

	public Goblin(Coordinate position) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,position);
	}
}
