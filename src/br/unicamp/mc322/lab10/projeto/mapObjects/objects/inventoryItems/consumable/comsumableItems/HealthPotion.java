//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.consumable.comsumableItems;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.consumable.Consumable;

public class HealthPotion extends Consumable{
	private final String SPRITE = "";
	private final int ID = 0;
	private final String NAME = "Potion";
	private final int AMOUNT_TO_RECOVER = 50;
	private Boolean isUsed = false;
	
	public HealthPotion() {
	
	}
	
	public int getAmount() {
		if(isUsed)
			return 0;
		return AMOUNT_TO_RECOVER;
	}
}
