package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment;

import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.items.Dagger;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.items.LongSword;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.items.ShortSword;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types.Fireball;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types.MagicMissile;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types.SimpleHeal;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types.Teleport;

public class StartEquipment {

	private CanCarry[] barbarianEquip;
	private CanCarry[] dwarfEquip;
	private CanCarry[] elfEquip;
	private CanCarry[] wizardEquip;
	private Spell[] wizardSpell;
	private Spell[] elfSpell;

	public StartEquipment() {
		createBarbarian();
		createDwarf();
		createElf();
		createWizard();
	}

	public CanCarry[] getBarbarian() {
		return barbarianEquip;
	}

	public CanCarry[] getDwarf() {
		return dwarfEquip;
	}

	public CanCarry[] getElf() {
		return elfEquip;
	}

	public CanCarry[] getWizard() {
		return wizardEquip;
	}

	public Spell[] getElfSpells() {
		return elfSpell;
	}

	public Spell[] getWizardSpells() {
		return wizardSpell;
	}

	private void createBarbarian() {
		barbarianEquip = new CanCarry[1];
		barbarianEquip[0] = new LongSword();
	}

	private void createDwarf() {
		dwarfEquip = new CanCarry[1];
		dwarfEquip[0] = new ShortSword();
	}

	private void createElf() {
		elfEquip = new CanCarry[1];
		elfEquip[0] = new ShortSword();
		elfSpell = new Spell[1];
		elfSpell[0] = new SimpleHeal();
	}

	private void createWizard() {
		wizardEquip = new CanCarry[3];
		wizardEquip[0] = new Dagger();
		wizardEquip[1] = new Dagger();
		wizardEquip[2] = new Dagger();
		wizardSpell = new Spell[3];
		wizardSpell[0] = new MagicMissile();
		wizardSpell[1] = new Teleport();
		wizardSpell[2] = new Fireball();
	}

}
