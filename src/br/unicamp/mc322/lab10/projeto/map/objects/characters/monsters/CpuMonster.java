package br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters;

import java.util.Random;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.Command;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Character;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.WhiteDiceSides;

public class CpuMonster implements Controller {
	protected static final int MOVE_DICES = 2;
	protected Command direction;
	protected Monster monster;
	protected int remainingSteps;
	protected boolean moving = false;

	public CpuMonster(Monster monster) {
		this.monster = monster;
	}

	private int rollWhiteDices(int qtde, WhiteDiceSides lookingFor) {
		/* rola n d6 com 1 lado parar monster defense, 2 lados para hero defense e 3 para ataque.
		 * Sendo especificado o que o invocador busca, faz a soma das n ocorrencias aleat�rias
		 * e a retorna.
		 * Ex: funcao eh chamada buscando o ataque do jogador com 6 dados,
		 * logo sao rolados 6 dados e eh somado a quantidade de vezes que cada dado obteve a face
		 * ataque. */
		int sum = 0, number;
		Random dice = new Random();

		for (int i = 0; i < qtde; i++) {
			number = dice.nextInt(6) + 1;

			if (((number == 1 && lookingFor == WhiteDiceSides.MONSTER_DEFENSE) ||
					((number == 2 || number == 3) && lookingFor == WhiteDiceSides.HERO_DEFENSE)) ||
					(lookingFor == WhiteDiceSides.ATTACK)) {
				sum += 1;
			}
		}

		return sum;
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
	public int rollMagicDefenseDices() {
		return rollWhiteDices(monster.getIntelligence(), WhiteDiceSides.MONSTER_DEFENSE);
	}

	@Override
	public int rollRedDices(int n) {
		int result = 0;
		Random gerador = new Random();

		for (int i = 0; i < n; i++) {
			result += 1 + gerador.nextInt(6);
		}

		return result;
	}

	@Override
	public Character getCharacter() {
		return monster;
	}

	public void playTurn(Map map) {
		/* Acao padrao dos monstros */
		if (!moving) {
			newDirection(map);
			action(map);
			
		} else if (!callMove(map)) {
			moving = false;
		}

		if (--remainingSteps <= 0) {
			moving = false;
		}
	}

	@Override
	public void attack(Character target) {
		// TODO Auto-generated method stub

	}

	protected void newDirection(Map map) {
		/* Define direcao e distancia que o personagem deve andar ao longo dos trunos */
		Random randomize = new Random();
		
		chooseMovementDirection();

		int steps = rollRedDices(MOVE_DICES);        //rola dados de movimento
		remainingSteps = randomize.nextInt(steps) + 1;

		moving = true;
		callMove(map);
	}

	protected boolean callMove(Map map) {
		/* Chama movimentacao do monstro */
		if (!getCharacter().move(direction, map)) {
			moving = false;
			return false;
		}
		
		return true;
	}

	private void chooseMovementDirection() {
		direction = Command.getRandomDirection();
	}

	private void action(Map map) {
		/* Acao do monstro alem de andar(por padrao eh atacar tudo que estiver no alcance) */
		Coordinate position = getCharacter().getPosition();
		Controller target = null;

		//if ((target = map.findTarget(this)) != null) {
			//chama ataque corpo a corpo aqui
		//}
	}

}
