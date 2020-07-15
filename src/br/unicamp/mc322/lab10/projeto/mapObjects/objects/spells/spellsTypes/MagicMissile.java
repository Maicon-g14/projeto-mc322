//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.spellsTypes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.SpellElements;

public class MagicMissile extends Spell{
	private static final String NAME = "Magic Missile";
	private static final int DICES = 6;		//dano maximo(ou metade)
	private static final SpellElements ELEMENT = SpellElements.AIR;
	private static final GameTypeObjects ID = GameTypeObjects.MAGIC_MISSILE;
	
	public MagicMissile() {
		super(NAME, new Sprite(), ID, DICES, ELEMENT);
	}
	
	public void use() {
		
	}
}
