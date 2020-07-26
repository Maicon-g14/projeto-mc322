//RAs
//221329
//224956 
//242233

package br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.forniture.types;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.forniture.Forniture;

public class Chest extends Forniture {

	private CanCarry content;
	private boolean open = false;

	private static final char SPRITE = 'C';
	private static final GameTypeObjects ID = GameTypeObjects.CHEST;
	private static final String NAME = "Chest";

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
