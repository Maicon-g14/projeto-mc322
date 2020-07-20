//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.consumable.comsumableItems;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.consumable.Consumable;

public class HealthPotion extends Consumable{
	private static final String NAME = "Potion";
	private static final char SPRITE = '+';
	private static final GameTypeObjects ID = GameTypeObjects.HEALTH_POTION;
	private static final int AMOUNT_TO_RECOVER = 50;
	private static final int PRICE = 50;
	private Boolean isUsed = false;
	
	public HealthPotion() {
		super(NAME,new Sprite(SPRITE),ID,PRICE);
	}
	
	public int usePotion() {
		if(isUsed)
			return 0;
		isUsed = true;
		return AMOUNT_TO_RECOVER;
	}
}
