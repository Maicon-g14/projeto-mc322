package br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters;
import java.util.Random;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.Map;
import br.unicamp.mc322.lab10.projeto.mapObjects.Command;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Character;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.HeroController;

public class CpuMonster implements Controller {
	protected Command direction;
	protected Monster monster;
	
	public CpuMonster(Monster monster) {
		this.monster = monster;
	}
	
	@Override
	public void playTurn(Map map) {
		/* Acao padrao dos monstros */
		newDirection(map);
		action(map);
	}
	
	private void action(Map map) {
		/* Acao do monstro alem de andar(por padrao eh atacar tudo que estiver no alcance) */
		Coordinate position = getCharacter().getPosition();
		Character target = null;
		
		if((target = map.findTarget(position)) != null) {
			//chama ataque corpo a corpo aqui
		}
	}
	
	protected void newDirection(Map map) {
		/* Define direcao e distancia que o personagem deve andar ao longo dos trunos */		
		chooseMovementDirection();
		callMove(map);
	}
	
	private void chooseMovementDirection() {
		direction = Command.getRandomDirection();
	}
	
	protected void callMove(Map map) {
		/* Chama movimentacao do monstro */
		getCharacter().move(direction, map);
	}

	@Override
	public Character getCharacter() {
		return monster;
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

	@Override
	public int rollRedDices(int n) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
