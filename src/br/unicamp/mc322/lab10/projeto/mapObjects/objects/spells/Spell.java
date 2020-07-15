//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;

public class Spell extends GameObject{	
	private int dices;
	private SpellElements spellElement;
	
	public Spell(String name, Sprite sprite, GameTypeObjects id, int dices, SpellElements spellElement) {
		super(name,sprite,id);
		this.dices = dices;
		this.spellElement = spellElement;
	}
	
	public int getDices() {
		return dices;
	}
	
	public SpellElements getElement() {
		return spellElement;
	}
	
}
