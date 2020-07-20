package br.unicamp.mc322.lab10.projeto.mapConstructor;

import java.util.Random;

import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.consumable.comsumableItems.HealthPotion;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.Equipment;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.attackItems.BetterDagger;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.attackItems.BetterLongSword;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.attackItems.BetterShortSword;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.attackItems.Dagger;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.attackItems.LongSword;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.attackItems.ShortSword;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.armors.BetterHeavyArmor;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.armors.BetterLightArmor;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.armors.HeavyArmor;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.armors.LightArmor;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.shields.Shield1;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.defenseItems.shields.Shield2;

public class EquipmentLoad {
	/* Intancia equipamentos que podem ser encpontrados na market ou em monstros/baus */		//testar bem, pode bugar
	private static final int MARKET_SIZE = 13;
	CanCarry[] marketEquipment;
	
	public EquipmentLoad(){
		marketEquipment = new CanCarry[MARKET_SIZE];
		
		createEquipment();
		
		additionalContent();
	}
	
	private void createEquipment() {
		marketEquipment[0] = new HealthPotion();
		marketEquipment[1] = new Shield1();
		marketEquipment[2] = new Dagger();
		marketEquipment[3] = new ShortSword();
		marketEquipment[4] = new LongSword();
		marketEquipment[5] = new LightArmor();
		marketEquipment[6] = new HeavyArmor();
		marketEquipment[7] = new BetterDagger();
		marketEquipment[8] = new BetterLongSword();
		marketEquipment[9] = new BetterShortSword();
		marketEquipment[10] = new Shield2();
		marketEquipment[11] = new BetterLightArmor();
		marketEquipment[12] = new BetterHeavyArmor();
	}
	
	public CanCarry getRandomLoot() {
		Random randomize = new Random();
		int choosen = randomize.nextInt(MARKET_SIZE);
		
		return marketEquipment[choosen];
	}
	
	public CanCarry[] getMarketItems() {
		return marketEquipment;
	}
	
	protected void additionalContent() {
		/* Passar para funcao abstrata, deve ser sobrescrita caso queira adicionar mais conteudo ao jogo */
	}
}
