//RAs
//221329
//224956 
//242233

package br.unicamp.mc322.lab10.projeto.map.objects.characters;

import br.unicamp.mc322.lab10.projeto.exceptions.FullInventoryException;
import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.Command;
import br.unicamp.mc322.lab10.projeto.map.objects.GameObject;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.classes.SpellCaster;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.money.Money;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.consumable.items.HealthPotion;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.Equipment;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.WeaponsTypes;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.ArmorClasses;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.Defense;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.Armor;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.Shield;

import java.util.Scanner;

public abstract class Character extends GameObject {

	private int hp;
	private int maxHP;
	private int intelligence;
	private int atkValue;
	private int defValue;
	protected CanCarry[] inventory;        //todos os seres vivos precisam de inventario, pois � onde fica o drop deles que deve cair no chao caso morrerem
	protected int inventoryLoad = 0;

	private int finalAttack;        //ataque padrao + item equipado
	private int finalDefense;
	private Attack[] attackEquipment = new Attack[2];        //pode equipar 2 armas ou uma 2handed
	private Defense[] defenseEquipment = new Defense[2];    //pode equipar armadura e se attackEquipment s� tiver 1 item nao 2handed pode equipar escudo
	private Boolean dead = false;
	private Money money = new Money();

	private static final int INVENTORY_MAX_AMOUNT = 30;

	public Character(String name, GameTypeObjects id, int hp, int intelligence, Sprite sprite, int atkValue, int defValue) {
		super(name, sprite, id);
		setCharacterStandarts(hp, intelligence, atkValue, defValue);
	}

	public Character(String name, GameTypeObjects id, int hp, int intelligence, Sprite sprite, int atkValue, int defValue, CanCarry[] initialEquipment) {
		super(name, sprite, id);
		setCharacterStandarts(hp, intelligence, atkValue, defValue);
		addToInventory(initialEquipment);
	}

	public Character(String name, GameTypeObjects id, int hp, int intelligence, Sprite sprite, int atkValue, int defValue, Coordinate position) {
		super(name, sprite, id, position);
		setCharacterStandarts(hp, intelligence, atkValue, defValue);
	}

	public Character(String name, GameTypeObjects id, int hp, int intelligence, Sprite sprite, int atkValue, int defValue, Coordinate position, CanCarry[] initialEquipment) {
		super(name, sprite, id, position);
		setCharacterStandarts(hp, intelligence, atkValue, defValue);
		addToInventory(initialEquipment);
	}

	public boolean move(Command direction, Map map) {
		/* Dada uma direcao, realiza um passo */
		int destinoX = getPosition().getX();
		int destinoY = getPosition().getY();
		Coordinate newPosition = new Coordinate(destinoX, destinoY);

		switch (direction) {
			case MOVE_UP:
				newPosition.setX(--destinoX);

				if (!map.isEmptyPosition(newPosition, this)) {
					return false;
				}

				break;
			case MOVE_DOWN:
				newPosition.setX(++destinoX);

				if (!map.isEmptyPosition(newPosition, this)) {
					return false;
				}

				break;
			case MOVE_RIGHT:
				newPosition.setY(++destinoY);

				if (!map.isEmptyPosition(newPosition, this)) {
					return false;
				}

				break;
			case MOVE_LEFT:
				newPosition.setY(--destinoY);

				if (!map.isEmptyPosition(newPosition, this)) {
					return false;
				}

				break;
			default:
				break;
		}

		map.setPosition(this, newPosition);

		return true;
	}

	public boolean isDead() {
		return dead;
	}

	public boolean buy(CanCarry item) {
		/* Se houver saldo, desconta e adiciona o item ao inventario */
		int price = item.getPrice();

		if (inventoryLoad < INVENTORY_MAX_AMOUNT && money.removeMoney(price)) {
			addToInventory(item);
			return true;
		} else if (inventoryLoad < INVENTORY_MAX_AMOUNT) {
			System.out.println("Saldo insuficiente!");		//nao por throw aqui pois faz o player sair da loja
		} else {
			System.out.println("Inventario cheio!");
		}
		return false;
	}

	public int getIntelligence() {
		/* Retorna inteligencia do personagem, usado pra lancar magias */
		return intelligence;
	}

	public int getHp() {
		return hp;
	}

	public int getAttackDices() {
		return finalAttack;
	}

	public int getDefenseDices() {
		return finalDefense;
	}

	public int showMoney() {
		return money.getMoney();
	}

	public int getInventoryLoad() {
		/* Retorna quantos itens tem no inventario */
		return inventoryLoad;
	}

	public CanCarry[] getInventory() {
		/* Retorna uma copia de todos os itens do inventario */
		return inventory;
	}

	public void addToInventory(CanCarry item) {
		/* Adiciona item ao inventario e caso seja um equipamento e melhor que o equipado,
		 * euipa ele e poe o anterior no inventario */
		if (inventoryLoad < INVENTORY_MAX_AMOUNT) {
			if (item instanceof Attack && isEquipable((Attack) item) && isBestWeapon((Attack) item)) {
				equipAttack((Attack) item);
			} else if (item instanceof Defense && isEquipable((Defense) item) && isBestArmor((Defense) item)) {
				equipDefense((Defense) item);
			} else if (this instanceof SpellCaster && item instanceof Spell) {
				SpellCaster person = (SpellCaster) this;
				person.addSpell((Spell) item);
			} else {
				inventory[inventoryLoad++] = item;
			}

		} else {
			throw new FullInventoryException("Inventario cheio!");
		}
	}

	public void addToInventory(CanCarry[] item) {
		/* Adiciona lista de items ao inventario */
		try {
			for (CanCarry canCarry : item) {
				addToInventory(canCarry);
			}
		} catch (FullInventoryException e) {
			System.err.println(e.getMessage());
		}

	}

	public void removeFromInventory(int id) {
		/* Dado a posicao do item no inventario, remove ele */
		inventory[id] = inventory[--inventoryLoad];
		inventory[inventoryLoad] = null;
	}

	public void sell(int id) {
		/* Funcao auxiliar na venda de itens */
		int price = inventory[id].getPrice();
		money.addMoney(price-5);
		removeFromInventory(id);
	}

	public void askPotion() {
		/* Pergunta se quer tomar pocao */
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Deseja utilizar uma pocao de vida? (s/n)");
		String entrada = scanner.nextLine();

		if ("S".equalsIgnoreCase(entrada) && !usePotion()) {
			System.out.println("Voce nao tem pocoes em seu inventario!");
		}
	}

	public void takeDamage(int damage) {
		/* Desconta do HP atual a quantidade dada, se morrer, ativa o dead */
		loseHp(damage);
	}
	
	public int getWeaponsReach() {
		/* Retorna o alcance da arma com maior alcance equipada */
		int maxReach = 1;		//alcance padrao dos punhos
		
		if(attackEquipment[0] != null && attackEquipment[0].getReach() > maxReach) {
			maxReach = attackEquipment[0].getReach();
		}
		if(attackEquipment[1] != null && attackEquipment[1].getReach() > maxReach) {
			maxReach = attackEquipment[1].getReach();
		}
		
		return maxReach;
	}
	
	private void refreshInventory() {
		for (int i = 0; i < inventoryLoad; i++) {
			if (inventory[i] instanceof Attack) {
				addToInventory(inventory[i]);
				removeFromInventory(i);
			}
		}
		
		if (inventoryLoad == 0) {
			refreshStatus();
		}
	}
	
	private void verifyWeapon() {
		if (attackEquipment[1] != null && attackEquipment[1].isBreakable()) {
			attackEquipment[1] = null;
		}
		
		if (attackEquipment[0] != null && attackEquipment[0].isBreakable()) {
			attackEquipment[0] = attackEquipment[1];
			attackEquipment[1] = null;
		}
		
		refreshInventory();
	}

	public void attack(Character target, int damage) {
		target.takeDamage(damage);
		verifyWeapon();
	}

	public void addRandomMoney() {
		System.out.print(getName()+" tem ");
		money.addRandomMoney();
	}

	public void recoverHp(int amount) {
		System.out.print("Body points restaurados!		HP: " + hp + " -> ");
		if (hp + amount < maxHP) {
			hp += amount;
		} else {
			hp = maxHP;
		}

		System.out.println(hp + "/" + maxHP);
	}

	protected void loseHp(int amount) {
		if (hp - amount > 0) {
			hp -= amount;
		} else {
			hp = 0;
			dead = true;
		}
		System.out.println(getName()+" tomou "+amount+" de dano e ficou com "+hp+" pontos de vida!");
	}
	
	private boolean isEquipable(Attack item) {
		/* Chama verificacao para saber se uma arma eh equipavel pela classe do personagem */
		WeaponsTypes itemClass = item.getWeaponClass();
		GameTypeObjects characterId = getId();
		return WeaponsTypes.isEquipable(characterId, itemClass);
	}
	
	private boolean isEquipable(Defense item) {
		/* Chama verificacao para saber se um item de defesa eh equipavel pela classe do personagem */
		ArmorClasses itemClass = item.getArmorClass();
		GameTypeObjects characterId = getId();
		return ArmorClasses.isEquipable(characterId, itemClass);
	}

	private boolean isBestWeapon(Attack item) {
		/* Caso o item passado tenha status melhor que o equipado, retorna true */
		return attackEquipment[0] == null || (attackEquipment[1] == null && !attackEquipment[0].isTwoHanded()) || item.getBonusAttack() > attackEquipment[0].getBonusAttack() || (attackEquipment[1] != null && item.getBonusAttack() > attackEquipment[1].getBonusAttack()) || (attackEquipment[1] != null && item.getBonusAttack() > attackEquipment[0].getBonusAttack() + attackEquipment[1].getBonusAttack());
	}

	private boolean isBestArmor(Defense item) {
		/* Caso o item passado tenha status melhor que o equipado, retorna true */
		return (item instanceof Shield && ((attackEquipment[0] == null || (attackEquipment[0] != null && !attackEquipment[0].isTwoHanded() && attackEquipment[1] == null)) && (defenseEquipment[1] == null || item.getBonusDefense() > defenseEquipment[1].getBonusDefense())) ||
				(item instanceof Armor && (defenseEquipment[0] == null || item.getBonusDefense() > defenseEquipment[0].getBonusDefense())));
	}

	private boolean usePotion() {
		/* Procura por potion no inventario, usa e apaga item */
		for (int i = 0; i < inventoryLoad; i++) {
			if (inventory[i].getId() == GameTypeObjects.HEALTH_POTION) {
				HealthPotion potion = (HealthPotion) inventory[i];
				recoverHp(potion.usePotion());

				inventory[i] = inventory[inventoryLoad - 1];
				inventory[inventoryLoad - 1] = null;
				inventoryLoad--;

				return true;
			}
		}

		return false;
	}

	private Equipment unequip(Equipment equipment) {
		/* Se houver, move item pro inventario e retorna null */
		if (equipment != null) {
			inventory[inventoryLoad++] = equipment;
		}

		return null;
	}

	private void equipAttack(Attack item) {
		/* Substitui item dado pelo item mais fraco equipado ou os dois pelo item dado
		 * caso seja 2handed */
		if (item.isTwoHanded()) {
			attackEquipment[1] = (Attack) unequip(attackEquipment[1]);        //desequipa a segunda arma
			defenseEquipment[1] = (Defense) unequip(defenseEquipment[1]);        //desequipa o escudo
			unequip(attackEquipment[0]);
			attackEquipment[0] = item;        //equipa a arma de duas maos

		} else if (attackEquipment[0] == null || attackEquipment[0].isTwoHanded()) {
			unequip(attackEquipment[0]);
			attackEquipment[0] = item;

		} else if (attackEquipment[1] == null) {
			defenseEquipment[1] = (Defense) unequip(defenseEquipment[1]);        //desequipa possivel escudo
			attackEquipment[1] = item;
			
		} else if (attackEquipment[0] != null && attackEquipment[1] != null) {
			
			if (item.getBonusAttack() > attackEquipment[0].getBonusAttack()) {       //se duas armas equipadas, substitui a mais fraca
				unequip(attackEquipment[0]);
				attackEquipment[0] = item;
			} else {
				unequip(attackEquipment[1]);
				attackEquipment[1] = item;
			}
		
		}

		refreshStatus();
	}

	private void equipDefense(Defense item) {
		/* Equipa armadura e escudo(com implicacao de remover segunda arma) */
		if (item instanceof Shield && (attackEquipment[0] == null || !attackEquipment[0].isTwoHanded())) {        //escudo nao equipa se estiver com arma de 2 maos
			attackEquipment[1] = (Attack) unequip(attackEquipment[1]);
			defenseEquipment[1] = item;

		} else if (item instanceof Armor) {
			defenseEquipment[0] = item;
		}

		refreshStatus();
	}

	private void refreshStatus() {
		/* Atualiza status do heroi adicionando o bonus dado pelo equipamento equipado */
		finalAttack = atkValue;

		if (attackEquipment[0] != null) {
			finalAttack += attackEquipment[0].getBonusAttack();
		}

		if (attackEquipment[1] != null) {
			finalAttack += attackEquipment[1].getBonusAttack();
		}

		finalDefense = defValue;

		if (defenseEquipment[0] != null) {
			finalDefense += defenseEquipment[0].getBonusDefense();
		}

		if (defenseEquipment[1] != null) {
			finalDefense += defenseEquipment[1].getBonusDefense();
		}
		
	}

	private void setCharacterStandarts(int hp, int intelligence, int atkValue, int defValue) {
		this.hp = hp;
		this.intelligence = intelligence;
		this.atkValue = atkValue;
		this.defValue = defValue;
		this.finalAttack = atkValue;
		this.finalDefense = defValue;
		money.setMoney(50);		//dinheiro inicial

		maxHP = hp;
		inventory = new CanCarry[INVENTORY_MAX_AMOUNT];
	}

}

