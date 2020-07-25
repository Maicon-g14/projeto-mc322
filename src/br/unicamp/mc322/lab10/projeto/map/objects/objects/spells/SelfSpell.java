package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;

public abstract class SelfSpell extends Spell {

	public SelfSpell(String name, Sprite sprite, GameTypeObjects id, SpellElements spellElement, SpellTypes spellType) {
		super(name, sprite, id, spellElement, spellType);
	}

	public void use(Controller caster, Controller target) {
		/* possivel expansao onde um player cura o outro */
	}

	public abstract boolean use(Controller caster);

}
