package br.unicamp.mc322.lab10.projeto;

public class Coordinate {
	/* Representa a coordenada de um objeto no Mapa */
	private int x;
	private int y;
	private Boolean inInventory = false;
	
	public Coordinate() {
		x = 0;
		y = 0;
	}
	
	public void setInventory() {
		inInventory = true;
	}
	
	public void unsetInventory(int x, int y) {
		inInventory = false;
		setX(x);
		setY(y);
	}
	
	public int getX(){
		if (inInventory)
			return -1;
		return x;
	}
	
	public int getY(){
		if (inInventory)
			return -1;
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public String toString() {
		if (inInventory)
			return "Objeto não esta no mapa";
		return "("+x+","+y+")";
	}
}
