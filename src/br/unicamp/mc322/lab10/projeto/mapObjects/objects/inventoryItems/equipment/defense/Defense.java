//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.Equipment;

public class Defense extends Equipment{
	private int defenseDice;
	private ArmorClasses armorClass;
	
	public Defense(String name, Sprite sprite, GameTypeObjects id, ArmorClasses armorClass, int defenseDice, int price) {
		super(name,sprite,id,price);
		this.armorClass = armorClass;
	}
	
	public int getBonusDefense() {
		return defenseDice;
	}
	
	public ArmorClasses getArmorClass() {
		return armorClass;
	}
}
