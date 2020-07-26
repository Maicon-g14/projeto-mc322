package br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.classes;

import java.util.Scanner;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.Monster;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.AreaSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SelfSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;

public class MonsterSpellCaster extends Monster{

	private Spell[] spells;
	private int qtdSpells;
	
	public MonsterSpellCaster(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices,
			int defenseDices, Coordinate position) {
		super(name, id, hp, mp, sprite, attackDices, defenseDices, position);
		spells = null;
		qtdSpells = 0;
	}
	
	public MonsterSpellCaster(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices,
			int defenseDices, Coordinate position, CanCarry[] initialEquipment) {
		super(name, id, hp, mp, sprite, attackDices, defenseDices, position, initialEquipment);
		spells = null;
		qtdSpells = 0;
	}

	public MonsterSpellCaster(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices,
			   int defenseDices, Coordinate position, Spell[] spells) {
		super(name, id, hp, mp, sprite, attackDices, defenseDices, position);
		this.spells = spells;
		qtdSpells = spells.length;
	}
	
	public MonsterSpellCaster(String name, GameTypeObjects id, int hp, int mp, Sprite sprite, int attackDices,
				   int defenseDices, Coordinate position, CanCarry[] initialEquipment, Spell[] spells) {
		super(name, id, hp, mp, sprite, attackDices, defenseDices, position, initialEquipment);
		this.spells = spells;
		qtdSpells = spells.length;
	}
	
	public Spell[] getSpells() {
		return spells;
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
		if (dice < getIntelligence()) {
			spell.use(target);
		} else {
			System.out.println("Mas erra!");
		}
	}
	
	public void castSpell(Map map, Controller target, SelfSpell spell, int dice) {
		if (dice < getIntelligence()) {
			spell.use(map, target);
		} else {
			System.out.println("Mas erra!");
		}
	}
	
	public void castSpell(Map map, Controller target, SelfSpell spell, int dice, Scanner reader) {
		if (dice < getIntelligence()) {
			spell.use(map, target, reader);
		} else {
			System.out.println("Mas erra!");
		}
	}

	public void castSpell(Map map, Controller caster, Controller target, Spell spell, int dice) {
		if (dice < getIntelligence()) {
			spell.use(map, caster, target);
		} else {
			System.out.println("Mas erra!");
		}
	}
	
	public void castSpell(Map map, Controller caster, Controller target, Controller[] additionalTargets, Spell spell, int dice) {
		AreaSpell areaSpell = (AreaSpell)spell;
		if (dice < getIntelligence()) {
			areaSpell.use(map, caster, target, additionalTargets);
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
