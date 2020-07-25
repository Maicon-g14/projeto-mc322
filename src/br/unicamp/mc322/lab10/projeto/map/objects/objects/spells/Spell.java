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

	private int range;
	private SpellElements spellElement;
	private SpellTypes spellType;

	public Spell(String name, Sprite sprite, GameTypeObjects id, SpellElements spellElement, SpellTypes spellType) {
		super(name, sprite, id);
		this.spellElement = spellElement;
		this.spellType = spellType;
		this.range = 0;        //feitico eh aplicado no proprio caster
	}

	public Spell(String name, Sprite sprite, GameTypeObjects id, SpellElements spellElement, SpellTypes spellType, int range) {
		super(name, sprite, id);
		this.spellElement = spellElement;
		this.spellType = spellType;
		this.range = range;
	}

	public int getReach() {
		return range;
	}

	public SpellElements getElement() {
		return spellElement;
	}

	public SpellTypes getSpellType() {
		return spellType;
	}

	public abstract void use(Controller caster, Controller target);
}
