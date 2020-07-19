package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Character;

public abstract class Hero extends Character {

	public Hero(String name, GameTypeObjects id, int hp, int mp, int intelligence, Sprite sprite, int attackDices, int defenseDices) {
		super(name, id, hp, mp, intelligence, sprite, attackDices, defenseDices);
	}
	
}
