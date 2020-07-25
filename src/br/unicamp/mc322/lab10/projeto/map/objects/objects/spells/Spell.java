//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;

public abstract class Spell extends CanCarry {

	private int range;
	private SpellElements spellElement;
	private SpellTypes spellType;

	public Spell(String name, Sprite sprite, GameTypeObjects id, SpellElements spellElement, SpellTypes spellType, int price) {
		super(name, sprite, id, price);
		this.spellElement = spellElement;
		this.spellType = spellType;
		this.range = 0;        //feitico eh aplicado no proprio caster
	}
<<<<<<< HEAD
	
	public Spell(String name, Sprite sprite, GameTypeObjects id, SpellElements spellElement, SpellTypes spellType, int range, int price) {
		super(name, sprite, id, price);
=======

	public Spell(String name, Sprite sprite, GameTypeObjects id, SpellElements spellElement, SpellTypes spellType, int range) {
		super(name, sprite, id);
>>>>>>> d4280a4ca9f54c3b0b2ec5a2ee9b60b0c0e3c24f
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

	public abstract void use(Map map, Controller caster, Controller target);
}
