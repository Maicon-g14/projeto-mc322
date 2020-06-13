//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.Attack;

public class Alive extends GameObject {
	private int HP;
	private int ATKValue;
	private int DEFValue;
	private CanCarry[] inventory;		//todos os seres vivos precisam de inventario, pois é onde fica o drop deles que deve cair no chao caso morrerem
									//inclusive as armas e armaduras de aliados/monstros
	private int MP;		//BodyPoints
	private int attackDices;
	private int defenseDices;
	private Attack[] attackEquipament = new Attack[2];		//equipamento de ataque dos seres vivos ou null caso use as maos/garras/dentes etc
	private Boolean dead = false;
	
	public Alive(String name, int hp, int mp, int atk, int def, String sprite, int attackDices, int defenseDices) {
	
	}
	
	public int getHp() {
		
	}
	
	public void setHp(int newHp) {
	
	}
	
	public void SetAttackValue(int newAttackValue) {
	/* Obtido o valor de ataque padrao da criatura, soma ele com o bonus do equipamento se existir */
	
	}
	
	public int getAttackValue() {
		
	}
	
	public void SetDefenseValue(int newDEFValue) {
	/* O valor da defesa ja deve chegar tendo seu valor acrescido do bonus da armadura/escudo */
		
	}
	
	public int getDefenseValue() {
		
	}
	
	public void takeDamage(int amount) {
	/* Desconta do HP atual a quantidade dada, se morrer, ativa o dead */
		
	}
	
	public Boolean isDead() {
		return dead;
	}

	public CanCarry dropItem(int id) {
	/* Remove e retorna o item com o id do inventário */
		
	}
	
	public CanCarry[] dropItems() {
	/* Retorna todos os itens do inventário */
		
	}
	
	public void addInventory(CanCarry item) {
	
	}
	
	public void removeInventory(int id) {
	
	}
	
	public void equipAttackEquipament(Attack newattackEquipament) {
	
	}
	
	public Attack unequipAttackEquipament() {
		
	}
}
