//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventoryitems.equipment;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventoryitems.CanCarry;

public class Equipment extends CanCarry {

	public Equipment(String name, Sprite sprite, GameTypeObjects id, int price) {
		super(name, sprite, id, price);
	}
}
