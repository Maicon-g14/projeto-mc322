package br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters;

import br.unicamp.mc322.lab10.projeto.map.objects.characters.CommonControllers;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;

import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.WhiteDiceSides;

public class CpuMonster extends CommonControllers {
	protected Monster monster;

	public CpuMonster(Monster monster) {
		this.monster = monster;
	}
	
	@Override
	public int rollAttackDices() {
		//rola todos os dados de ataque do personagem e retorna o numero de caveiras obtidas
		return rollWhiteDices(monster.getAttackDices(), WhiteDiceSides.ATTACK);
	}

	@Override
	public int rollDefenseDices() {
		return rollWhiteDices(monster.getDefenseDices(), WhiteDiceSides.MONSTER_DEFENSE);
	}
	
	@Override
	public int rollMagicDefenseDices() {
		return rollWhiteDices(monster.getIntelligence(), WhiteDiceSides.MONSTER_DEFENSE);
	}

	@Override
	public Monster getCharacter() {
		return monster;
	}

	@Override
	public void attack(Controller target) {
		//rola os dados de ataque do personagem, faz o alvo rolar os dados de defesa e chama a funçao de ataque do personagem
		int skulls = rollAttackDices();
		int shields = target.rollDefenseDices();

		if (skulls > shields) {
			monster.attack(target.getCharacter(), skulls - shields);
		}
	}
	
}
