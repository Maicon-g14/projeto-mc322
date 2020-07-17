//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.attackItems;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.WeaponsTypes;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class BetterShortSword extends Attack{
	private static final char SPRITE = 's';
	private static final GameTypeObjects ID = GameTypeObjects.SHORT_SWORD2;
	private static final String NAME = "Better Short Sword";
	private static final int ATTACK = 1;
	private static final int DICE_NUMBER = 1;
	private static final boolean BREAKABLE = false;
	private static final int REACH = 1;
	private static final WeaponsTypes WEAPON_CLASS = WeaponsTypes.SHORT_SWORD;
	private static final int PRICE = 100;
	
	public BetterShortSword() {
		super(NAME,new Sprite(SPRITE),ID,ATTACK,DICE_NUMBER,REACH,BREAKABLE,WEAPON_CLASS);
		price = PRICE;
	}
}
