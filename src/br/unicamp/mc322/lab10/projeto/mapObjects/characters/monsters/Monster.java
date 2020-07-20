package br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters;
import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Character;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.classes.MonsterClasses;

public class Monster extends Character {
	private MonsterClasses monsterClass;
	private static final GameTypeObjects type = GameTypeObjects.MONSTER;
	
	public Monster(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices, int defenseDices, MonsterClasses monsterClass, Coordinate position) {
		super(name,id,hp,mp,sprite,attackDices,defenseDices,position,type);
		this.monsterClass = monsterClass;
	}
	
	public GameTypeObjects getMonsterClass() {
		return monsterClass;
	}	
	
}
