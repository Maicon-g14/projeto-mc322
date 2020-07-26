package br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.attack;

import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;

public enum WeaponsTypes {
	DAGGER, SHORT_SWORD, LONG_SWORD;

	public static boolean isEquipable(GameTypeObjects person, WeaponsTypes itemClass) {
		/* Verifica se a classe dada pode equipar o tipo de arma dado
		 * mago - so equipa adaga
		 * elfo/dwarf - adagas ou espadas curtas
		 * barbaro - pode equipar qualquer arma */
		return ((person == GameTypeObjects.WIZARD || person == GameTypeObjects.GOBLIN) && itemClass == DAGGER)
				|| ((person == GameTypeObjects.ELF || person == GameTypeObjects.DWARF) && (itemClass == DAGGER || itemClass == SHORT_SWORD))
				|| (person == GameTypeObjects.BARBARIAN || person == GameTypeObjects.SKELETON);

	}
}
