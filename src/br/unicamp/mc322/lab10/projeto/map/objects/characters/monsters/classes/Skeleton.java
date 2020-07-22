package br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.classes;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.Monster;

public class Skeleton extends Monster {

	private static final char SPRITE = 'K';
	private static final String NAME = "Skeleton";
	private static final GameTypeObjects ID = GameTypeObjects.SKELETON;
	private static final int ATTACK_DICES = 1;
	private static final int DEFENSE_DICES = 1;
	private static final int HP = 4;
	private static final int MP = 2;

	public Skeleton(Coordinate position) {
		super(NAME, ID, HP, MP, new Sprite(SPRITE), ATTACK_DICES, DEFENSE_DICES, position);
	}
}
