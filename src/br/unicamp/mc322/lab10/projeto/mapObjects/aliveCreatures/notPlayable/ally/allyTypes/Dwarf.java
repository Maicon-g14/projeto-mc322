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

public class Dwarf extends Ally{
	private static final char SPRITE = 'D';
	private static final String NAME = "Dwarf";
	private static final GameTypeObjects ID = GameTypeObjects.DWARF;
	private static final int HP = 2;
	private static final int MP = 2;
	private static final int ATTACK_DICES = 1;
	private static final int DEFENSE_DICES = 1;
	private static final HeroClass HERO_CLASS = HeroClass.DWARF;
	
	public Dwarf(Coordinate position) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,HERO_CLASS,position);
	}
	
	public Dwarf(String name,Coordinate position) {
		super(name,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,HERO_CLASS,position);
	}
}
