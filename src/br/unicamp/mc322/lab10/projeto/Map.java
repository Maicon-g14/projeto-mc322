//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

import br.unicamp.mc322.lab10.projeto.mapConstructor.MapLoad;
import br.unicamp.mc322.lab10.projeto.mapConstructor.PresetMap;
import br.unicamp.mc322.lab10.projeto.mapConstructor.RandomMap;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.HeroController;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.CpuMonster;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes.Stair;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Character;

public class Map {
	/* Mesclagem da classe MapLoad para a classe Map */
	private MapLoad map;
	
	public Map(GameMode gameMode, MapMode mapMode) {
		if (mapMode == MapMode.PREDEFINED)
			map = new PresetMap(gameMode);
		else if (mapMode == MapMode.RANDOM)
			map = new RandomMap(gameMode);
		
	}
	
	public HeroController[] setPlayer(PlayableClasses choosenClass, String playerName) {
		/* Chama a criacao dos herois no mapa do jogo */
		return map.addHeroes(choosenClass,playerName);
	}
	
	public void printScene() {
		printMap(map.getMap());
	}
	
	public CpuMonster[][] getMonsters() {
		return map.getMonsters();
	}
	
	public void climbStair(Stair stair) {
		
	}
	
	public void openChest() {
		
	}
	
	public void searchTrap() {
		
	}
		
	public HeroController[] getHeroes() {
		return map.getHeroes();
	}
	
	public Character findTarget(Coordinate position) {
		/* Busca nos arredores da posicao dada se tem oponente pra atacar */
		return null;
	}
	
	public int getFloorsNumber() {
		/* Adquire o numero de andares da torre */
		return map.getFloorsNumber();
	}
	
	private void printMap(GameObject[][] map) {
	/* Chama refreshMap e mostra map recebido na tela */
		for (int j = 0; j < map.length; j++) {
			for (int k = 0; k < map[0].length; k++) {
				if (map[j][k] == null)
					System.out.printf(" ");
				else
					map[j][k].print();
			}
			System.out.printf("\n");
		}
		System.out.printf("\n");
	}
	
	public GameObject refreshMap() {
		/* Tira copia do map e preenche a copia com os sceneObjects, monsters e allies
		 * em suas devidas posições e os retorna */
		return null;
	}
	
	public Boolean isEmptyPosition(Coordinate position, GameTypeObjects type) {
		/* Checa se personagem pode se mover para a posicao dada.
		 * Monstros nao se movem para cima de armadilhas */
		if(map.isValid(position) && (map.getPosition(position) == null || (map.getPosition(position).getId() == GameTypeObjects.TRAP && type == GameTypeObjects.HERO)))
			return true;
		return false;
	}
	
	public void setPosition(Character character, Coordinate position) {
		/* Move personagem para a posicao dada(ja verificada antes) e, se for um heroi se movendo para uma
		 * armadilha, ativa ela */
		map.setPosition(character, position);
	}
	
	public void searchItem() {
	/* Se pos do player for igual a de algum objeto CanCarry no chao, pega ele pra por no inventario */	
		
	}
	
}
