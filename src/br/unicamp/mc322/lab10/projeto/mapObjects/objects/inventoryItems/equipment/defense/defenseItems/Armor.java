//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems;
import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.ArmorClasses;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.Defense;

public class Armor extends Defense{
	
	public Armor(String name, Sprite sprite, GameTypeObjects id, int defense, ArmorClasses armorClass, int diceBonus) {
		super(name,sprite,id,defense,armorClass,diceBonus);
	}
}
