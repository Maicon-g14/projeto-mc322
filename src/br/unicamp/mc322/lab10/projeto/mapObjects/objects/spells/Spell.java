//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Controller;

public abstract class Spell extends GameObject{	
	private int dices; //Não entendi o propósito desse atributo
	private SpellElements spellElement;
	private SpellTypes spellType;
	
	public Spell(String name, Sprite sprite, GameTypeObjects id, int dices, SpellElements spellElement, SpellTypes spellType) {
		super(name,sprite,id);
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
