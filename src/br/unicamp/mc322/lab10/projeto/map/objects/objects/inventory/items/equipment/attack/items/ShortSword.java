//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.items;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.WeaponsTypes;

public class ShortSword extends Attack {

	private static final char SPRITE = 's';
	private static final GameTypeObjects ID = GameTypeObjects.SHORT_SWORD1;
	private static final String NAME = "Short Sword";
	private static final boolean TWO_HANDS = false;
	private static final int DICE_NUMBER = 2;
	private static final boolean BREAKABLE = false;
	private static final int REACH = 1;
	private static final WeaponsTypes WEAPON_CLASS = WeaponsTypes.SHORT_SWORD;
	private static final int PRICE = 15;

	public ShortSword() {
		super(NAME, new Sprite(SPRITE), ID, TWO_HANDS, DICE_NUMBER, REACH, BREAKABLE, WEAPON_CLASS, PRICE);
	}
}
