package br.unicamp.mc322.lab10.projeto.map.constructor;

import java.util.Random;

import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.Equipment;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.items.Dagger;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types.MagicMissile;

public class MonstersLoad extends EquipmentLoad {

	private CanCarry[] goblinEquip;
	private CanCarry[] mageSkeleton;
	
	public MonstersLoad() {
		createGoblin();
		createMageSkeleton();
	}
	
	public CanCarry[] getGoblinEquipment() {
		return goblinEquip;
	}
	
	public CanCarry[] getSkeletonEquipment() {
		return getRandomEquipment();
	}
	
	public CanCarry[] getMageSkeletonEquipment() {
		return mageSkeleton;
	}
	
	private void createGoblin() {
		Random randomize = new Random();
		int daggers = randomize.nextInt(7) + 3;
		
		goblinEquip = new Equipment[daggers];
		
		for (int i = 0; i < daggers; i++) {
			goblinEquip[i] =  new Dagger();
		}
	}
	
	private void createMageSkeleton() {
		mageSkeleton = new CanCarry[1];
		mageSkeleton[0] = new MagicMissile();
	}
}
