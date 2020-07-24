//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.AreaSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellElements;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellTypes;

public class Fireball extends AreaSpell {

	private static final String NAME = "Fireball";
	private static final int DICES = 6;
	private static final SpellElements ELEMENT = SpellElements.FIRE;
	private static final SpellTypes TYPE = SpellTypes.AREA_ATTACK;
	private static final GameTypeObjects ID = GameTypeObjects.FIREBALL;

	public Fireball() {
		super(NAME, new Sprite(), ID, DICES, ELEMENT, TYPE);
	}

	public void use(Controller target) {
		int damage = 6;
		int shields = target.rollMagicDefenseDices();
		if (damage - shields > 0) {
			target.getCharacter().takeDamage(damage - shields);
		}
		
		
	}

	public void use(Controller mainTarget, Controller[] adjacentTargets) {
		int damage = 6;
		int shields = mainTarget.rollDefenseDices();

		if (damage - shields > 0) {
			mainTarget.getCharacter().takeDamage(damage - shields);
		}

		if (adjacentTargets != null) {
			damage = 3;

			for (Controller adjacentTarget : adjacentTargets) {
				if(adjacentTarget != null) {
					shields = adjacentTarget.rollDefenseDices();

					if (damage - shields > 0) {
						adjacentTarget.getCharacter().takeDamage(damage - shields);
					}
				}
			}

		}
	}
}
