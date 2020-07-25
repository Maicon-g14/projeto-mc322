package br.unicamp.mc322.lab10.projeto.map.objects;

import br.unicamp.mc322.lab10.projeto.map.objects.characters.Character;

public enum GameTypeObjects {
	DOOR, HIDDEN_DOOR, WALL, STAIR,
	MONEY, CHEST, TRAP, HEALTH_POTION,
	QUEST, QUEST_KEY,
	SHIELD1, SHIELD2,
	HEAVY_ARMOR1, HEAVY_ARMOR2,
	LIGHT_ARMOR1, LIGHT_ARMOR2,
	LONG_SWORD1, LONG_SWORD2,
	SHORT_SWORD1, SHORT_SWORD2,
	DAGGER1, DAGGER2,
	PLAYER,
	ELF, BARBARIAN, DWARF, WIZARD,
	GOBLIN, MAGE_SKELETON, SKELETON,
	TELEPORT, FIREBALL, MAGIC_MISSILE, SIMPLE_HEAL,
	MONSTER, HERO, GAME_OBJECT;
	
	public static boolean isMagicUser(Character person) {
		if(person.getId() == GameTypeObjects.ELF || person.getId() == GameTypeObjects.WIZARD || person.getId() == GameTypeObjects.MAGE_SKELETON)
			return true;
		return false;
	}
}
