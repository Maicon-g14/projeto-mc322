package br.unicamp.mc322.lab10.projeto.map;

public class Coordinate {
	/* Representa a coordenada de um objeto no Mapa */
	private int x;
	private int y;
	private boolean onMap;

	public Coordinate() {
		onMap = false;
	}

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
		onMap = true;
	}

	public int getX() {
		if (!onMap) {
			return -1;
		}

		return x;
	}

	public int getY() {
		if (!onMap) {
			return -1;
		}

		return y;
	}

	public int measureDistance(Coordinate position) {
		/* Retorna a soma das distancias em X e Y da coordenada passada
		 * com a do objeto atual */
		int positionX = positivize(getX() - position.getX());
		int positionY = positivize(getY() - position.getY());

		return (positionX + positionY) / 2;
	}

	public String toString() {
		if (!onMap) {
			return "Objeto nao esta no mapa";
		}

		return "(" + x + "," + y + ")";
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setOnInventory() {
		onMap = false;
	}

	public void setOnMap(int x, int y) {
		setX(x);
		setY(y);
		onMap = true;
	}

	private int positivize(int number) {
		/* Torna numero dado em valor positivo */
		if (number < 0) {
			return number * -1;
		}

		return number;
	}

}
