//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.enemy.enemyTypes;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.enemy.Enemy;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.enemy.MonsterClass;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class Goblin extends Enemy{
	private static final char SPRITE = 'G';
	private static final String NAME = "Goblin";
	private static final GameTypeObjects ID = GameTypeObjects.GOBLIN;
	private static final int ATTACK_DICES = 1;
	private static final int DEFENSE_DICES = 1;
	private static final int HP = 1;
	private static final int MP = 1;
	private static final MonsterClass MONSTER_CLASS = MonsterClass.GOBLIN;
	
	public Goblin(Coordinate position) {
		super(NAME,ID,HP,MP,new Sprite(SPRITE),ATTACK_DICES,DEFENSE_DICES,MONSTER_CLASS,position);
	}
}
