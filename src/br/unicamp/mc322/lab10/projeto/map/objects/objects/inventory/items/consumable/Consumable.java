//RAs
//221329
//224956 
//242233

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.consumable;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;

public class Consumable extends CanCarry {
	public Consumable(String name, Sprite sprite, GameTypeObjects id, int price) {
		super(name, sprite, id, price);
	}
}
