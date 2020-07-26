package br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.classes;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.Monster;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;

public class MageSkeleton extends MonsterSpellCaster {

	private static final char SPRITE = 'M';
	private static final String NAME = "Mage Skeleton";
	private static final GameTypeObjects ID = GameTypeObjects.MAGE_SKELETON;
	private static final int ATTACK_DICES = 2;
	private static final int DEFENSE_DICES = 2;
	private static final int HP = 3;
	private static final int MP = 5;

	public MageSkeleton(Coordinate position) {
		super(NAME, ID, HP, MP, new Sprite(SPRITE), ATTACK_DICES, DEFENSE_DICES, position);
	}
	
	public MageSkeleton(Coordinate position, CanCarry[] initialEquipment) {
		super(NAME, ID, HP, MP, new Sprite(SPRITE), ATTACK_DICES, DEFENSE_DICES, position, initialEquipment);
	}
}
