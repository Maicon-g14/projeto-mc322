//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.NotAlive;

public class CanCarry extends NotAlive{
	protected int price = 0;
	
	public CanCarry(String name, Sprite sprite, GameTypeObjects id) {
		super(name,sprite,id);
	}
	
	public int getPrice() {
		if (price > 0)
			return price;
		return -1;
	}
}
