package br.unicamp.mc322.lab10.projeto;

public class Coordinate {
	/* Representa a coordenada de um objeto no Mapa */
	private int x;
	private int y;
	private Boolean onMap;
	
	public Coordinate() {
		onMap = false;
	}
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
		onMap = true;
	}
	
	public void setOnInventory() {
		onMap = false;
	}
	
	public void setOnMap(int x, int y) {
		setX(x);
		setY(y);
		onMap = true;
	}
	
	public int getX(){
		if (!onMap)
			return -1;
		return x;
	}
	
	public int getY(){
		if (!onMap)
			return -1;
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public Boolean equals(Coordinate position) {
		if(x == position.getX() && y == position.getY())
			return true;
		return false;
	}
	
	public String toString() {
		if (!onMap)
			return "Objeto n�o esta no mapa";
		return "("+x+","+y+")";
	}
}
