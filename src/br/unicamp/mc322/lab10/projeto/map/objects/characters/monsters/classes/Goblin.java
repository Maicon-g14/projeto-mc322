package br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.classes;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.Monster;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;

public class Goblin extends Monster {

	private static final char SPRITE = 'G';
	private static final String NAME = "Goblin";
	private static final GameTypeObjects ID = GameTypeObjects.GOBLIN;
	private static final int ATTACK_DICES = 3;
	private static final int DEFENSE_DICES = 1;
	private static final int HP = 6;
	private static final int INTELLIGENCE = 1;

	public Goblin(Coordinate position) {
		super(NAME, ID, HP, INTELLIGENCE, new Sprite(SPRITE), ATTACK_DICES, DEFENSE_DICES, position);
	}

	public Goblin(Coordinate position, CanCarry[] initialEquipment) {
		super(NAME, ID, HP, INTELLIGENCE, new Sprite(SPRITE), ATTACK_DICES, DEFENSE_DICES, position, initialEquipment);
	}
}
