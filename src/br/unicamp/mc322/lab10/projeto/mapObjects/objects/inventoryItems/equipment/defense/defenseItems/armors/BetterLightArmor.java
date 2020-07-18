//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.armors;
import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.ArmorClasses;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.Armor;

public class BetterLightArmor extends Armor{
	private static final char SPRITE = 'a';
	private static final GameTypeObjects ID = GameTypeObjects.LIGHT_ARMOR2;
	private static final String NAME = "Better Light Armor";
	private static final int DEFENSE = 1;
	private static final int DICE_NUMBER = 1;
	private static final ArmorClasses ARMOR_CLASS = ArmorClasses.LIGHT_ARMOR;
	private static final int PRICE = 200;
	
	public BetterLightArmor() {
		super(NAME,new Sprite(SPRITE),ID,DEFENSE,ARMOR_CLASS,DICE_NUMBER);
		price = PRICE;
	}
}
