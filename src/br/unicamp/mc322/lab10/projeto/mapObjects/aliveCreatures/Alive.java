//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.Coordinate;

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
	
	public Alive(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices, int defenseDices, Coordinate position) {
		super(name,sprite,id,position);
		this.HP = hp;
		this.MP = mp;
		ATKValue = attackDices;
		DEFValue = defenseDices;
	}
	
	public int getHp() {
		return HP;
	}
	
	public void setHp(int newHp) {
		HP = newHp;
	}
	
	public void setAttackValue(int newAttackValue) {
	/* Obtido o valor de ataque padrao da criatura, soma ele com o bonus do equipamento se existir */
		ATKValue = newAttackValue;
	}
	
	public int getAttackValue() {
		return ATKValue;
	}
	
	public void SetDefenseValue(int newDEFValue) {
	/* O valor da defesa ja deve chegar tendo seu valor acrescido do bonus da armadura/escudo */
		DEFValue = newDEFValue;
	}
	
	public int getDefenseValue() {
		return DEFValue;
	}
	
	public void takeDamage(int amount) {
	/* Desconta do HP atual a quantidade dada, se morrer, ativa o dead */
		HP -= amount;
	}
	
	public Boolean isDead() {
		return dead;
	}

	public CanCarry dropItem(int id) {
	/* Remove e retorna o item com o id do inventário */
		return null;
	}
	
	public CanCarry[] dropItems() {
	/* Retorna todos os itens do inventário */
		return null;
	}
	
	public void addInventory(CanCarry item) {
	
	}
	
	public void removeInventory(int id) {
	
	}
	
	public void equipAttackEquipament(Attack newattackEquipament) {
	
	}
	
	public Attack unequipAttackEquipament() {
		return null;
	}
}
