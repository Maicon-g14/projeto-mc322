//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

import br.unicamp.mc322.lab10.projeto.mapConstructor.MapLoad;
import br.unicamp.mc322.lab10.projeto.mapConstructor.PresetMap;
import br.unicamp.mc322.lab10.projeto.mapConstructor.RandomMap;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.HeroController;

public class Map {
	private MapLoad map;
	
	public Map(GameMode gameMode, MapMode mapMode) {
		if (mapMode == MapMode.PREDEFINED)
			map = new PresetMap(gameMode);
		else if (mapMode == MapMode.RANDOM)
			map = new RandomMap(gameMode);
		
	}
	
	public HeroController[] setPlayer(PlayableClasses choosenClass, String playerName) {
		return map.addHeroes(choosenClass,playerName);
	}
	
	public Hero[] getHeroes() {
		return null;
	}
	
	public void printScenes() {
		//DEBUG
		printMap(map.getMap());
		printMap(map.nextMap());
		printMap(map.nextMap());
	}
	
	public void setQuest(QuestBase quest) {
		map.setQuest(quest);
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
	 * em suas devidas posi��es e os retorna */
		return null;
	}
	
	private void createObjectMap(String[][] map) {
	/* Transforma o mapa de strigns dado em um mapa de objetos e salva em map,
	 * inicialmente s� se coloca as paredes no map e o que for imovel/imutavel, 
	 * o refresh se encarrega de por os objetos sempre que for printar */
		
	}
	
	public Controller searchOpponent(Coordinate position, int range) {
	/* Pros inimigos verifica se existem aliados na area de ataque e pros aliados
	 * verifica se existem inimigos na areade ataque, se existirem, inicia o ataque */	
		return null;
	}
	
	public void getGroundItem() {
	/* Se pos do player for igual a de algum objeto CanCarry no chao, pega ele pra por no inventario */	
		
	}
	
	public void LoadMap(String[][] map) {
	/* Dado uma nova cena, prepara o map para receber as nova informa��es */
		//sceneObjects = null;
		//monsters = null;
		//createObjectMap(map);
	}
	
	public void addObject(Enemy monster) {
	/* Realoca e adiciona objeto recebido em seu respectivo vetor */
	
	}
	
	public void addObject(Ally ally) {
	/* Realoca e adiciona objeto recebido em seu respectivo vetor */
		
	}
	
	public void addObject(GameObject object) {
	/* Realoca e adiciona objeto recebido em seu respectivo vetor */
	
	}
	
	public void removeObject(int id) {
	/* Dado o ID de um objeto, procura nas listas allies, monsters e sceneObjects(respectivamente)
	 * ate encontrar o objeto e o remove da lista */
	
	}
}
