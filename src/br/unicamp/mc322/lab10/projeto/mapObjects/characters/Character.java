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
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.Equipment;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.Defense;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.Armor;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.Shield;

public abstract class Character extends GameObject{
	private static final int INVENTORY_MAX_AMOUNT = 30;
	private int HP;
	private int maxHP;
	private int intellect;
	private int ATKValue;
	private int DEFValue;
	protected CanCarry[] inventory;		//todos os seres vivos precisam de inventario, pois ï¿½ onde fica o drop deles que deve cair no chao caso morrerem
	protected int inventoryLoad = 0;
	
	private int finalAttack;		//ataque padrao + item equipado
	private int finalDefense;
	private Attack[] attackEquipment = new Attack[2];		//pode equipar 2 armas ou uma 2handed
	private Defense[] defenseEquipment = new Defense[2];	//pode equipar armadura e se attackEquipment só tiver 1 item nao 2handed pode equipar escudo
	private Boolean dead = false;
	private Money money = new Money();
	
	public Character(String name, GameTypeObjects id, int hp, int intellect, Sprite sprite, int ATKValue, int DEFValue, GameTypeObjects type) {
		super(name,sprite,id,type);
		setCharacterStandarts(hp,intellect,ATKValue,DEFValue);
	}
	
	public Character(String name, GameTypeObjects id, int hp, int intellect, Sprite sprite, int ATKValue, int DEFValue, GameTypeObjects type, CanCarry[] initialEquipment) {
		super(name,sprite,id,type);
		setCharacterStandarts(hp,intellect,ATKValue,DEFValue);
		addToInventory(initialEquipment);
	}
	
	public Character(String name, GameTypeObjects id, int hp, int intellect, Sprite sprite, int ATKValue, int DEFValue, Coordinate position, GameTypeObjects type) {
		super(name,sprite,id,position,type);
		setCharacterStandarts(hp,intellect,ATKValue,DEFValue);
	}
	
	public Character(String name, GameTypeObjects id, int hp, int intellect, Sprite sprite, int ATKValue, int DEFValue, Coordinate position, GameTypeObjects type, CanCarry[] initialEquipment) {
		super(name,sprite,id,position,type);
		setCharacterStandarts(hp,intellect,ATKValue,DEFValue);
		addToInventory(initialEquipment);
	}
	
	private void setCharacterStandarts(int hp, int intellect, int ATKValue, int DEFValue) {
		this.HP = hp;
		this.intellect = intellect;
		maxHP = hp;
		this.ATKValue = ATKValue;
		this.DEFValue = DEFValue;
		inventory = new CanCarry[INVENTORY_MAX_AMOUNT];
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
	
	public int getAttackDices() {
		return finalAttack;
	}
	
	public int getDefenseDices() {
		return finalDefense;
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
	
	private boolean isBestWeapon(Attack item) {
		/* Caso o item passado tenha status melhor que o equipado, retorna true */
		if (attackEquipment[0] == null || item.getBonusAttack() > attackEquipment[0].getBonusAttack() && (attackEquipment[1] == null || item.getBonusAttack() > attackEquipment[0].getBonusAttack() + attackEquipment[1].getBonusAttack()))
			return true;
		
		return false;
	}
	
	private boolean isBestArmor(Defense item) {
		/* Caso o item passado tenha status melhor que o equipado, retorna true */
		if (item instanceof Shield && (defenseEquipment[1] == null || item.getBonusDefense() > defenseEquipment[1].getBonusDefense()))
			return true;
		else if (item instanceof Armor && (defenseEquipment[0] == null || item.getBonusDefense() > defenseEquipment[0].getBonusDefense()))
			return true;
		
		return false;
	}
	
	private void equipAttack(Attack item) {
		/* Substitui item dado pelo item mais fraco equipado ou os dois pelo item dado
		 * caso seja 2handed */
		if(item.isTwoHanded()) {
			attackEquipment[1] = (Attack) unequip(attackEquipment[1]);		//desequipa a segunda arma
			defenseEquipment[1] = (Defense) unequip(defenseEquipment[1]);		//desequipa o escudo
			attackEquipment[0] = item;		//equipa a arma de duas maos
			
		} else if (attackEquipment[0] != null && attackEquipment[1] != null) {
			if (item.getBonusAttack() > attackEquipment[0].getBonusAttack())		//se duas armas equipadas, substitui a mais fraca
				attackEquipment[0] = item;
			else
				attackEquipment[1] = item;
		
		} else if (attackEquipment[0] == null || attackEquipment[0].isTwoHanded()){
			attackEquipment[0] = item;
		
		} else if (!attackEquipment[0].isTwoHanded()){
			defenseEquipment[1] = (Defense) unequip(defenseEquipment[1]);		//desequipa possivel escudo
			attackEquipment[1] = item;		//equipa como segunda arma
		}
		
		refreshStatus();
	}
	
	private void equipDefense(Defense item) {
		/* Equipa armadura e escudo(com implicacao de remover segunda arma) */
		if (item instanceof Shield && (attackEquipment[0] == null || !attackEquipment[0].isTwoHanded())) {		//escudo nao equipa se estiver com arma de 2 maos
			attackEquipment[1] = (Attack) unequip(attackEquipment[1]);
			defenseEquipment[1] = item;
			
		} else if (item instanceof Armor)
			defenseEquipment[0] = item;
		
		refreshStatus();
	}
	
	private Equipment unequip(Equipment equipment) {
		/* Se houver, move item pro inventario e retorna null */
		if (equipment != null)
			inventory[inventoryLoad++] = equipment;
		
		return null;
	}
	
	private void refreshStatus() {
		/* Atualiza status do heroi adicionando o bonus dado pelo equipamento equipado */
		finalAttack = ATKValue;
		
		if (attackEquipment[0] != null)
			finalAttack += attackEquipment[0].getBonusAttack();
		if (attackEquipment[1] != null)
			finalAttack += attackEquipment[1].getBonusAttack();
		
		finalDefense = DEFValue;
		
		if (defenseEquipment[0] != null)
			finalAttack += defenseEquipment[0].getBonusDefense();
		if (defenseEquipment[1] != null)
			finalAttack += defenseEquipment[1].getBonusDefense();
	}
	
	public void addToInventory(CanCarry item) {
		/* Adiciona item ao inventario e caso seja um equipamento e melhor que o equipado,
		 * euipa ele e poe o anterior no inventario */
		if(inventoryLoad < INVENTORY_MAX_AMOUNT) {
			if (item instanceof Attack && isBestWeapon((Attack) item)) {
				equipAttack((Attack) item);
			} else if (item instanceof Defense && isBestArmor((Defense) item)) {
				equipDefense((Defense) item);
			} else
				inventory[inventoryLoad++] = item;
			
		} else
			System.out.println("Inventario cheio!");
	}
	
	public void addToInventory(CanCarry[] item) {
		/* Adiciona lista de items ao inventario */
		for (int i = 0; i < item.length; i++)
			addToInventory(item[i]);
	}

	public void removeFromInventory(int id) {
		/* Dado a posicao do item no inventario, remove ele */
		inventory[id] = inventory[--inventoryLoad];
		inventory[inventoryLoad] = null;
	}
	
	public void sell(int id) {
		/* Funcao auxiliar na venda de itens */
		int price = inventory[id].getPrice();
		money.addMoney(price);
		removeFromInventory(id);
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
		/* Retorna quantos itens tem no inventario */
		return inventoryLoad;
	}
	
	public CanCarry[] getInventory() {
		/* Retorna uma copia de todos os itens do inventario */
		return inventory;
	}
	
	public int getIntelligence() {
		/* Retorna inteligencia do personagem, usado pra lancar magias */
		return intellect;
	}
	
	public boolean move(Command direction, Map map) {
		/* Dada uma direcao, realiza um passo */
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

