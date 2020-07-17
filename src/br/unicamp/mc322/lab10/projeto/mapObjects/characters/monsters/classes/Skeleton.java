package br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.classes;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.enemy.MonsterClass;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.Monster;

public class Skeleton extends Monster{

	private static final char SPRITE = 'K';
	private static final String NAME = "Skeleton";
	private static final GameTypeObjects ID = GameTypeObjects.SKELETON;
	private static final int ATTACK_DICES = 1;
	private static final int DEFENSE_DICES = 1;
	private static final int HP = 1;
	private static final int MP = 1;
	private static final MonsterClasses MONSTER_CLASS = MonsterClasses.SKELETON;
	
	public Skeleton() {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,MONSTER_CLASS);
	}

	public Skeleton(Coordinate position) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,MONSTER_CLASS,position);
	}
}
