//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types;

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

	public MagicMissile() {
		super(NAME, new Sprite(), ID, DICES, ELEMENT, TYPE);
	}

	public void use(Controller target) {
		int shields = target.rollMagicDefenseDices();
		int damage;
		//ciclo de 3 vezes pois são lançados 3 misseis, com o alvo podendo tentar defender cada um
		for (int i = 0; i < 3; i++) {
			damage = 2 - shields;

			if (damage > 0) {
				target.getCharacter().takeDamage(damage);
			}
		}
	}
}
