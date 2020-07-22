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

public class SimpleHeal extends Spell {

	private static final String NAME = "Simple Heal";
	private static final int DICES = 1;
	private static final SpellElements ELEMENT = SpellElements.WATER;
	private static final SpellTypes TYPE = SpellTypes.SUPPORT;
	private static final GameTypeObjects ID = GameTypeObjects.SIMPLE_HEAL;

	public SimpleHeal() {
		/* Damage negativo no player talvez */
		super(NAME, new Sprite(), ID, DICES, ELEMENT, TYPE);
	}

	public void use(Controller caster) {
		int dice = caster.rollRedDices(1);
		caster.getCharacter().takeDamage(-dice);
	}
}
