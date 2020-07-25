package br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.classes;

import java.util.Scanner;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.AreaSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SelfSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;

public class SpellCaster extends Hero {

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
		
		if (qtdSpells < spells.length) {
			spells[qtdSpells] = newSpell;
			qtdSpells++;
		} else {
		
			auxSpells = new Spell[2 * spells.length];
			
			for (int i = 0; i < qtdSpells; i++) {
				auxSpells[i] = spells[i];
			}
			
			auxSpells[qtdSpells++] = newSpell;
			spells = auxSpells;
		
		}
		
	}

	private void removeSpell(int n) {
		for (int i = n - 1; i < qtdSpells - 1; i++) {
			spells[i] = spells[i + 1];
		}
		qtdSpells--;
	}
	
	public void removeSpell(Spell spell) {
		for (int i = 0; i < qtdSpells - 1; i++) {
			if(spells[i] == spell) {
				removeSpell(i);
				break;
			}
		}
	}
	
	public void castSpell(Controller target, SelfSpell spell, int dice) {
<<<<<<< HEAD
		if (dice < getIntelligence()) {
			if(spell.use(target)) {
				//removeSpell(spell);
			} 
		} else {
			System.out.println("Mas erra!");
		}
	}
	
	public void castSpell(Map map, Controller target, SelfSpell spell, int dice) {
		if (dice < getIntelligence()) {
			if(spell.use(map, target)) {
				//removeSpell(spell);
			}
		} else {
			System.out.println("Mas erra!");
		}
	}
	
	public void castSpell(Map map, Controller target, SelfSpell spell, int dice, Scanner reader) {
		if (dice < getIntelligence()) {
			if(spell.use(map, target, reader)) {
				//removeSpell(spell);
			}
		} else {
			System.out.println("Mas erra!");
=======
		if (dice < getIntelligence() && spell.use(target)) {
			removeSpell(spell);
>>>>>>> d4280a4ca9f54c3b0b2ec5a2ee9b60b0c0e3c24f
		}
	}

	public void castSpell(Map map, Controller caster, Controller target, Spell spell, int dice) {
		if (dice < getIntelligence()) {
			spell.use(map, caster, target);
			//removeSpell(spell);
		} else {
			System.out.println("Mas erra!");
		}
	}
	
	public void castSpell(Map map, Controller caster, Controller target, Controller[] additionalTargets, Spell spell, int dice) {
		AreaSpell areaSpell = (AreaSpell)spell;
		if (dice < getIntelligence()) {
			areaSpell.use(map, caster, target, additionalTargets);
			//removeSpell(spell);
		} else {
			System.out.println("Mas erra!");
		}
	}

	public Spell getSpell(int n) {
		return spells[n];
	}
	
	public int getQtdSpells() {
		return qtdSpells;
	}


}
