//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.Equipment;

public class Defense extends Equipment {

	private int defenseDice;
	private ArmorClasses armorClass;

	public Defense(String name, Sprite sprite, GameTypeObjects id, ArmorClasses armorClass, int defenseDice, int price) {
		super(name, sprite, id, price);
		this.armorClass = armorClass;
	}

	public int getBonusDefense() {
		return defenseDice;
	}

	public ArmorClasses getArmorClass() {
		return armorClass;
	}
}
