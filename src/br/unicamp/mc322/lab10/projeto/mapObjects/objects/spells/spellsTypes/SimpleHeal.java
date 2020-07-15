//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.spellsTypes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.SpellElements;

public class SimpleHeal extends Spell{
	private static final String NAME = "Simple Heal";
	private static final int DICES = 1;
	private static final SpellElements ELEMENT = SpellElements.SUPPORT;
	private static final GameTypeObjects ID = GameTypeObjects.SIMPLE_HEAL;
	
	public SimpleHeal() {
	/* Damage negativo no player talvez */
		super(NAME, new Sprite(), ID, DICES, ELEMENT);
	}
	
	public void use() {
		
	}
}
