//RAs
//221329
//224956 
//242233

package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SelfSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellElements;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellTypes;

import java.util.Scanner;

public class SimpleHeal extends SelfSpell {

	private static final String NAME = "Simple Heal";
	private static final int DICES = 1;
	private static final SpellElements ELEMENT = SpellElements.WATER;
	private static final SpellTypes TYPE = SpellTypes.SUPPORT;
	private static final GameTypeObjects ID = GameTypeObjects.SIMPLE_HEAL;
	private static final int PRICE = 100;

	public SimpleHeal() {
		super(NAME, new Sprite(), ID, ELEMENT, TYPE, PRICE);
	}

	public boolean use(Controller caster) {
		/* cura um d6 de vida */
		int amountRecovered = caster.rollRedDices(DICES);
		caster.getCharacter().recoverHp(amountRecovered);
		return true;
	}

	@Override
	public void use(Map map, Controller caster, Controller target) {
		//metodo vazio

	}

	@Override
	public boolean use(Map map, Controller caster) {
		return false;
	}

	@Override
	public boolean use(Map map, Controller caster, Scanner reader) {
		return false;
	}
}
