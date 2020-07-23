package br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.Command;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;

import java.util.Random;
import java.util.Scanner;

public class CpuHero extends HeroController {

	public CpuHero(Hero personagem) {
		super(personagem);
	}

	@Override
	protected void newDirection(Map map, Scanner scanner) {
		/* Define direcao e distancia que o personagem deve andar ao longo dos trunos */
		Random randomize = new Random();

		chooseMovementDirection();

		int steps = rollRedDices(MOVE_DICES);        //rola dados de movimento
		remainingSteps = randomize.nextInt(steps) + 1;

		moving = true;
		callMove(map);
	}

	protected boolean action(Map map, Scanner scanner) {
		return true;        //sinal usado para subir escada e trocar mapa
	}

	private void chooseMovementDirection() {
		direction = Command.getRandomDirection();
	}

	@Override
	public Spell chooseSpell(Spell[] spells) {
		// TODO Auto-generated method stub
		return null;
	}

}
