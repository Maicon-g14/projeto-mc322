package br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Character;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;

public class Monster extends Character {

	public Monster(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices, int defenseDices, Coordinate position) {
		super(name, id, hp, mp, sprite, attackDices, defenseDices, position);
	}
	
	public Monster(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices, int defenseDices, Coordinate position, CanCarry[] initialEquipment) {
		super(name, id, hp, mp, sprite, attackDices, defenseDices, position, initialEquipment);
	}

}
