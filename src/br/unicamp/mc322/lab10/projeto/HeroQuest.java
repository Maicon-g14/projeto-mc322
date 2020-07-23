//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.MapMode;
import br.unicamp.mc322.lab10.projeto.map.constructor.EquipmentLoad;
import br.unicamp.mc322.lab10.projeto.map.constructor.PresetMap;
import br.unicamp.mc322.lab10.projeto.map.constructor.RandomMap;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.HeroController;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.CpuMonster;

public class HeroQuest {

	private Map map;
	private HeroController[] heroesController;        //heroes[0] = player, heroes[1-3] = npcs
	private Market market;
	private boolean running = false;
	private CpuMonster[] monstersController;

	public HeroQuest(GameMode gameMode, MapMode mapMode, PlayableClasses chosenClass, String playerName) {
		/* Inicializa as classes principais e carrega o mapa do jogo com os componentes de cada cena */
		EquipmentLoad findableEquipment = new EquipmentLoad();

		if (mapMode == MapMode.PREDEFINED) {
			map = new PresetMap(gameMode, chosenClass, playerName, findableEquipment);
		} else if (mapMode == MapMode.RANDOM) {
			map = new RandomMap(gameMode, chosenClass, playerName, findableEquipment);
		}

		heroesController = map.getHeroes();

		market = new Market(findableEquipment.getMarketItems());
	}

	public void startGame() {
		/* Loop principal do jogo, chama os turnos, print do estado atual do jogo
		 * e verifica a sua finalizacao */
		if(map.isSuccessfullyLoaded()) {
			boolean turn;
			running = true;
	
			System.out.println("Game started!");
			
			do {
				turn = true;
				monstersController = map.getMonsters();
				map.printScene();
	
				while (running && turn) {
					turn = heroesTurn();
					monstersTurn();
	
					map.printScene();
					checkGameOver();
				}
	
				market();
	
			} while (running && map.nextMap());
	
			System.out.println("Game terminated. Bye!");
		}
	}

	public void market() {
		/* Chama loja como outra forma de adquirir os itens do jogo */
		Hero player = heroesController[0].getCharacter();
		market.doShopping(player);
	}

	private boolean heroesTurn() {
		/* Executa o turno dos herois */
		boolean turn = true;

		for (HeroController heroController : heroesController) {            //heroesController.length
			turn = heroController.playTurn(map);

			if (!turn) {
				return turn;
			}
		}

		return turn;
	}

	private void monstersTurn() {
		/* Executa o turno dos monstros */
		if (monstersController != null) {
			for (CpuMonster cpuMonster : monstersController) {
				cpuMonster.playTurn(map);
			}
		}
	}

	private void checkGameOver() {
		/* A cada turno checa se o player esta vivo e se ainda existem monstros no mapa,
		 * caso o player morra, ou nao existam mais monstros no mapa finaliza a execucao
		 * do jogo */
		Hero player = heroesController[0].getCharacter();

		if (map.allMonstersDefeated()) {
			System.out.println("----------------\n-  Game Over!  -\n- Voce ganhou!- \n----------------");
			running = false;
		}

		if (player.isDead()) {
			System.out.println("----------------\n-  Game Over!  -\n- Voce perdeu! -\n----------------");
			running = false;
		}
	}
}
