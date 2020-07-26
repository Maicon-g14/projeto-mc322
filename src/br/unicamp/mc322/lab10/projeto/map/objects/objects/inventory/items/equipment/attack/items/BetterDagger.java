//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.items;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.WeaponsTypes;

public class BetterDagger extends Attack {

	private static final char SPRITE = 's';
	private static final GameTypeObjects ID = GameTypeObjects.DAGGER2;
	private static final String NAME = "Better Dagger";
	private static final boolean TWO_HANDS = false;
	private static final int DICE_NUMBER = 3;
	private static final boolean BREAKABLE = true;
	private static final int REACH = 3;
	private static final WeaponsTypes WEAPON_CLASS = WeaponsTypes.DAGGER;
	private static final int PRICE = 20;

	public BetterDagger() {
		super(NAME, new Sprite(SPRITE), ID, TWO_HANDS, DICE_NUMBER, REACH, BREAKABLE, WEAPON_CLASS, PRICE);
	}
}
