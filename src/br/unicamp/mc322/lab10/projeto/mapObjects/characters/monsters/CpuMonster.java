package br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters;
import java.util.Random;

import br.unicamp.mc322.lab10.projeto.Map;
import br.unicamp.mc322.lab10.projeto.WhiteDiceSides;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Character;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.CharacterController;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Controller;

public class CpuMonster extends CharacterController {

	
	public CpuMonster(Monster personagem) {
		super(personagem);
	}


	public void playTurn(Map map) {
		//faz o comportamento padrão dos monstros(provavelmente sera sobrescrito por cada monstro)
	}
	
	@Override
	public int rollDefenseDices() {
		//rola um numero de dados brancos e retorna o numero de escudos obtidos
		WhiteDiceSides dado;
		int n = 1;
		int result = 0;
		for(int i = 0; i < n; i++) {
			dado = rollWhiteDice();
			if(dado == WhiteDiceSides.MONSTER_DEFENSE)
				result++;
		}
		return result;
	}

	
}
