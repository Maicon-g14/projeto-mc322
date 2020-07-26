package br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.classes;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;

public class Elf extends SpellCaster {

	private static final char SPRITE = 'E';
	private static final String NAME = "Elf";
	private static final GameTypeObjects ID = GameTypeObjects.ELF;
	private static final int HP = 6;
	private static final int INTELLIGENCE = 4;
	private static final int ATTACK_DICES = 2;
	private static final int DEFENSE_DICES = 2;

	public Elf() {
		super(NAME, ID, HP, INTELLIGENCE, new Sprite(SPRITE), ATTACK_DICES, DEFENSE_DICES);
	}

	public Elf(Spell[] initialSpells) {
		super(NAME, ID, HP, INTELLIGENCE, new Sprite(SPRITE), ATTACK_DICES, DEFENSE_DICES, initialSpells);
	}

	public Elf(CanCarry[] initialEquipment) {
		super(NAME, ID, HP, INTELLIGENCE, new Sprite(SPRITE), ATTACK_DICES, DEFENSE_DICES, initialEquipment);
	}

	public Elf(CanCarry[] initialEquipment, Spell[] initialSpells) {
		super(NAME, ID, HP, INTELLIGENCE, new Sprite(SPRITE), ATTACK_DICES, DEFENSE_DICES, initialEquipment, initialSpells);
	}

}
