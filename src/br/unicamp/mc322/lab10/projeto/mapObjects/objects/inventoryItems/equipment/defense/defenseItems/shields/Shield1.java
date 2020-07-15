//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.shields;
import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.ArmorClasses;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.Shield;

public class Shield1 extends Shield{
	private static final char SPRITE = '@';
	private static final GameTypeObjects ID = GameTypeObjects.SHIELD1;
	private static final String NAME = "Shield";
	private static final int DEFENSE = 1;
	private static final int DICE_NUMBER = 1;
	private static final ArmorClasses SHIELD_CLASS = ArmorClasses.SHIELD;
	
	public Shield1() {
		super(NAME,new Sprite(SPRITE),ID,DEFENSE,SHIELD_CLASS,DICE_NUMBER,new Coordinate());
	}
}
