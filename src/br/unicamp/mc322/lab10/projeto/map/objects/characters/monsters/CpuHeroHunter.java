package br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.Command;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.HeroController;

public class CpuHeroHunter extends CpuMonster {

	public CpuHeroHunter(Monster monster) {
		super(monster);
	}

	@Override
	protected void newDirection(Map map) {
		/* Chama a escolha do lado e movimentacao do monstro */
		HeroController[] heroes = map.getHeroes();

		findNearest(heroes);
		callMove(map);
	}

	private int smallestEllement(int[] array) {
		int smallestPosition = 0;

		for (int i = 1; i < array.length; i++)
			if (array[i] < array[smallestPosition])
				smallestPosition = i;

		return smallestPosition;
	}

	private int positivize(int number) {
		if (number < 0)
			return number * -1;
		return number;
	}

	private void setNearest(Coordinate source, Coordinate target) {
		/* A partir da posicao do heroi mais proximo,
		 * escolhe uma direcao para o monstro se mover */
		int x = source.getX() - target.getX();
		int y = source.getY() - target.getY();

		int w = positivize(x);
		int z = positivize(y);

		if (w >= z) {
			if (x > 0)
				direction = Command.MOVE_UP;
			else
				direction = Command.MOVE_DOWN;

		} else {
			if (y > 0)
				direction = Command.MOVE_LEFT;
			else
				direction = Command.MOVE_RIGHT;
		}
	}

	private void findNearest(HeroController[] heroes) {
		/* Escolhe o lado que o mosntro deve se mover para chegar no heroi mais proximo */
		int[] range = new int[heroes.length];
		Coordinate position = getCharacter().getPosition();
		Coordinate heroPosition;

		for (int i = 0; i < heroes.length; i++) {
			heroPosition = heroes[i].getCharacter().getPosition();
			range[i] = position.measureDistance(heroPosition);
		}

		int chosenHero = smallestEllement(range);

		setNearest(position, heroes[chosenHero].getCharacter().getPosition());
	}

}
