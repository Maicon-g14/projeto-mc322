//RAs
//
//
//


package br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.ally;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.NotPlayable;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.Defense;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class Ally extends NotPlayable {
	private Defense[] defenseEquipament = new Defense[2];
	private HeroClass heroClass;
	
	public Ally(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices, int defenseDices, HeroClass heroClass,Coordinate position) {
		super(name,id,hp,mp,sprite,attackDices,defenseDices,position);
		this.heroClass = heroClass;
	}
	
	public void equipDefenseEquipament(Defense newDefenseEquipament) {
		
	}
	
	public Defense unequipDefenseEquipment(int id) {
	/* Desequipa armadura ou escudo e retorna ela */	
		return null;
	}
	
	public Defense[] unequipDefenseEquipment() {
	/* Desequipa armadura e escudo e retorna eles */	
		return null;
	}
	
	public HeroClass getHeroClass() {
		return heroClass;
	}

}
