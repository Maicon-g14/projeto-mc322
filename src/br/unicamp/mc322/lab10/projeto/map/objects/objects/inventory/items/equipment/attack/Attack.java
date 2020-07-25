//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.Equipment;

public class Attack extends Equipment {

	private boolean breakable;
	private boolean twoHands;
	private int bonusAttack;
	private int lifeBonus;
	private int reach;
	private WeaponsTypes weaponClasses;

	public Attack(String name, Sprite sprite, GameTypeObjects id, boolean twoHands, int diceAttack, int reach, boolean breakable, WeaponsTypes weaponClasses, int price) {
		super(name, sprite, id, price);
		this.breakable = breakable;
		this.bonusAttack = diceAttack;
		this.reach = reach;
		this.twoHands = twoHands;
		this.breakable = breakable;
		this.weaponClasses = weaponClasses;
		this.lifeBonus = 0;
	}

	public Attack(String name, Sprite sprite, GameTypeObjects id, boolean twoHands, int diceAttack, int reach, boolean breakable, WeaponsTypes weaponClasses, int lifeBonus, int price) {
		super(name, sprite, id, price);
		this.breakable = breakable;
		this.bonusAttack = diceAttack;
		this.reach = reach;
		this.twoHands = twoHands;
		this.breakable = breakable;
		this.weaponClasses = weaponClasses;
		this.lifeBonus = lifeBonus;
	}

	public boolean removeAfterUse() {
		/* Sinal para indicar que a arma deve quebrar apos o uso */
		return breakable;
	}

	public boolean isTwoHanded() {
		return twoHands;
	}
	
	public boolean isBreakable() {
		return breakable;
	}

	public int getBonusAttack() {
		/* Bonus de ataque da arma, verificar ao equipar */
		return bonusAttack;
	}

	public int getBonus() {
		/* Bonus de vida que pode ser concedido pela arma */
		return lifeBonus;
	}

	public int getReach() {
		/* Alcance da arma */
		return reach;
	}

	public WeaponsTypes getWeaponClass() {
		/* Tipo da arma, ex: espada curta, adaga, espada longa etc. */
		return weaponClasses;
	}
}
