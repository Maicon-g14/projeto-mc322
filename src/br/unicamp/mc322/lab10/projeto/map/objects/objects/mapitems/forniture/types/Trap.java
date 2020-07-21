//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.mapitems.forniture.types;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.mapitems.forniture.Forniture;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class Trap extends Forniture {
	private static final char HIDDEN_SPRITE = ' ';
	private static final char SPRITE = 'T';
	private static final GameTypeObjects ID = GameTypeObjects.TRAP;
	private static final String NAME = "Trap";
	private int damageValue;

	public Trap(int damage, Coordinate position) {
		super(NAME, new Sprite(SPRITE, HIDDEN_SPRITE), ID, position);
		damageValue = damage;
		turnOffVisibility();
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
