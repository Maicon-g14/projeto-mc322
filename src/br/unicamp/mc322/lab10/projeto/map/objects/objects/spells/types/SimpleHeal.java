//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SelfSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellElements;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellTypes;

public class SimpleHeal extends SelfSpell {

	private static final String NAME = "Simple Heal";
	private static final int DICES = 1;
	private static final SpellElements ELEMENT = SpellElements.WATER;
	private static final SpellTypes TYPE = SpellTypes.SUPPORT;
	private static final GameTypeObjects ID = GameTypeObjects.SIMPLE_HEAL;

	public SimpleHeal() {
		super(NAME, new Sprite(), ID, ELEMENT, TYPE);
	}

	public boolean use(Controller caster) {
		/* cura um d6 de vida */
		int amountRecovered = caster.rollRedDices(DICES);
		caster.getCharacter().recoverHp(amountRecovered);
		return true;
	}
}
