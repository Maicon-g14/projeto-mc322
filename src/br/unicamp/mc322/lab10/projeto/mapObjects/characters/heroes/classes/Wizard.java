package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.ally.HeroClass;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;

public class Wizard extends Hero {
	private static final char SPRITE = 'W';
	private static final String NAME = "Wizard";
	private static final GameTypeObjects ID = GameTypeObjects.WIZARD;
	private static final int HP = 4;
	private static final int MP = 4;
	private static final int ATTACK_DICES = 1;
	private static final int DEFENSE_DICES = 1;
	private static final HeroClass HERO_CLASS = HeroClass.WIZARD;

	public Wizard(String name) {
		super(name,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,HERO_CLASS);
	}
	
	public Wizard() {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,HERO_CLASS);
	}

}
