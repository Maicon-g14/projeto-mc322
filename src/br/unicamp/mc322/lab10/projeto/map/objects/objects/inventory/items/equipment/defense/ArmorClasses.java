package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.defense;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;

public enum ArmorClasses {
	HEAVY_ARMOR, LIGHT_ARMOR, SHIELD;
	
	public static boolean isEquipable(GameTypeObjects person, ArmorClasses itemClass) {
		/* Verifica se a classe dada pode equipar o tipo de item de defesa dado
		 * mago - nao utiliza armadura ou escudo
		 * elfo - pode utilizar armadura leve
		 * dwarf - pode utilizar armadura leve e escudo
		 * barbaro - pode utilizar qualquer armadura ou escudo(equipavel so caso use arma de uma mao) */
		if ((person == GameTypeObjects.ELF || person == GameTypeObjects.DWARF) && itemClass == LIGHT_ARMOR) {
			return true;
		} else if (person == GameTypeObjects.DWARF && itemClass == SHIELD) {
			return true;
		} else if (person == GameTypeObjects.BARBARIAN) {
			return true;
		}
		return false;
	}
}
