//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;
import java.util.Random;

import br.unicamp.mc322.lab10.projeto.mapConstructor.MapLoad;
import br.unicamp.mc322.lab10.projeto.mapConstructor.PresetMap;
import br.unicamp.mc322.lab10.projeto.mapConstructor.RandomMap;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.CpuHero;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.HeroController;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Player;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.Barbarian;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.Dwarf;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.Elf;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.Wizard;

public class HeroQuest {
	
	private Map map;
	private GameMode gameMode;		//dificuldade do jogo
	private HeroController[] heroesController;		//heroes[0] = player, heroes[1-3] = npcs
	private Market market;
	private EquipmentLoad findableEquipment;
	
	public HeroQuest(GameMode gameMode, MapMode mapMode,PlayableClasses choosenClass, String playerName) {
	/* Inicializa classe Map, MapLoad, todos os elementos do jogo e passa eles para a classe Map ja
	 * com suas coordenadas(uma vez recebido o mapa é preciso identificar as quantidades de 
	 * cada item nele e chamar a criação desses com as coordenadas obtidas */
		//gerar a quest aqui antes
		this.gameMode = gameMode;
		
		findableEquipment = new EquipmentLoad();
		
		QuestBase questItems = quest();
		
		map = new Map(gameMode,mapMode);
		
		heroesController = map.setPlayer(choosenClass,playerName);
		
		
		map.setQuest(questItems);
		
		market = new Market(findableEquipment.getMarketItems());
		
		map.printScenes();
		
		
	}
	
	public void market() {
		/* Cria loja para comprar item entre as quests */
		Hero player = heroesController[0].getCharacter();
		market.doShopping(player);
	}
	
	public int rollRedDice(int qtde) {
		/* rola n d6 e devolve a soma dos valores */	
		int sum = 0;
		Random dice = new Random();
        
        for(int i = 0; i < qtde; i++)
            sum += dice.nextInt(6) + 1;
        
        return sum;
	}
	
	public int rollWhiteDice(int qtde, WhiteDiceSides lookingFor) {
		/* rola n d6 com 1 lado parar monster defense, 2 lados para hero defense e 3 para ataque.
		 * Sendo especificado o que o invocador busca, faz a soma das n ocorrencias aleatórias
		 * e a retorna. 
		 * Ex: funcao eh chamada buscando o ataque do jogador com 6 dados,
		 * logo sao rolados 6 dados e eh somado a quantidade de vezes que cada dado obteve a face
		 * ataque. */	
		int sum = 0, number;
		Random dice = new Random();
        
        for(int i = 0; i < qtde; i++) {
            number = dice.nextInt(6) + 1;
            
            if (number == 1 && lookingFor == WhiteDiceSides.MONSTER_DEFENSE)
            	sum += 1;
            
            else if ((number == 2 || number == 3) && lookingFor == WhiteDiceSides.HERO_DEFENSE)
            	sum += 1;
            
            else if (lookingFor == WhiteDiceSides.ATTACK)
            	sum += 1;
        }
        
        return sum;
		
		
	}
	
	public QuestBase quest() {
	/* Define ou chama classe(precisa ser implementada) que monta uma quest */
		return null;
	}
	
	public void startGame() {
	/* Loop principal do jogo, chama a criacao de novos mapas, chama verificacao de inimigo
	 * em area de ataque em map */	
		market();
	}
	
	public void loadMap() {
	/* Recebendo o tipo de mapa(gerado ou aleatorio), chama classe que contem 
	 * as informacoes do mapa(disposicao de paredes, portas, armadilhas, 
	 * monstros e baús) e devolve esse para ser passado a classe Mapa */	
		
	}
	
	public void createPlayer(Coordinate position) {
	/* Pergunta ao usuário qual a classe escolhida e nome para o personagem
	 * (por padrão ja é sugerido um nome de acordo com a classe escolhida),
	 * cria esse personagem e adiciona no Mapa */	
		
	}
	
	public void createMonsters(Coordinate[] position) {
	/* Aleatoriamente(ou por nivel de dificuldade que pode ser recebido), cria 
	 * uma N quantidade de monstros e adiciona no Mapa */	
		
	}
	
	public void createAllies(Coordinate position) {
	/* Desconsiderando a classe escolhida pelo player, cria e adiciona 3 aliados
	 * das demais classes no Mapa(se a dificuldade escolhida for mais alta,
	 * adiciona menos aliados), a posição recebida sera a posição do player */	
		
	}
	
	public GameObject createQuestItem(GameObject content) {
	/* Cria um objeto de quest qualquer e o adiciona no inventário do "content" passado, 
	 * pode retornar o item para ser adicionado em outro objeto tambem. 
	 * Ex funcionamento: recebendo um baú ou um monstro especifico, pode definir o drop dele, 
	 * também pode adicionar um item(de quest) diretamente no inventário do player
	 * (obs. verificar se acrescentar o item ao bau/monstro após ele for adicionado no mapa
	 * vai de fato acrescentar o item nele, ou se vai ser preciso definir o conteudo do monstro/bau
	 * antes de por ele no mapa) */	
		return null;
	}
	
	public void createMoney() {
	/* Inicializa classe Money(representa o dinheiro do personagem) e 
	 * a adiciona no Player */	
		
	}
	
	public void createTrap(Coordinate[] position) {
	/* Inicializa N classes Trap com as coordenadas P e as adiciona no Mapa */	
		
	}
	
	public void createChest(Coordinate[] position) {
	/* Inicializa N classes Chest com as coordenadas P e as adiciona no Mapa */	
		
	}
}
