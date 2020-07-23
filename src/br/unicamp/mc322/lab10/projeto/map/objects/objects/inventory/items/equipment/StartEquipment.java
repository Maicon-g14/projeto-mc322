package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment;

import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.items.Dagger;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.items.LongSword;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.items.ShortSword;

public class StartEquipment {

	private Equipment[] barbarianEquip;
	private Equipment[] dwarfEquip;
	private Equipment[] elfEquip;
	private Equipment[] wizardEquip;

	public StartEquipment() {
		createBarbarian();
		createDwarf();
		createElf();
		createWizard();
	}

	public Equipment[] getBarbarian() {
		return barbarianEquip;
	}

	public Equipment[] getDwarf() {
		return dwarfEquip;
	}

	public Equipment[] getElf() {
		return elfEquip;
	}

	public Equipment[] getWizard() {
		return wizardEquip;
	}

	private void createBarbarian() {
		barbarianEquip = new Equipment[1];
		barbarianEquip[0] = new LongSword();
	}

	private void createDwarf() {
		dwarfEquip = new Equipment[1];
		dwarfEquip[0] = new ShortSword();
	}

	private void createElf() {
		elfEquip = new Equipment[1];
		elfEquip[0] = new ShortSword();
	}

	private void createWizard() {
		wizardEquip = new Equipment[3];
		wizardEquip[0] = new Dagger();
		wizardEquip[1] = new Dagger();
		wizardEquip[2] = new Dagger();
	}
	
}
