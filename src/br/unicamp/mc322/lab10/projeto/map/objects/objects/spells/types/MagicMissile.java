//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellElements;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellTypes;

public class MagicMissile extends Spell {

	private static final String NAME = "Magic Missile";
	private static final int DICES = 6;        //dano maximo(ou metade)
	private static final SpellElements ELEMENT = SpellElements.AIR;
	private static final SpellTypes TYPE = SpellTypes.ATTACK;
	private static final GameTypeObjects ID = GameTypeObjects.MAGIC_MISSILE;
	private static final int PRICE = 150;
	private static final int DAMAGE_MULTIPLIER = 3;
	private static final int NO_DAMAGE = 0;
	private static final int REACH = 3;		//distancia maxima do atacante ate o alvo

	public MagicMissile() {
		super(NAME, new Sprite(), ID, ELEMENT, TYPE, REACH, PRICE);
	}

	public void use(Map map, Controller caster, Controller target) {
		/* Lanca 3 flexas magicas cada uma causando 2 danos no alvo */
		int shields = target.rollMagicDefenseDices();
		int damage;
		
		for (int i = 0; i < DAMAGE_MULTIPLIER; i++) {
			damage = caster.rollMagicAttack(DICES);
			damage -= shields;		//ciclo de 3 vezes pois sao lancados 3 misseis, com o alvo podendo tentar defender cada um

			if (damage > NO_DAMAGE) {
				target.getCharacter().takeDamage(damage);
				if (target.getCharacter().isDead()) {
					map.remove(target);
				}
			} else {
				System.out.println("Mas " + target.getCharacter().getName() + " se defendeu e nao tomou dano algum!");
			}
		}
	}
}
