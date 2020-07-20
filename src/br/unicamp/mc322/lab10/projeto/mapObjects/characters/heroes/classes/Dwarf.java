package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;

public class Dwarf extends Hero{

	private static final char SPRITE = 'D';
	private static final String NAME = "Dwarf";
	private static final GameTypeObjects ID = GameTypeObjects.DWARF;
	private static final int HP = 7;
	private static final int MP = 3;
	private static final int ATTACK_DICES = 2;
	private static final int DEFENSE_DICES = 2;
	
	public Dwarf() {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES);
	}
	
	public Dwarf(CanCarry[] initialEquipment) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,initialEquipment);
	}
	
}
