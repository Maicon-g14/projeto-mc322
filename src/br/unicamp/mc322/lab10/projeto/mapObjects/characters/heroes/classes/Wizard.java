package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.PlayableClasses;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;

public class Wizard extends Hero {
	private static final char SPRITE = 'W';
	private static final String NAME = "Wizard";
	private static final GameTypeObjects ID = GameTypeObjects.WIZARD;
	private static final int HP = 4;
	private static final int MP = 4;
	private static final int INTELLIGENCE = 6;
	private static final int ATTACK_DICES = 1;
	private static final int DEFENSE_DICES = 2;
	
	public Wizard() {
		super(NAME,ID,HP,MP,INTELLIGENCE,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES);
	}
	
	public Wizard(CanCarry[] initialEquipment) {
		super(NAME,ID,HP,MP,INTELLIGENCE,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES);
		inventory = initialEquipment;
		inventoryLoad = initialEquipment.length;
	}

}
