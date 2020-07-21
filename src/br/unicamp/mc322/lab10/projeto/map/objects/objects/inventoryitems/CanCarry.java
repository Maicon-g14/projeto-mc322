//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventoryitems;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.NotAlive;

public class CanCarry extends NotAlive {
	private int price = 0;

	public CanCarry(String name, Sprite sprite, GameTypeObjects id, int price) {
		super(name, sprite, id);
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}
