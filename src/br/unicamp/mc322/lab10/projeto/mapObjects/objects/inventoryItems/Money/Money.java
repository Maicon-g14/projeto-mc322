//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.Money;

import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;

public class Money extends CanCarry{
	private final String SPRITE = "";
	private final int ID = 0;
	private final String NAME = "Gold";
	private int value = 0;
	
	public Money() {
	
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
