package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Character;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;

public abstract class Hero extends Character {

	public Hero(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices, int defenseDices) {
		super(name, id, hp, mp, sprite, attackDices, defenseDices);
	}
	
	public Hero(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices, int defenseDices, CanCarry[] initialEquipment) {
		super(name, id, hp, mp, sprite, attackDices, defenseDices,initialEquipment);
	}
	
}
