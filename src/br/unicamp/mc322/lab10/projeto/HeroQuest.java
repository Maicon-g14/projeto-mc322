//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

import br.unicamp.mc322.lab10.projeto.mapConstructor.EquipmentLoad;
import br.unicamp.mc322.lab10.projeto.mapConstructor.PresetMap;
import br.unicamp.mc322.lab10.projeto.mapConstructor.RandomMap;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.HeroController;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.CpuMonster;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.forniture.fornitureTypes.Chest;

public class HeroQuest {
	private Map map;
	private HeroController[] heroesController;		//heroes[0] = player, heroes[1-3] = npcs
	private Market market;
	private Boolean running = false;
	private CpuMonster[] monstersController;
	
	public HeroQuest(GameMode gameMode, MapMode mapMode,PlayableClasses choosenClass, String playerName) {
	/* Inicializa as classes principais e carrega o mapa do jogo com os componentes de cada cena */
		if (mapMode == MapMode.PREDEFINED)
			map = new PresetMap(gameMode, choosenClass, playerName);
		else if (mapMode == MapMode.RANDOM)
			map = new RandomMap(gameMode, choosenClass, playerName);
		
		heroesController = map.getHeroes();
						
		EquipmentLoad findableEquipment = new EquipmentLoad();
		
		market = new Market(findableEquipment.getMarketItems());
		
		loadChests(findableEquipment);
	}
	
	public void startGame() {
		/* Loop principal do jogo, chama os turnos, print do estado atual do jogo 
		 * e verifica a sua finalizacao */	
		Boolean turn;
		running = true;

		System.out.println("Game started!");
		map.printScene();
		
		do {
			
			turn = true;
			monstersController = map.getMonsters();
			
			while(running && turn) {
				heroesTurn();
				monstersTurn();
				
				map.printScene();
				checkGameOver();
			}
			
			market();
			
		} while(running && map.nextMap());
		
		System.out.println("Game terminated. Bye!");
	}
	
	public void market() {
		/* Chama loja como outra forma de adquirir os itens do jogo */
		Hero player = heroesController[0].getCharacter();
		market.doShopping(player);
	}
	
	private void loadChests(EquipmentLoad findableEquipment) {
		Chest[] chests = map.getChests();
		
		for(int i = 0; i < chests.length; i++)
			chests[i].setContent(findableEquipment.getRandomLoot());
	}
	
	private void heroesTurn() {
		/* Executa o turno dos herois */
		for(int i = 0; i < heroesController.length; i++)			//heroesController.length
			heroesController[i].playTurn(map);
	}
	
	private void monstersTurn() {
		/* Executa o turno dos monstros */
		if (monstersController != null)
			for(int i = 0; i < monstersController.length; i++)
				monstersController[i].playTurn(map);
	}

	private void checkGameOver() {
		/* A cada turno checa se o player esta vivo e se ainda existem monstros no mapa,
		 * caso o player morra, ou nao existam mais monstros no mapa finaliza a execucao
		 * do jogo */
		Hero player = heroesController[0].getCharacter();
		
		if(map.allMonstersDefeated()) {
			System.out.println("----------------\n- Voce ganhou!- \n----------------");
			running = false;
		}
		
		if(player.isDead()) {
			System.out.println("----------------\n- Voce perdeu!- \\n----------------");
			running = false;
		}
	}
}
