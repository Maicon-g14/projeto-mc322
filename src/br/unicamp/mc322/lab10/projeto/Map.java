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
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.HeroController;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.Monster;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Character;

public class Map {
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
	
	public void setQuest(QuestBase quest) {
		map.setQuest(quest);
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
	
	private void createObjectMap(String[][] map) {
		/* Transforma o mapa de strigns dado em um mapa de objetos e salva em map,
		 * inicialmente só se coloca as paredes no map e o que for imovel/imutavel, 
		 * o refresh se encarrega de por os objetos sempre que for printar */
		
	}
	
	public void searchOpponent() {
	/* Pros inimigos verifica se existem aliados na area de ataque e pros aliados
	 * verifica se existem inimigos na areade ataque, se existirem, inicia o ataque */	
		
	}
	
	public void getGroundItem() {
	/* Se pos do player for igual a de algum objeto CanCarry no chao, pega ele pra por no inventario */	
		
	}
	
}
