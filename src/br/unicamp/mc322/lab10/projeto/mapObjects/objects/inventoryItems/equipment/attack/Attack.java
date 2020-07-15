//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.NotAlive;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.Equipment;

public class Attack extends Equipment{
	private int attack;
	private int bonusDiceNumber;
	private NotAlive bonus = null;
	private boolean breaksAfterUse;
	private boolean breaked = false;
	private int reach;
	private WeaponsTypes weaponClasses;
	
	public Attack(String name, Sprite sprite, GameTypeObjects id, int atk, int diceNumber, int reach, boolean breaksAfterUse, WeaponsTypes weaponClasses,Coordinate position) {
		super(name,sprite,id,position);
		this.attack = atk;
		this.bonusDiceNumber = diceNumber;
		this.reach = reach;
		this.breaksAfterUse = breaksAfterUse;
		this.weaponClasses = weaponClasses;
	}
	
	public Attack(String name, Sprite sprite, GameTypeObjects id, int atk, int diceNumber, int reach, boolean breaksAfterUse, WeaponsTypes weaponClasses, NotAlive bonus,Coordinate position) {
		super(name,sprite,id,position);
		this.attack = atk;
		this.bonusDiceNumber = diceNumber;
		this.reach = reach;
		this.breaksAfterUse = breaksAfterUse;
		this.weaponClasses = weaponClasses;
		this.bonus = bonus;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int doAttack(int reach) {
		if(reach <= this.reach) {
			if(breaksAfterUse && !breaked) {
				breaked = true;
				return attack;
			
			} else if (!breaksAfterUse)
				return attack;
		}
		
		return 0;	
	}
	
	public int getBonusDiceNumber() {
		return bonusDiceNumber;
	}
	
	public NotAlive getBonus() {
		return bonus;
	}
	
	public int getReach() {
		return reach;
	}
	
	public WeaponsTypes getWeaponClass() {
		return weaponClasses;
	}
}
