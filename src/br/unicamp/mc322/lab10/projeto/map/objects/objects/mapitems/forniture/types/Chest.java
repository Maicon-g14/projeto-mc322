//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.mapitems.forniture.types;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventoryitems.CanCarry;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.mapitems.forniture.Forniture;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class Chest extends Forniture {
	private static final char SPRITE = 'C';
	private static final GameTypeObjects ID = GameTypeObjects.CHEST;
	private static final String NAME = "Chest";
	private CanCarry content;
	private Boolean open = false;

	public Chest(Coordinate position) {
		super(NAME, new Sprite(SPRITE), ID, position);
	}

	public CanCarry getItems() {
		if (!open) {
			open = true;
			return content;
		}

		return null;
	}

	public void setContent(CanCarry content) {
		this.content = content;
	}
}
