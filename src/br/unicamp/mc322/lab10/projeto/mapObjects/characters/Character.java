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

public abstract class Character extends GameObject{
	private static final int INVENTORY_MAX_AMOUNT = 30;
	private int HP;
	private int ATKValue;
	private int DEFValue;
	protected CanCarry[] inventory;		//todos os seres vivos precisam de inventario, pois � onde fica o drop deles que deve cair no chao caso morrerem
	protected int inventoryLoad = 0;
	private int MP;		//BodyPoints
	private int attackDices;
	private int defenseDices;
	private Attack[] attackEquipament = new Attack[2];		//equipamento de ataque dos seres vivos ou null caso use as maos/garras/dentes etc
	private Boolean dead = false;
	private Money money = new Money();
	private GameTypeObjects type;
	
	public Character(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices, int defenseDices, GameTypeObjects type) {
		super(name,sprite,id,type);
		this.HP = hp;
		this.MP = mp;
		ATKValue = attackDices;
		DEFValue = defenseDices;
		inventory = new CanCarry[INVENTORY_MAX_AMOUNT];
		this.type = type;
	}
	
	public Character(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices, int defenseDices, Coordinate position, GameTypeObjects type) {
		super(name,sprite,id,position,type);
		this.HP = hp;
		this.MP = mp;
		ATKValue = attackDices;
		DEFValue = defenseDices;
		inventory = new CanCarry[INVENTORY_MAX_AMOUNT];
		this.type = type;
	}
	
	public int getHp() {
		return HP;
	}
	
	public void setHp(int newHp) {
		HP = newHp;
	}
	
	public void setAttackValue(int newAttackValue) {
	/* Obtido o valor de ataque padrao da criatura, soma ele com o bonus do equipamento se existir */
	
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
	
	public boolean move(Command direction, Map map) {
		int destinoX = getPosition().getX();
		int destinoY = getPosition().getY();
		Coordinate newPosition = new Coordinate(destinoX, destinoY);
		
		switch(direction) {
			case MOVE_UP: 
				newPosition.setX(--destinoX);
				if(!map.isEmptyPosition(newPosition,type))
					return false;
				break;
			case MOVE_DOWN: 
				newPosition.setX(++destinoX);
				if(!map.isEmptyPosition(newPosition,type))
					return false;
				break;
			case MOVE_RIGHT: 
				newPosition.setY(++destinoY);
				if(!map.isEmptyPosition(newPosition,type))
					return false;
				break;
			case MOVE_LEFT:
				newPosition.setY(--destinoY);
				if(!map.isEmptyPosition(newPosition,type))
					return false;
				break;
			default : break;
		}
		
		map.setPosition(this,newPosition);
		
		return true;
	}

}

