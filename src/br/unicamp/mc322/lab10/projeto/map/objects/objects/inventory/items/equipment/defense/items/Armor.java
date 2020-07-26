//RAs
//221329
//224956 
//242233

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.ArmorClasses;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.Defense;

public class Armor extends Defense {

	public Armor(String name, Sprite sprite, GameTypeObjects id, ArmorClasses armorClass, int diceBonus, int price) {
		super(name, sprite, id, armorClass, diceBonus, price);
	}
}
