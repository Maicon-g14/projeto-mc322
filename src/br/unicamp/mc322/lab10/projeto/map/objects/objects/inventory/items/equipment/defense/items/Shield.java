//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.ArmorClasses;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.Defense;

public class Shield extends Defense {

	public Shield(String name, Sprite sprite, GameTypeObjects id, ArmorClasses armorClass, int defenseDice, int price) {
		super(name, sprite, id, armorClass, defenseDice, price);
	}
}
