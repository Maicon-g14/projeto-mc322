//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack;

import br.unicamp.mc322.lab10.projeto.mapObjects.objects.NotAlive;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.Equipment;

public class Attack extends Equipment{
	private int attack;
	private int bonusDiceNumber;
	private NotAlive bonus = null;
	private boolean breaksAfterUse;
	private boolean breaked;
	private int reach;
	private WeaponsTypes weaponClasses;
	
	public Attack(String name, String sprite, int id, int atk, int diceNumber, int reach, boolean breaksAfterUse, WeaponsTypes weaponClasses) {
	
	}
	
	public Attack(String name, String sprite, int id, int atk, int diceNumber, int reach, boolean breaksAfterUse, WeaponsTypes weaponClasses, NotAlive bonus) {
	
	}
	
	public int getAttack() {
		
	}
	
	public int doAttack() {
	/* Se for do tipo quebravel, quebra, retorna o ataque e reduz ataque a 0 */
		
	}
	
	public int getBonusDiceNumber() {
		
	}
	
	public NotAlive getBonus() {
		
	}
	
	public int getReach() {
		
	}
	
	public WeaponsTypes getWeaponClass() {
		
	}
}
