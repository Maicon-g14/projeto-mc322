//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.attackItems;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.WeaponsTypes;

public class BetterDagger extends Attack{
	private static final char SPRITE = 's';
	private static final GameTypeObjects ID = GameTypeObjects.DAGGER2;
	private static final String NAME = "Better Dagger";
	private static final boolean TWO_HANDS = false;
	private static final int DICE_NUMBER = 3;
	private static final boolean BREAKABLE = true;
	private static final int REACH = 1;
	private static final WeaponsTypes WEAPON_CLASS = WeaponsTypes.DAGGER;
	private static final int PRICE = 10;
	
	public BetterDagger() {
		super(NAME,new Sprite(SPRITE),ID,TWO_HANDS,DICE_NUMBER,REACH,BREAKABLE,WEAPON_CLASS,PRICE);
	}
}
