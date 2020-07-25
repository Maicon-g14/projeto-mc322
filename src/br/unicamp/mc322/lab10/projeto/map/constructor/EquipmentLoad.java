package br.unicamp.mc322.lab10.projeto.map.constructor;

import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.consumable.items.HealthPotion;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.Equipment;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack.items.*;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.armors.BetterHeavyArmor;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.armors.BetterLightArmor;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.armors.HeavyArmor;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.armors.LightArmor;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.shields.Shield1;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense.items.shields.Shield2;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types.Fireball;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types.MagicMissile;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types.SimpleHeal;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types.Teleport;

import java.util.Random;

public class EquipmentLoad {
	/* Instancia de equipamentos que podem ser encontrados na market ou em monstros/baus */        //testar bem, pode bugar
	private CanCarry[] marketEquipment;

	private static final int MARKET_SIZE = 17;
	private static final int WEAPONS_RANGE = 5;

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

	public Equipment[] getRandomEquipment() {
		/* Retorna um item aleatorio do jogo */
		Random randomize = new Random();
		int chosen = randomize.nextInt(WEAPONS_RANGE) + 7;

		Equipment[] item = new Equipment[1];
		item[0] = (Equipment) marketEquipment[chosen];
		return item;
	}

	public CanCarry[] getMarketItems() {
		return marketEquipment;
	}
<<<<<<< HEAD
=======

	public Equipment[] getGoblinEquipment() {
		return goblinEquip;
	}
>>>>>>> d4280a4ca9f54c3b0b2ec5a2ee9b60b0c0e3c24f

	private void createEquipment() {
		/* Inicializa todos os equipamentos do jogo */
		marketEquipment[0] = new HealthPotion();
		marketEquipment[1] = new Shield1();
		marketEquipment[2] = new Shield2();
		marketEquipment[3] = new LightArmor();
		marketEquipment[4] = new BetterLightArmor();
		marketEquipment[5] = new HeavyArmor();
		marketEquipment[6] = new BetterHeavyArmor();
		marketEquipment[7] = new Dagger();
		marketEquipment[8] = new BetterDagger();
		marketEquipment[9] = new ShortSword();
		marketEquipment[10] = new BetterShortSword();
		marketEquipment[11] = new LongSword();
		marketEquipment[12] = new BetterLongSword();
<<<<<<< HEAD
		marketEquipment[13] = new SimpleHeal();
		marketEquipment[14] = new Teleport();
		marketEquipment[15] = new Fireball();
		marketEquipment[16] = new MagicMissile();
	}
	
=======
	}

	private void createGoblin() {
		Random randomize = new Random();
		int daggers = randomize.nextInt(7) + 3;

		goblinEquip = new Equipment[daggers];

		for (int i = 0; i < daggers; i++) {
			goblinEquip[i] = new Dagger();
		}
	}
>>>>>>> d4280a4ca9f54c3b0b2ec5a2ee9b60b0c0e3c24f
}
