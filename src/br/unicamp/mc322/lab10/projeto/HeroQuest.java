//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

import br.unicamp.mc322.lab10.projeto.mapConstructor.EquipmentLoad;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.HeroController;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.CpuMonster;

public class HeroQuest {
	private int floorsNumber = 0;
	private Map map;
	private HeroController[] heroesController;		//heroes[0] = player, heroes[1-3] = npcs
	private Market market;
	private EquipmentLoad findableEquipment;
	private Boolean running = false;
	private CpuMonster[][] monstersController;
	
	public HeroQuest(GameMode gameMode, MapMode mapMode,PlayableClasses choosenClass, String playerName) {
	/* Inicializa as classes principais e carrega o mapa do jogo com os componentes de cada cena */
		
		findableEquipment = new EquipmentLoad();
				
		map = new Map(gameMode,mapMode);
		
		heroesController = map.setPlayer(choosenClass,playerName);
		
		floorsNumber = map.getFloorsNumber();
				
		market = new Market(findableEquipment.getMarketItems());
				
		monstersController = map.getMonsters();
	}
	
	public void market() {
		/* Chama loja como outra forma de adquirir os itens do jogo */
		Hero player = heroesController[0].getCharacter();
		market.doShopping(player);
	}
	
	private void checkGameOver() {
		/* A cada turno checa se o player esta vivo e se ainda existem monstros no mapa,
		 * caso o player morra, ou nao existam mais monstros no mapa finaliza a execucao
		 * do jogo */
		Hero player = heroesController[0].getCharacter();
		
		if(monstersController == null || monstersController[0] == null) {
			System.out.println("----------------\n- Voce ganhou!- \n----------------");
			running = false;
		}
		
		if(player.isDead()) {
			System.out.println("----------------\n- Voce perdeu!- \\n----------------");
			running = false;
		}
	}
	
	private void heroesTurn() {
		/* Executa o turno dos herois */
		for(int i = 0; i < heroesController.length; i++)			//heroesController.length
			heroesController[i].playTurn(map);
	}
	
	private void monstersTurn(int floor) {
		/* Executa o turno dos monstros */
		if (monstersController != null)
			for(int i = 0; i < monstersController[floor-1].length; i++)
				monstersController[floor-1][i].playTurn(map);
	}
	
	public void startGame() {
		/* Loop principal do jogo, chama os turnos, print do estado atual do jogo
		 *  e verifica a sua finalizacao */	
		Boolean turn = true;
		running = true;
		int floor = 1;
		
		System.out.println("Game started!");
		
		map.printScene();
		
		while(running && floor < floorsNumber) {
			turn = true;
			while(running && turn) {
				heroesTurn();
				monstersTurn(1);
				
				map.printScene();
				checkGameOver();
			}		//ver como vai ser feito o climb na escada pra sair dessa sala
			
			floor++;
			market();
		}
		
		System.out.println("Game terminated. Bye!");
	}
	
}
