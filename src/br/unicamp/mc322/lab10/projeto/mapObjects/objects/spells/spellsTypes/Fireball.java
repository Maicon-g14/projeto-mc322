//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.spellsTypes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.SpellElements;

public class Fireball extends Spell{
	private static final String NAME = "Fireball";
	private static final int DICES = 6;
	private static final SpellElements ELEMENT = SpellElements.FIRE;
	private static final GameTypeObjects ID = GameTypeObjects.FIREBALL;
	
	public Fireball() {
		super(NAME, new Sprite(), ID, DICES, ELEMENT);
	}
}
