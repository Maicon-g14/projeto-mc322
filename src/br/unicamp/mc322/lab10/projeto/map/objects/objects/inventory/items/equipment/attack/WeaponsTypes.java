package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;

public enum WeaponsTypes {
	DAGGER, SHORT_SWORD, LONG_SWORD;
	
	public static boolean isEquipable(GameTypeObjects person, WeaponsTypes itemClass) {
		/* Verifica se a classe dada pode equipar o tipo de arma dado
		 * mago - so equipa adaga
		 * elfo/dwarf - adagas ou espadas curtas
		 * barbaro - pode equipar qualquer arma */
		if (person == GameTypeObjects.WIZARD && itemClass == DAGGER) {
			return true;
		} else if ((person == GameTypeObjects.ELF || person == GameTypeObjects.DWARF) && (itemClass == DAGGER || itemClass == SHORT_SWORD)) {
			return true;
		} else if (person == GameTypeObjects.BARBARIAN) {
			return true;
		}
		return false;
	}
}
