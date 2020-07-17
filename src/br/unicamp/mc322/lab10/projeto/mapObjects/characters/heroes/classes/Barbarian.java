package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.ally.HeroClass;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;

public class Barbarian extends Hero {

	private static final char SPRITE = 'B';
	private static final String NAME = "Barbarian";
	private static final GameTypeObjects ID = GameTypeObjects.BARBARIAN;
	private static final int HP = 1;
	private static final int MP = 1;
	private static final int ATTACK_DICES = 1;
	private static final int DEFENSE_DICES = 1;
	
	public Barbarian() {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES);
	}
	
	public Barbarian(CanCarry[] initialEquipment) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES);
		inventory = initialEquipment;
	}
	
}
