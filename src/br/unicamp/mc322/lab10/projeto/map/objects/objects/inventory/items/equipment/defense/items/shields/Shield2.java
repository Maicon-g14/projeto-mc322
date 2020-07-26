//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.shields;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.ArmorClasses;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.Shield;

public class Shield2 extends Shield {

	private static final char SPRITE = '@';
	private static final GameTypeObjects ID = GameTypeObjects.SHIELD2;
	private static final String NAME = "Better Shield";
	private static final int DICE_NUMBER = 2;
	private static final ArmorClasses SHIELD_CLASS = ArmorClasses.SHIELD;
	private static final int PRICE = 40;

	public Shield2() {
		super(NAME, new Sprite(SPRITE), ID, SHIELD_CLASS, DICE_NUMBER, PRICE);
	}
}
