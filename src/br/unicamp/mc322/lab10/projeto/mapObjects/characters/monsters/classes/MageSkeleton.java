package br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.classes;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.Monster;

public class MageSkeleton extends Monster {

	private static final char SPRITE = 'M';
	private static final String NAME = "Mage Skeleton";
	private static final GameTypeObjects ID = GameTypeObjects.MAGE_SKELETON;
	private static final int ATTACK_DICES = 1;
	private static final int DEFENSE_DICES = 1;
	private static final int HP = 3;
	private static final int MP = 5;
	
	public MageSkeleton(Coordinate position) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,position);
	}
}
