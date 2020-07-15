//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense;
import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.Equipment;

public class Defense extends Equipment{
	private int defense;
	private int diceBonus;
	private ArmorClasses armorClass;
	
	public Defense(String name, Sprite sprite, GameTypeObjects id, int defense, ArmorClasses armorClass, int diceBonus,Coordinate position) {
		super(name,sprite,id,position);
		this.armorClass = armorClass;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public int getDices() {
		return diceBonus;
	}
	
	public ArmorClasses getArmorClass() {
		return armorClass;
	}
}
