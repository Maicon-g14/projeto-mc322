//RAs
//221329
//224956 
//242233

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.items;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.WeaponsTypes;

public class Dagger extends Attack {

	private static final char SPRITE = 's';
	private static final GameTypeObjects ID = GameTypeObjects.DAGGER1;
	private static final String NAME = "Dagger";
	private static final boolean TWO_HANDS = false;
	private static final int DICE_NUMBER = 1;
	private static final boolean BREAKABLE = true;
	private static final int REACH = 2;
	private static final WeaponsTypes WEAPON_CLASS = WeaponsTypes.DAGGER;
	private static final int PRICE = 10;

	public Dagger() {
		super(NAME, new Sprite(SPRITE), ID, TWO_HANDS, DICE_NUMBER, REACH, BREAKABLE, WEAPON_CLASS, PRICE);
	}
}
