//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.ally.allyTypes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.ally.Ally;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.ally.HeroClass;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class Wizard extends Ally{
	private static final char SPRITE = 'W';
	private static final String NAME = "Wizard";
	private static final GameTypeObjects ID = GameTypeObjects.WIZARD;
	private static final int HP = 4;
	private static final int MP = 4;
	private static final int ATTACK_DICES = 1;
	private static final int DEFENSE_DICES = 1;
	private static final HeroClass HERO_CLASS = HeroClass.WIZARD;
	
	public Wizard(Coordinate position) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,HERO_CLASS,position);
	}
	
	public Wizard(String name,Coordinate position) {
		super(name,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,HERO_CLASS,position);
	}
}
