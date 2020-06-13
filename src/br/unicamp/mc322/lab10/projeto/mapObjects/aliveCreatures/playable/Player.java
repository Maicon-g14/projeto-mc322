//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.playable;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.Alive;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.ally.HeroClass;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.Defense;

public class Player extends Alive{
	private final String SPRITE = "";
	private final int ID = 0;
	private String name = "";
	private int ATTACK_DICES;
	private int DEFENSE_DICES;
	private HeroClass heroClass;
	
	public Player(String name, HeroClass heroClass) {
	
	}
	
	public void equipDefenseEquipament(Defense newdefenseEquipament) {
		
	}
	
	public Defense unequipDefenseEquipament(int id) {
	/* Desequipa armadura ou escudo e retorna ela */	
		
	}
	
	public Defense unequipDefenseEquipament() {
	/* Desequipa armadura e escudo e retorna ela */	
		
	}
	
	public HeroClass getHeroClass() {
		return heroClass;
	}
	
	public void walk() {
	/* pergunta ao usuario a direcao e, apos rolar os dados ate quantos passos quer andar */	
		
	}
}
