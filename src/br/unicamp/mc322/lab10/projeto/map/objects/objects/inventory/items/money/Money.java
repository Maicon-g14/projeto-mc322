//RAs
//221329
//224956 
//242233

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.money;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;

import java.util.Random;

public class Money extends CanCarry {

	private int value = 0;

	private static final char SPRITE = '$';
	private static final GameTypeObjects ID = GameTypeObjects.MONEY;
	private static final String NAME = "Gold";
	private static final int MAX_RANDOM_AMOUNT = 45;

	public Money() {
		super(NAME, new Sprite(SPRITE), ID, 0);
	}

	public boolean removeMoney(int value) {
		/* Remove uma quantia de dinheiro e retorna true se a quantia puder ser removida */
		if (this.value - value >= 0) {
			this.value -= value;
			return true;
		}

		return false;
	}

	public int getMoney() {
		return value;
	}

	public void addMoney(int value) {
		this.value += value;
		System.out.println(value + "PO adicionados!");
	}

	public void addRandomMoney() {
		Random randomize = new Random();
		int amount = randomize.nextInt(MAX_RANDOM_AMOUNT) + 5;

		if (amount % 5 != 0) {
			amount = (amount / 5) * 5;
		}

		addMoney(amount);
	}

	public void setMoney(int value) {
		this.value = value;
	}

}
