package br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters;
import br.unicamp.mc322.lab10.projeto.engine.MapObjectVisitor;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.enemy.MonsterClass;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Character;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.classes.MonsterClasses;

public class Monster extends Character {
	private MonsterClasses monsterClass;
	
	public Monster(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices, int defenseDices, MonsterClasses monsterClass) {
		super(name,id,hp,mp,sprite,attackDices,defenseDices);
		this.monsterClass = monsterClass;
	}
	
	public MonsterClasses getMonsterClass() {
		return monsterClass;
	}

	@Override
	public void accept(MapObjectVisitor visitor) {
		// TODO Auto-generated method stub
		
	}	
	
}
