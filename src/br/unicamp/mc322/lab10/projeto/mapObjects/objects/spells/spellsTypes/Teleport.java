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

public class Teleport extends Spell{
	private static final String NAME = "Teleport";
	private static final int DICES = 0;		//nao se aplica
	private static final SpellElements ELEMENT = SpellElements.AIR;
	private static final SpellTypes TYPE = SpellTypes.SUPPORT;
	private static final GameTypeObjects ID = GameTypeObjects.TELEPORT;	
	
	public Teleport() {
		super(NAME, new Sprite(), ID, DICES, ELEMENT, TYPE);
	}
	
	public void use() {

	}

	public void use(Controller target) {

	}
}
