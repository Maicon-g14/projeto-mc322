package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.Spell;

public class Elf extends SpellCaster {
	private static final char SPRITE = 'E';
	private static final String NAME = "Elf";
	private static final GameTypeObjects ID = GameTypeObjects.ELF;
	private static final int HP = 6;
	private static final int MP = 4;
	private static final int ATTACK_DICES = 2;
	private static final int DEFENSE_DICES = 2;
	
	public Elf() {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES);
	}
	
	public Elf(Spell[] initialSpells) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,initialSpells);
	}
	
	public Elf(CanCarry[] initialEquipment) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,initialEquipment);
	}
	
	public Elf(CanCarry[] initialEquipment, Spell[] initialSpells) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,initialEquipment,initialSpells);
	}
	
}
