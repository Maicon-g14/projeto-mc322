//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.items;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.WeaponsTypes;

public class BetterLongSword extends Attack {

	private static final char SPRITE = 's';
	private static final GameTypeObjects ID = GameTypeObjects.LONG_SWORD2;
	private static final String NAME = "Better Long Sword";
	private static final boolean TWO_HANDS = true;
	private static final int DICE_NUMBER = 4;
	private static final int LIFE_BONUS = 1;
	private static final boolean BREAKABLE = false;
	private static final int REACH = 2;
	private static final WeaponsTypes WEAPON_CLASS = WeaponsTypes.LONG_SWORD;
	private static final int PRICE = 50;

	public BetterLongSword() {
		super(NAME, new Sprite(SPRITE), ID, TWO_HANDS, DICE_NUMBER, REACH, BREAKABLE, WEAPON_CLASS, LIFE_BONUS, PRICE);
	}
}
