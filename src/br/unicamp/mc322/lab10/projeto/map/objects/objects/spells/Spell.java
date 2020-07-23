//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells;

import br.unicamp.mc322.lab10.projeto.map.objects.GameObject;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;

public abstract class Spell extends GameObject {

	private int dices;
	private SpellElements spellElement;
	private SpellTypes spellType;

	public Spell(String name, Sprite sprite, GameTypeObjects id, int dices, SpellElements spellElement, SpellTypes spellType) {
		super(name, sprite, id);
		this.dices = dices;
		this.spellElement = spellElement;
		this.spellType = spellType;
	}

	public int getDices() {
		return dices;
	}

	public SpellElements getElement() {
		return spellElement;
	}

	public SpellTypes getSpellType() {
		return spellType;
	}

	public abstract void use(Controller target);
}
