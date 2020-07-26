//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.consumable.items;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.consumable.Consumable;

public class HealthPotion extends Consumable {

	private boolean isUsed = false;

	private static final String NAME = "Potion";
	private static final char SPRITE = '+';
	private static final GameTypeObjects ID = GameTypeObjects.HEALTH_POTION;
	private static final int AMOUNT_TO_RECOVER = 4;
	private static final int PRICE = 50;

	public HealthPotion() {
		super(NAME, new Sprite(SPRITE), ID, PRICE);
	}

	public int usePotion() {
		if (isUsed) {
			return 0;
		}

		isUsed = true;

		return AMOUNT_TO_RECOVER;
	}
}
