package br.unicamp.mc322.lab10.projeto.mapObjects.characters;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.Map;
import br.unicamp.mc322.lab10.projeto.mapObjects.Command;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.Money.Money;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.Defense;

public abstract class Character extends GameObject{
	private static final int INVENTORY_MAX_AMOUNT = 30;
	private int HP;
	private int intelligence;
	private int ATKValue; //quantidade de dados de ataque que o personagem possui no momento, considerando bonus de armas ou magias
	private int DEFValue; //quantidade de dados de defesa que o personagem possui no momento, considerando bonus de equipamentos ou magias
	private int range; //alcance do personagem para realizar ataques, para todos os personagens é igual a 1 quando desarmado
	protected CanCarry[] inventory;		//todos os seres vivos precisam de inventario, pois � onde fica o drop deles que deve cair no chao caso morrerem
	protected int inventoryLoad = 0;
	private int MP;		//BodyPoints
	private int attackDices; //quantidade de dados de ataque que o personagem possui inicialmente, nunca se altera
	private int defenseDices; //quantidade de dados de defesa que o personagem possui inicialmente, nunca se altera
	private Attack[] attackEquipment = new Attack[2];		//equipamento de ataque dos seres vivos ou null caso use as maos/garras/dentes etc
	private Defense defenseEquipment;
	private Boolean dead = false;
	private Money money = new Money();
	
	public Character(String name, GameTypeObjects id, int hp, int mp, int intelligence, Sprite sprite, int attackDices, int defenseDices) {
		super(name,sprite,id);
		this.HP = hp;
		this.MP = mp;
		this.intelligence = intelligence;
		ATKValue = attackDices;
		DEFValue = defenseDices;
		inventory = new CanCarry[INVENTORY_MAX_AMOUNT];
		setRange(1);
	}
	
	public Character(String name, GameTypeObjects id, int hp, int mp, int intelligence, Sprite sprite, int attackDices, int defenseDices, Coordinate position) {
		super(name,sprite,id,position);
		this.HP = hp;
		this.MP = mp;
		ATKValue = attackDices;
		DEFValue = defenseDices;
		inventory = new CanCarry[INVENTORY_MAX_AMOUNT];
	}
	
	public int getHp() {
		return HP;
	}
	
	public void setHp(int newHp) {
		HP = newHp;
	}
	
	public void setAttackValue(int newAttackValue) {
	/*O valor do ataque ja deve chegar com o acrescimo das armas */
		ATKValue = newAttackValue;
	}
	
	public int getAttackValue() {
		return ATKValue;
	}
	
	public void setDefenseValue(int newDEFValue) {
	/* O valor da defesa ja deve chegar tendo seu valor acrescido do bonus da armadura/escudo */
		DEFValue = newDEFValue;
	}
	
	public int getDefenseValue() {
		return DEFValue;
	}
	
	public void setAttackDices(int newAttackDices) {
		attackDices = newAttackDices;
	}
	
	public int getAttackDices() {
		return attackDices;
	}
	
	public void setDefenseDices(int newDefenseDices) {
		defenseDices = newDefenseDices;
	}
	
	public int getDefenseDices() {
		return defenseDices;
	}
	
	
	public void takeDamage(int damage) {
	/* Desconta do HP atual a quantidade dada, se morrer, ativa o dead */
		setHp(HP - damage);
		if(HP < 0)
			dead = true;
	}
	
	public void attack(Character target, int damage) {
		target.takeDamage(damage);
	}
	
	public Boolean isDead() {
		return dead;
	}
	
	public int showMoney() {
		return money.getMoney();
	}
	
	public void addEquipment(CanCarry item) {
		if(inventoryLoad < INVENTORY_MAX_AMOUNT)
			inventory[inventoryLoad++] = item;
		else
			System.out.println("Inventario cheio!");
	}

	public void removeInventory(int id) {
		/* Dado a posicao do item no inventario, remove ele */
		inventory[id] = inventory[--inventoryLoad];
		inventory[inventoryLoad] = null;
	}
	
	public void sell(int id) {
		int price = inventory[id].getPrice();
		money.addMoney(price);
		removeInventory(id);
	}
	
	public Boolean buy(CanCarry item) {
		/* Se houver saldo, desconta e adiciona o item ao inventario */
		int price = item.getPrice();
		
		if (inventoryLoad < INVENTORY_MAX_AMOUNT && money.removeMoney(price)) {
			inventory[inventoryLoad++] = item;
			return true;
		} else if (inventoryLoad < INVENTORY_MAX_AMOUNT)
			System.out.println("Saldo insuficiente!");
		else
			System.out.println("Inventario cheio!");		//trocar esses por throws
		
		return false;
	}
	
	public int getInventoryLoad() {
		return inventoryLoad;
	}
	
	public CanCarry[] getInventory() {
		/* Retorna uma copia de todos os itens no inventario */
		return inventory;
	}
	
	public void move(Command direction, Map map) {
		int destinoX = getPosition().getX();
		int destinoY = getPosition().getY();
		
		switch(direction) {
			case MOVE_UP: 
				destinoY--; 
				break;
			case MOVE_DOWN: 
				destinoY++; 
				break;
			case MOVE_RIGHT: 
				destinoX++; 
				break;
			case MOVE_LEFT:
				destinoX--;
				break;
			default : break;
		}
		
		setPosition(new Coordinate(destinoX, destinoY));

	}

	public Attack[] getAttackEquipment() {
		return attackEquipment;
	}

	public void setAttackEquipment(int pos, Attack attackEquipment) {
		if(this.attackEquipment[pos] == null) {
			this.attackEquipment[pos] = attackEquipment;
			if(attackEquipment.getReach() > range)
				setRange(attackEquipment.getReach());
		}else {
			//Disparar exceção de que esta mão ja possui equipamento
		}
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public Defense getDefenseEquipment() {
		return defenseEquipment;
	}

	public void setDefenseEquipment(Defense defenseEquipment) {
		this.defenseEquipment = defenseEquipment;
	}
	
	
	

}

