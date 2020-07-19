package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.PlayableClasses;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;

public class Barbarian extends Hero {

	private static final char SPRITE = 'B';
	private static final String NAME = "Barbarian";
	private static final GameTypeObjects ID = GameTypeObjects.BARBARIAN;
	private static final int HP = 8;
	private static final int MP = 8;
	private static final int INTELLIGENCE = 2;
	private static final int ATTACK_DICES = 3;
	private static final int DEFENSE_DICES = 2;
	
	public Barbarian() {
		super(NAME,ID,HP,MP, INTELLIGENCE, new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES);
	}
	
	public Barbarian(CanCarry[] initialEquipment) {
		super(NAME,ID,HP,MP, INTELLIGENCE, new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES);
		inventory = initialEquipment;
		inventoryLoad = initialEquipment.length;
	}
	
}
