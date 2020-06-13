package br.unicamp.mc322.lab10.projeto.mapConstructor;

import br.unicamp.mc322.lab10.projeto.Coordinate;

public class MapLoad {

	private int currentMap = 0;
	private String[][][] presetMaps = null;
	
	//fazer os devidos stubs
	//rever maps, loadMap e os presets
	
	public MapLoad() {
		
	}
	
	private void increaseMapSize(String map) {
	/* Aloca mais uma posicao para a string dada */	
		
	}
	
	private void increaseMapSize(String map, int size) {
	/* Aloca n posicoes para a string dada */	
		
	}
	
	public String[][] getMap() {
		return presetMaps[currentMap];
	}
	
	public String[][] previousMap(){
		if (currentMap == 0)
			return null;
		return presetMaps[--currentMap];
	}
	
	public String[][] nextMap(){
		if (currentMap > presetMaps.length)
			return null;
		return presetMaps[++currentMap];
	}
	
	public Coordinate[] getEnemies() {
	/* Percorre a cena atual criando vetor de coordenadas das posicoes 
	 * de inimigos que encontrar e retorna esse vetor */
		
	}
	
	public Coordinate[] getTraps() {
	/* Percorre a cena atual criando vetor de coordenadas das posicoes 
	 * de traps que encontrar e retorna esse vetor */
	
	}
	
	public Coordinate[] getDoors() {
	/* Percorre a cena atual criando vetor de coordenadas das posicoes 
	 * de doors que encontrar e retorna esse vetor */
		
	}
	
	public Coordinate[] getAllies() {
	/* Percorre a cena atual criando vetor de coordenadas das posicoes 
	 * do allies que encontrar e retorna esse vetor */
		
	}
	
	public Coordinate[] getChests() {
	/* Percorre a cena atual criando vetor de coordenadas das posicoes 
	 * de baus que encontrar e retorna esse vetor */
		
	}
	
}
