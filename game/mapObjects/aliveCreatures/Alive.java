//RAs
//
//
//


package game.mapObjects.aliveCreatures;


public class Alive {
	private int HP;
	private int ATKValue;
	private int DEFValue;
	private game.mapObjects.objects.inventoryItems.CanCarry inventory;
	private int MP;
	private int attackDices;
	private int defenseDices;
	private Attack attackEquipament;
	public void Alive(Object Name, Object Hp, Object mp, Object Atk, Object Def, Object Sprite, Object attackDices, Object defenseDices) {
	}
	
	public int getHp() {
	}
	
	public void setHp(int newHp) {
	}
	
	public void SetATKValue(int newATKValue) {
	}
	
	public int GetATKValue() {
	}
	
	public void SetDEFValue(int newDEFValue) {
	}
	
	public int GetDEFValue() {
	}
	
	public game.mapObjects.objects.inventoryItems.CanCarry dropItem() {
	}
	
	public void doAttack(Alive who) {
	}
	
	public game.mapObjects.objects.inventoryItems.CanCarry Getinventory() {
	}
	
	public void addInventory(game.mapObjects.objects.inventoryItems.CanCarry item) {
	}
	
	public void removeInventory(int id) {
	}
	
	public void walk(int maxSteps) {
	}
	
	public void equipAttackEquipament(Attack newattackEquipament) {
	}
	
	public Attack unequipAttackEquipament() {
	}
	
	public void doDamage(int amount) {
	}
}
