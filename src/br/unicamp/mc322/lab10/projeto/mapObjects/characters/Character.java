package br.unicamp.mc322.lab10.projeto.mapObjects.characters;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.Map;
import br.unicamp.mc322.lab10.projeto.mapObjects.Command;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.Attack;

public abstract class Character extends GameObject{
	private int HP;
	private int ATKValue;
	private int DEFValue;
	private CanCarry[] inventory;		//todos os seres vivos precisam de inventario, pois � onde fica o drop deles que deve cair no chao caso morrerem
									//inclusive as armas e armaduras de aliados/monstros
	private int MP;		//BodyPoints
	private int attackDices;
	private int defenseDices;
	private Attack[] attackEquipament = new Attack[2];		//equipamento de ataque dos seres vivos ou null caso use as maos/garras/dentes etc
	private Boolean dead = false;
	
	public Character(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices, int defenseDices) {
		super(name,sprite,id);
		this.HP = hp;
		this.MP = mp;
		ATKValue = attackDices;
		DEFValue = defenseDices;
	}
	
	public Character(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices, int defenseDices, Coordinate position) {
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

	public void removeInventory(int id) {
	
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
	

}

