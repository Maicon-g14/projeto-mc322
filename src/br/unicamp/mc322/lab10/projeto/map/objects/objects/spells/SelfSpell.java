package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells;

import java.util.Scanner;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;

public abstract class SelfSpell extends Spell {

	public SelfSpell(String name, Sprite sprite, GameTypeObjects id, SpellElements spellElement, SpellTypes spellType, int price) {
		super(name, sprite, id, spellElement, spellType, price);
	}

	public abstract boolean use(Controller caster);
	
	public abstract boolean use(Map map, Controller caster);
	
	public abstract boolean use(Map map, Controller caster, Scanner reader);

}
