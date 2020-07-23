//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.armors;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.ArmorClasses;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.Armor;

public class HeavyArmor extends Armor {

	private static final char SPRITE = 'a';
	private static final GameTypeObjects ID = GameTypeObjects.HEAVY_ARMOR1;
	private static final String NAME = "Heavy Armor";
	private static final int DICE_NUMBER = 1;
	private static final ArmorClasses ARMOR_CLASS = ArmorClasses.HEAVY_ARMOR;
	private static final int PRICE = 100;

	public HeavyArmor() {
		super(NAME, new Sprite(SPRITE), ID, ARMOR_CLASS, DICE_NUMBER, PRICE);
	}
}
