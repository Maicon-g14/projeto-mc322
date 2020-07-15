//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.Money;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;

public class Money extends CanCarry{
	private static final char SPRITE = '$';
	private static final GameTypeObjects ID = GameTypeObjects.MONEY;
	private static final String NAME = "Gold";
	private int value = 0;
	
	public Money() {
		super(NAME,new Sprite(SPRITE),ID,new Coordinate());
	}
	
	public void addMoney(int value) {
		this.value += value;
	}
	
	public void removeMoney(int value) {
		this.value -= value;
	}
	
	public void setMoney(int value) {
		this.value = value;
	}
	
	public int getMoney() {
		return value;
	}
}
