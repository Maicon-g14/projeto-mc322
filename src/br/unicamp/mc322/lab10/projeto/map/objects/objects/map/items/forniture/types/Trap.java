//RAs
//221329
//224956 
//242233

package br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.forniture.types;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.forniture.Forniture;

public class Trap extends Forniture {

	private int damageValue;

	private static final char SPRITE = ' ';
	private static final GameTypeObjects ID = GameTypeObjects.TRAP;
	private static final String NAME = "Trap";

	public Trap(int damage, Coordinate position) {
		super(NAME, new Sprite(SPRITE), ID, position);
		damageValue = damage;
	}

	public void doDamage(Hero hero) {
		System.out.println(hero.getName() + " encontrou uma armadilha! Porem da pior forma...");
		hero.takeDamage(damageValue);
		System.out.println("Body Points restantes: " + hero.getHp());
	}

	public void disarmTrap() {
		System.out.println("Armadilha com " + damageValue + " de dano foi disarmada!");
	}

}
