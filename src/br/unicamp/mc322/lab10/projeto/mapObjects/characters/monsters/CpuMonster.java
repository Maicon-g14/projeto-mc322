package br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters;
import br.unicamp.mc322.lab10.projeto.Map;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Character;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Controller;

public class CpuMonster implements Controller {

	
	
	@Override
	public void playTurn(Map map) {
		//faz o comportamento padrão dos monstros(provavelmente sera sobrescrito por cada monstro)
	}

	@Override
	public Character getCharacter() {
		return null ;
	}

	@Override
	public int rollDices(int n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rollAttackDices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rollDefenseDices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void attack(Controller target) {
		// TODO Auto-generated method stub
		
	}
	
}
