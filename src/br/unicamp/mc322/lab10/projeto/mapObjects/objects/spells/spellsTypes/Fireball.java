//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.spellsTypes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.SpellElements;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.SpellTypes;

public class Fireball extends Spell{
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
		int shields = target.rollDefenseDices();

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

			for (int i = 0; i < adjacentTargets.length; i++) {
				shields = adjacentTargets[i].rollDefenseDices();

				if (damage - shields > 0) {
					adjacentTargets[i].getCharacter().takeDamage(damage - shields);
				}
			}

		}
	}
}
