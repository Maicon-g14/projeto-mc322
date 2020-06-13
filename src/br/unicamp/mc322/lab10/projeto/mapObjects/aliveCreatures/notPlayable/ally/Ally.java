//RAs
//
//
//


package br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.ally;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.NotPlayable;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.Defense;

public class Ally extends NotPlayable {
	private Defense[] defenseEquipament = new Defense[2];
	private HeroClass heroClass;
	
	public Ally(String name, int hp, int mp, int atk, int def, String sprite, int attackDices, int defenseDices, HeroClass heroClass) {
	
	}
	
	public void equipDefenseEquipament(Defense newdefenseEquipament) {
		
	}
	
	public Defense unequipDefenseEquipment(int id) {
	/* Desequipa armadura ou escudo e retorna ela */	
		
	}
	
	public Defense[] unequipDefenseEquipment() {
	/* Desequipa armadura e escudo e retorna eles */	
		
	}
	
	public HeroClass getHeroClass() {
		return heroClass;
	}

}
