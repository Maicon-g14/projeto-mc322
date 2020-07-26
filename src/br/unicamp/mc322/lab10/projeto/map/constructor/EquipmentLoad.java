//RAs
//221329
//224956 
//242233

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
	/* Instancia de equipamentos que podem ser encontrados na market ou em monstros/baus */
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
		marketEquipment[13] = new SimpleHeal();
		marketEquipment[14] = new Teleport();
		marketEquipment[15] = new Fireball();
		marketEquipment[16] = new MagicMissile();
	}

}
