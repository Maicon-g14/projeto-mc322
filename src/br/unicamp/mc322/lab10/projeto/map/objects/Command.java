package br.unicamp.mc322.lab10.projeto.map.objects;

public enum Command {
	MOVE_UP, MOVE_DOWN, MOVE_RIGHT, MOVE_LEFT, STOP, SEARCH, USE, ATTACK, USE_MAGIC;

	public static Command getRandomDirection() {
		return values()[(int) (Math.random() * 4)];
	}
}