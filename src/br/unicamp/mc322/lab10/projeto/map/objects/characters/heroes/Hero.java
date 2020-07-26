package br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Character;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;

public abstract class Hero extends Character {

	public Hero(String name, GameTypeObjects id, int hp, int intelligence, Sprite sprite, int attackDices, int defenseDices) {
		super(name, id, hp, intelligence, sprite, attackDices, defenseDices);
	}

	public Hero(String name, GameTypeObjects id, int hp, int intelligence, Sprite sprite, int attackDices, int defenseDices, CanCarry[] initialEquipment) {
		super(name, id, hp, intelligence, sprite, attackDices, defenseDices, initialEquipment);
	}

}
