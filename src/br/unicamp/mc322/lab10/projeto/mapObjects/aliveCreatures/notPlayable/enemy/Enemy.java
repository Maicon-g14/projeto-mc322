//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.enemy;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.NotPlayable;

public class Enemy extends NotPlayable{
	private MonsterClass monsterClass;
	
	public Enemy(String name, int hp, int mp, int atk, int def, Object sprite, int attackDices, int defenseDices, MonsterClass monsterClass) {
	
	}
	
	public MonsterClass getmonsterClass() {
		return monsterClass;
	}
}
