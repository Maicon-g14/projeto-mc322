package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.Spell;

public class Wizard extends SpellCaster {
	private static final char SPRITE = 'W';
	private static final String NAME = "Wizard";
	private static final GameTypeObjects ID = GameTypeObjects.WIZARD;
	private static final int HP = 4;
	private static final int MP = 6;
	private static final int ATTACK_DICES = 1;
	private static final int DEFENSE_DICES = 2;
	
	public Wizard() {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES);
	}
	
	public Wizard(Spell[] initialSpells) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES, initialSpells);
	}

	public Wizard(CanCarry[] initialEquipment) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,initialEquipment);
	}

	public Wizard(CanCarry[] initialEquipment, Spell[] initialSpells) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,initialEquipment, initialSpells);
	}

}
