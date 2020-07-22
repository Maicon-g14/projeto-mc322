package br.unicamp.mc322.lab10.projeto.map.constructor;

import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.consumable.items.HealthPotion;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.items.*;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.armors.BetterHeavyArmor;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.armors.BetterLightArmor;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.armors.HeavyArmor;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.armors.LightArmor;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.shields.Shield1;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.shields.Shield2;

import java.util.Random;

public class EquipmentLoad {
	/* Instancia de equipamentos que podem ser encontrados na market ou em monstros/baus */        //testar bem, pode bugar
	private CanCarry[] marketEquipment;

	private static final int MARKET_SIZE = 13;

	public EquipmentLoad() {
		marketEquipment = new CanCarry[MARKET_SIZE];
		createEquipment();
	}

	public CanCarry getRandomLoot() {
		/* Retorna um item aleatorio do jogo */
		Random randomize = new Random();
		int chosen = randomize.nextInt(MARKET_SIZE);

		return marketEquipment[chosen];
	}

	public CanCarry[] getMarketItems() {
		return marketEquipment;
	}

	private void createEquipment() {
		/* Inicializa todos os equipamentos do jogo */
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
}
