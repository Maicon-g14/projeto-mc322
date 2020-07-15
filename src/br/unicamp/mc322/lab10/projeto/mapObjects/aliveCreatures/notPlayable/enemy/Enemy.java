//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.enemy;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.NotPlayable;

public class Enemy extends NotPlayable{
	private MonsterClass monsterClass;
	
	public Enemy(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices, int defenseDices, MonsterClass monsterClass,br.unicamp.mc322.lab10.projeto.Coordinate position) {
		super(name,id,hp,mp,sprite,attackDices,defenseDices,position);
		this.monsterClass = monsterClass;
	}
	
	public MonsterClass getMonsterClass() {
		return monsterClass;
	}
}
