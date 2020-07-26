package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;

public abstract class AreaSpell extends Spell {
	private int adjacentRange;

	public AreaSpell(String name, Sprite sprite, GameTypeObjects id, SpellElements spellElement,
					 SpellTypes spellType, int range, int adjacentRange, int price) {
		super(name, sprite, id, spellElement, spellType, range, price);
		this.adjacentRange = adjacentRange;
	}

	public int getAdjacentReach() {
		return adjacentRange;
	}

	public abstract void use(Map map, Controller caster, Controller target, Controller[] additionalTargets);

}
