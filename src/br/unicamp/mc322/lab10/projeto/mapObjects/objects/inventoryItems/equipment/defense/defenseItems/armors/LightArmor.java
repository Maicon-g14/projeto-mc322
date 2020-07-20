//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.armors;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.ArmorClasses;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.Armor;

public class LightArmor extends Armor{
	private static final char SPRITE = 'a';
	private static final GameTypeObjects ID = GameTypeObjects.LIGHT_ARMOR1;
	private static final String NAME = "Better Light Armor";
	private static final int DICE_NUMBER = 0;
	private static final ArmorClasses ARMOR_CLASS = ArmorClasses.LIGHT_ARMOR;
	private static final int PRICE = 100;
	
	public LightArmor() {
		super(NAME,new Sprite(SPRITE),ID,ARMOR_CLASS,DICE_NUMBER,PRICE);
	}
}
