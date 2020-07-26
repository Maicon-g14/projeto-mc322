package br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.classes;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.Monster;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;

public class Skeleton extends Monster {

	private static final char SPRITE = 'K';
	private static final String NAME = "Skeleton";
	private static final GameTypeObjects ID = GameTypeObjects.SKELETON;
	private static final int ATTACK_DICES = 2;
	private static final int DEFENSE_DICES = 2;
	private static final int HP = 4;
	private static final int INTELLIGENCE = 2;

	public Skeleton(Coordinate position) {
		super(NAME, ID, HP, INTELLIGENCE, new Sprite(SPRITE), ATTACK_DICES, DEFENSE_DICES, position);
	}

	public Skeleton(Coordinate position, CanCarry[] initialEquipment) {
		super(NAME, ID, HP, INTELLIGENCE, new Sprite(SPRITE), ATTACK_DICES, DEFENSE_DICES, position, initialEquipment);
	}
}
