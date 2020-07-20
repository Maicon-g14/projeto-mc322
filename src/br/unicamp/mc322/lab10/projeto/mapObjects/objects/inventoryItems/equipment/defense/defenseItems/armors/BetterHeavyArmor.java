//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.armors;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.ArmorClasses;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.Armor;

public class BetterHeavyArmor extends Armor{
	private static final char SPRITE = 'a';
	private static final GameTypeObjects ID = GameTypeObjects.HEAVY_ARMOR2;
	private static final String NAME = "Better Heavy Armor";
	private static final int DICE_NUMBER = 2;
	private static final ArmorClasses ARMOR_CLASS = ArmorClasses.HEAVY_ARMOR;
	private static final int PRICE = 200;
	
	public BetterHeavyArmor() {
		super(NAME,new Sprite(SPRITE),ID,ARMOR_CLASS,DICE_NUMBER,PRICE);
	}
}
