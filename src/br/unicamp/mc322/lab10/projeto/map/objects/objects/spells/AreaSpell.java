package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;

public abstract class AreaSpell extends Spell {
	private int adjacentRange;

	public AreaSpell(String name, Sprite sprite, GameTypeObjects id, SpellElements spellElement,
			SpellTypes spellType, int range, int adjacentRange) {
		super(name, sprite, id, spellElement, spellType, range);
		this.adjacentRange = adjacentRange;
	}
	
	public void use(Controller caster, Controller target) {
		
	}
	
	public int getAdjacentReach() {
		return adjacentRange;
	}
	
	public abstract void use(Controller caster, Controller target, Controller[] additionalTargets);

}
