package br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.classes;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;

public class Dwarf extends Hero {

	private static final char SPRITE = 'D';
	private static final String NAME = "Dwarf";
	private static final GameTypeObjects ID = GameTypeObjects.DWARF;
	private static final int HP = 7;
	private static final int INTELLIGENCE = 3;
	private static final int ATTACK_DICES = 2;
	private static final int DEFENSE_DICES = 2;

	public Dwarf() {
		super(NAME, ID, HP, INTELLIGENCE, new Sprite(SPRITE), ATTACK_DICES, DEFENSE_DICES);
	}

	public Dwarf(CanCarry[] initialEquipment) {
		super(NAME, ID, HP, INTELLIGENCE, new Sprite(SPRITE), ATTACK_DICES, DEFENSE_DICES, initialEquipment);
	}

}
