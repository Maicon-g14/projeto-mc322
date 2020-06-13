//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.ally.Ally;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.enemy.Enemy;

public class Map {
	private GameObject[] sceneObjects;		//todos os objetos da cena
	private Enemy[] monsters;		//monstros da cena
	private Ally[] allies;		//aliados da cena incluindo o player
	private GameObject[][] map;		//mapa de paredes(paredes são objetos com colisao)
	
	public Map(String[][] map) {
		LoadMap(map);
	}
	
	public void printMap() {
	/* Chama refreshMap e mostra map recebido na tela */
	
	}
	
	public GameObject refreshMap() {
	/* Tira copia do map e preenche a copia com os sceneObjects, monsters e allies
	 * em suas devidas posições e os retorna */
		
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
	
	public void LoadMap(String[][] map) {
	/* Dado uma nova cena, prepara o map para receber as nova informações */
		sceneObjects = null;
		monsters = null;
		createObjectMap(map);
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
