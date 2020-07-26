//RAs
//221329
//224956 
//242233

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.shields;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.ArmorClasses;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.Shield;

public class Shield1 extends Shield {

	private static final char SPRITE = '@';
	private static final GameTypeObjects ID = GameTypeObjects.SHIELD1;
	private static final String NAME = "Shield";
	private static final int DICE_NUMBER = 1;
	private static final ArmorClasses SHIELD_CLASS = ArmorClasses.SHIELD;
	private static final int PRICE = 20;

	public Shield1() {
		super(NAME, new Sprite(SPRITE), ID, SHIELD_CLASS, DICE_NUMBER, PRICE);
	}
}
