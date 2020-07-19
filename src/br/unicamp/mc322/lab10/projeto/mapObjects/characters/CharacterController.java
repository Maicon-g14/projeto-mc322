package br.unicamp.mc322.lab10.projeto.mapObjects.characters;

import java.util.Random;

import br.unicamp.mc322.lab10.projeto.Map;
import br.unicamp.mc322.lab10.projeto.WhiteDiceSides;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.Monster;

public abstract class CharacterController implements Controller{
	private Character personagem;
	
	public CharacterController(Character personagem) {
		this.personagem = personagem;
	}

	@Override
	public Character getCharacter() {
		return personagem;
	}

	public int rollDices(int n) {
		int result = 0;
		Random gerador = new Random();
		for(int i = 0; i < n; i ++) {
			result += 1 + gerador.nextInt(6);
		}
		return result;
	}
	
	@Override
	public WhiteDiceSides rollWhiteDice() {
		Random gerador = new Random();
		Double num = gerador.nextDouble();
		if(num < 1/6)
			return WhiteDiceSides.MONSTER_DEFENSE;
		else if(num < 3/6)
			return WhiteDiceSides.HERO_DEFENSE;
		else
			return WhiteDiceSides.ATTACK;
	}
	
	@Override
	public int rollAttackDices() {
		//rola um numero de dados brancos e retorna o numero de caveiras obtidas
		WhiteDiceSides dado;
		int n = personagem.getAttackValue();
		int result = 0;
		for(int i = 0; i < n; i++) {
			dado = rollWhiteDice();
			if(dado == WhiteDiceSides.ATTACK)
				result++;
		}
		return result;
	}
	
	@Override
	public abstract int rollDefenseDices() ;

	@Override
	public void attack(Controller target) {
		//rola os dados de ataque do personagem, faz o alvo rolar os dados de defesa e chama a função de ataque do personagem
		int skulls = rollAttackDices();
		int shields = rollDefenseDices();
		if (skulls > shields)
			personagem.attack(target.getCharacter(), skulls - shields);
		
	}
	
	public void findTarget(Map mapa) {
		Controller target = mapa.searchOpponent(personagem.getPosition(), personagem.getRange());
		if(target != null)
			attack(target);
	}
	
}