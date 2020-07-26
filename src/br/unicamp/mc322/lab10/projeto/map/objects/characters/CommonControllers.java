package br.unicamp.mc322.lab10.projeto.map.objects.characters;

import java.util.Random;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.Command;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.WhiteDiceSides;

public abstract class CommonControllers implements Controller {
	
	protected static final int MOVE_DICES = 2;
	protected Command direction;
	protected boolean moving = false;
	protected int remainingSteps;
	
	@Override
	public boolean playTurn(Map map) {
		/* Acao padrao dos monstros */
		if (!moving) {
			action(map);
			newDirection(map);
			
		} else if (!callMove(map)) {
			moving = false;
		}

		if (--remainingSteps <= 0) {
			moving = false;
		}
		
		return true;
	}
	
	protected void newDirection(Map map) {
		/* Define direcao e distancia que o personagem deve andar ao longo dos trunos */
		Random randomize = new Random();
		
		direction = Command.getRandomDirection();

		int steps = rollRedDices(MOVE_DICES);        //rola dados de movimento
		remainingSteps = randomize.nextInt(steps) + 1;

		moving = true;
		callMove(map);
	}
	
	protected boolean randomChoice() {
		/* Aleatoriamente retorna true ou false */
		Random randomize = new Random();
		return randomize.nextBoolean();
	}
	
	private void action(Map map) {
		/* Acao do monstro alem de andar(por padrao eh atacar tudo que estiver no alcance) */
		if (randomChoice())	{
			map.callAttack(this);
		} else {
			if (!useMagic(map)) {
				map.callAttack(this);
			}
		}
	}	
	
	protected boolean callMove(Map map) {
		/* Chama movimentacao do monstro */
		if (!getCharacter().move(direction, map)) {
			moving = false;
			return false;
		}
		
		return true;
	}
	
	public int rollMagicAttack(int dices) {
		return rollWhiteDices(dices, WhiteDiceSides.ATTACK);
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
	public int rollWhiteDices(int qtde, WhiteDiceSides lookingFor) {
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
	public void attack(Controller target) {
		//rola os dados de ataque do personagem, faz o alvo rolar os dados de defesa e chama a funcao de ataque do personagem
		int skulls = rollAttackDices();
		int shields = target.rollDefenseDices();

		if (skulls > shields) {
			getCharacter().attack(target.getCharacter(), skulls - shields);
		} else {
			System.out.println("Mas " + target.getCharacter().getName() + " se defende!");
		}
	}

}
