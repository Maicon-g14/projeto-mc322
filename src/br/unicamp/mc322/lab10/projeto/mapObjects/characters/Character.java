package br.unicamp.mc322.lab10.projeto.mapObjects.characters;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.Map;
import br.unicamp.mc322.lab10.projeto.mapObjects.Command;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.Money.Money;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.consumable.comsumableItems.HealthPotion;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.Defense;

public abstract class Character extends GameObject{
	private static final int INVENTORY_MAX_AMOUNT = 30;
	private int HP;
	private int maxHP;
	private int intellect;
	private int ATKValue;
	private int DEFValue;
  private int range = 1; //alcance do personagem para realizar ataques, para todos os personagens é igual a 1 quando desarmado
	protected CanCarry[] inventory;		//todos os seres vivos precisam de inventario, pois � onde fica o drop deles que deve cair no chao caso morrerem
	protected int inventoryLoad = 0;
	
	private int finalAttack;		//ataque padrao + item equipado
	private int finalDefense;
	private Attack[] attackEquipament = new Attack[2];		//equipamento de ataque dos seres vivos ou null caso use as maos/garras/dentes etc
	private Defense defenseEquipment;
  private Boolean dead = false;
	private Money money = new Money();
	
	public Character(String name, GameTypeObjects id, int hp, int intellect, Sprite sprite, int ATKValue, int DEFValue, GameTypeObjects type) {
		super(name,sprite,id,type);
		setCharacterStandarts(hp,intellect,ATKValue,DEFValue);
		inventory = new CanCarry[INVENTORY_MAX_AMOUNT];
	}
	

	public Character(String name, GameTypeObjects id, int hp, int intellect, Sprite sprite, int ATKValue, int DEFValue, GameTypeObjects type, CanCarry[] initialEquipment) {
		super(name,sprite,id,type);
		setCharacterStandarts(hp,intellect,ATKValue,DEFValue);
		inventory = initialEquipment;
		inventoryLoad = initialEquipment.length;
	}
	
	public Character(String name, GameTypeObjects id, int hp, int intellect, Sprite sprite, int ATKValue, int DEFValue, Coordinate position, GameTypeObjects type) {
		super(name,sprite,id,position,type);
		setCharacterStandarts(hp,intellect,ATKValue,DEFValue);
		inventory = new CanCarry[INVENTORY_MAX_AMOUNT];
	}
	
	public Character(String name, GameTypeObjects id, int hp, int intellect, Sprite sprite, int ATKValue, int DEFValue, Coordinate position, GameTypeObjects type, CanCarry[] initialEquipment) {
		super(name,sprite,id,position,type);
		setCharacterStandarts(hp,intellect,ATKValue,DEFValue);
		inventory = initialEquipment;
		inventoryLoad = initialEquipment.length;
	}
	
	private void setCharacterStandarts(int hp, int intellect, int ATKValue, int DEFValue) {
		this.HP = hp;
		this.intellect = intellect;
		maxHP = hp;
		this.ATKValue = ATKValue;
		this.DEFValue = DEFValue;
	}
	
	public int getHp() {
		return HP;
	}
	
	public void usePotion() {
		/* Procura por potion no inventario, usa e apaga item */
		for (int i = 0; i < inventoryLoad; i++)
			if (inventory[i].getId() == GameTypeObjects.HEALTH_POTION) {
				HealthPotion potion = (HealthPotion) inventory[i];
				recoverHp(potion.usePotion());
				inventory[i] = inventory[inventoryLoad-1];
				inventory[inventoryLoad-1] = null;
				inventoryLoad--;
			}
	}
	
	protected void recoverHp(int amount) {
		if(HP + amount < maxHP)
			HP += amount;
		else
			HP = maxHP;
		System.out.println("Body points restaurados!	HP:" + HP);
	}
	
	protected void loseHp(int amount) {
		if(HP - amount > 0)
			HP -= amount;
		else {
			HP = 0;
			dead = true;
		}
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
		ATKValue = newAttackDices;
	}
	
	public int getAttackDices() {
		return ATKValue;
	}
	
	public void setDefenseDices(int newDefenseDices) {
		DEFValue = newDefenseDices;
	}
	
	public int getDefenseDices() {
		return DEFValue;
	}
	
	
	public void takeDamage(int damage) {
		/* Desconta do HP atual a quantidade dada, se morrer, ativa o dead */
		loseHp(damage);
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

