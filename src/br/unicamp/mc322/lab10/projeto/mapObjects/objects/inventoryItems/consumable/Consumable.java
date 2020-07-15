//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.consumable;
import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;

public class Consumable extends CanCarry{
	public Consumable(String name, Sprite sprite, GameTypeObjects id,Coordinate position) {
		super(name,sprite,id,position);
	}
}
