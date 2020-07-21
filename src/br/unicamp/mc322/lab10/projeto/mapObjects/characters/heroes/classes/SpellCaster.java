package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.spells.Spell;

public class SpellCaster extends Hero{

	private Spell[] spells;
	private int qtdSpells;
	
	public SpellCaster(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices,
			int defenseDices) {
		super(name, id, hp, mp, sprite, attackDices, defenseDices);
	}
	
	public SpellCaster(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices,
			int defenseDices, Spell[] spells) {
		super(name, id, hp, mp, sprite, attackDices, defenseDices);
		this.spells = spells;
		qtdSpells = spells.length;
	}

	public SpellCaster(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices,
			int defenseDices, CanCarry[] initialEquipment) {
		super(name, id, hp, mp, sprite, attackDices, defenseDices, initialEquipment);
	}
	
	public SpellCaster(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices,
			int defenseDices, CanCarry[] initialEquipment, Spell[] spells) {
		super(name, id, hp, mp, sprite, attackDices, defenseDices, initialEquipment);
		this.spells = spells;
		qtdSpells = spells.length;
	}
	
	public Spell[] getSpells() {
		return spells;
	}
	
	public void addSpell(Spell newSpell) {
		//Adiciona uma nova magia
		Spell[] auxSpells;
		if(qtdSpells < spells.length)
			spells[qtdSpells] = newSpell;
		else {
			auxSpells = new Spell[2*spells.length];
			for(int i = 0; i < qtdSpells; i++) {
				auxSpells[i] = spells[i];
			}
			auxSpells[qtdSpells++] = newSpell;
			spells = auxSpells;
		}
	}
	
	public void removeSpell(int n) {
		for(int i = n - 1; i < qtdSpells - 1; i++) {
			spells[i] = spells[i + 1];
		}
	}
	
	public void castSpell(Controller target, Spell spell, int dice) {
		if (dice < getIntelligence()) {
			spell.use(target);
		}
	}
	
	public Spell getSpell(int n) {
		return spells[n];
	}
	
	

}
