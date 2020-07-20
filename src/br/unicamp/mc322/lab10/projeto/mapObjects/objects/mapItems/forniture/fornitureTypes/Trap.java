//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.forniture.fornitureTypes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.forniture.Forniture;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class Trap extends Forniture{
	private static final char HIDDEN_SPRITE = ' ';
	private static final char SPRITE = 'T';
	private static final GameTypeObjects ID = GameTypeObjects.TRAP;
	private static final String NAME = "Trap";
	private int damageValue;
	
	public Trap(int damage,Coordinate position) {
		super(NAME,new Sprite(SPRITE,HIDDEN_SPRITE),ID,position);
		damageValue = damage;
		turnOffVisibility();
		disableCollision();
	}
	
	public void doDamage(Hero hero) {
		System.out.println(hero.getName() + " tomou " + damageValue + " de dano em uma armadilha oculta!\nBody Points restantes: " + hero.getHp());
		hero.takeDamage(damageValue);
	}
	
	public void disarmTrap() {
		damageValue = 0;
	}
	
	public void discoverTrap() {
		turnOnVisibility();
	}
}
