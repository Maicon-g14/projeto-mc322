//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

import br.unicamp.mc322.lab10.projeto.exceptions.InvalidOperationException;
import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.MapMode;
import br.unicamp.mc322.lab10.projeto.map.constructor.EquipmentLoad;
import br.unicamp.mc322.lab10.projeto.map.constructor.PresetMap;
import br.unicamp.mc322.lab10.projeto.map.constructor.RandomMap;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.HeroController;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.Player;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.CpuMonster;

public class HeroQuest {

	private Map map;
	private HeroController[] heroesController;        //heroes[0] = player, heroes[1-3] = npcs
	private Market market;
	private boolean running = false;
	private CpuMonster[] monstersController;
	private boolean victory = false;

	public HeroQuest(GameMode gameMode, MapMode mapMode, PlayableClasses chosenClass, String playerName) {
		/* Inicializa as classes principais e carrega o mapa do jogo com os componentes de cada cena */
		EquipmentLoad findableEquipment = new EquipmentLoad();

		if (mapMode == MapMode.PREDEFINED) {
			map = new PresetMap(gameMode, chosenClass, playerName, findableEquipment);
		} else if (mapMode == MapMode.RANDOM) {
			map = new RandomMap(gameMode, chosenClass, playerName, findableEquipment);
		}

		market = new Market(findableEquipment.getMarketItems());
	}

	public void startGame() {
		/* Loop principal do jogo, chama os turnos, print do estado atual do jogo
		 * e verifica a sua finalizacao */
		if (map.isSuccessfullyLoaded()) {
			boolean turn;
			running = true;

			System.out.println("Game started!");

			do {
				turn = true;
				map.printScene();

				while (running && turn) {
					heroesController = map.getHeroes();
					monstersController = map.getMonsters();
					
					turn = heroesTurn();
					
					if(checkGameOver()) {
						break;
					}
					
					monstersTurn();
					
					if(checkGameOver()) {
						break;
					}
					
					map.printScene();
					
				}
	
				if (!checkGameOver()) {
					market();
				}
	
			} while (running && !checkGameOver() && map.nextMap());
	
			status();
			
			System.out.println("\nGame terminated. Bye!");
		}
	}

	public void market() {
		/* Chama loja como outra forma de adquirir os itens do jogo */
		try {
			Hero player = heroesController[0].getCharacter();
			market.doShopping(player);
		} catch (InvalidOperationException e) {
			System.err.println(e.getMessage());
		}

	}

	private boolean heroesTurn() {
		/* Executa o turno dos herois */
		boolean turn = true;

		for (HeroController heroController : heroesController) {

			if (heroController != null) {
				turn = heroController.playTurn(map);
			}

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
				
				if (heroesController[0] == null) {
					return;
				}
				
				cpuMonster.playTurn(map);
			}
		}
	}
	
	private void status() {
		if (victory) {
			System.out.println("----------------\n-  Game Over!  -\n- Voce ganhou! -\n----------------");
		} else {
			System.out.println("----------------\n-  Game Over!  -\n- Voce perdeu! -\n----------------");
		}
			
	}

	private boolean checkGameOver() {
		/* A cada turno checa se o player esta vivo e se ainda existem monstros no mapa,
		 * caso o player morra, ou nao existam mais monstros no mapa finaliza a execucao
		 * do jogo */

		if (map.allMonstersDefeated()) {
			victory = true;
			running = false;
			return true;
		}

		if (heroesController[0] != null && heroesController[0] instanceof Player) {
			Hero player = heroesController[0].getCharacter();
			if (player.isDead()) {
				running = false;
				return true;
			} 
		} else {
			return true;
		}
		return false;
	}
}
