package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;

public abstract class AreaSpell extends Spell {

	public AreaSpell(String name, Sprite sprite, GameTypeObjects id, int dices, SpellElements spellElement,
			SpellTypes spellType) {
		super(name, sprite, id, dices, spellElement, spellType);
	}

	public abstract void use(Controller target);
	
	public abstract void use(Controller target, Controller[] additionalTargets);

}
