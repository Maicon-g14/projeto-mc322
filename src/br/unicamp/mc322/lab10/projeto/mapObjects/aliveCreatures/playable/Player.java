//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.playable;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.Alive;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.ally.HeroClass;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.Defense;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class Player extends Alive{
	private static final GameTypeObjects ID = GameTypeObjects.PLAYER;
	private int attackDices;
	private int defenseDices;
	private HeroClass heroClass;
	
	public Player(String name, HeroClass heroClass, Coordinate position) { //trocar pra interface
		super(name,heroClass,ID,position);
	}
	
	public void equipDefenseEquipament(Defense newdefenseEquipament) {
		
	}
	
	public Defense unequipDefenseEquipament(int id) {
	/* Desequipa armadura ou escudo e retorna ela */	
		return null;
	}
	
	public Defense[] unequipDefenseEquipament() {
	/* Desequipa armadura e escudo e retorna ela */	
		return null;
	}
	
	public HeroClass getHeroClass() {
		return heroClass;
	}
	
	public int rollRedDices() {
		return (Integer) null;
	}
	
	public void walk() {
	/* pergunta ao usuario a direcao e, apos rolar os dados ate quantos passos quer andar */	
		
	}
}
