//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems;
import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.NotAlive;

public class CanCarry extends NotAlive{
	public CanCarry(String name, Sprite sprite, GameTypeObjects id,Coordinate position) {
		super(name,sprite,id,position);
	}
}
