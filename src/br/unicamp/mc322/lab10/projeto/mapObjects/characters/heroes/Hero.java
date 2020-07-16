package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes;
import br.unicamp.mc322.lab10.projeto.engine.MapObjectVisitor;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Character;

public abstract class Hero extends Character {

	public Hero(String name, int hp, int mp, Sprite sprite, int attackDices, int defenseDices) {
		super(name, hp, mp, sprite, attackDices, defenseDices);
		// TODO Auto-generated constructor stub
	}
	
	public void accept(MapObjectVisitor visitor) {
		visitor.visit(this);
	}
	
	
}
