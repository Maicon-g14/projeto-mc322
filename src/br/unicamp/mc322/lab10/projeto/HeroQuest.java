//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;
import br.unicamp.mc322.lab10.projeto.mapConstructor.MapLoad;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;

public class HeroQuest {
	
	private Map map;		//se refere a uma cena, a sala atual do jogo
	private MapLoad mapLoaded;		//classe que tem todas as salas
	private GameMode gameMode;		//dificuldade do jogo
	
	public HeroQuest(GameMode gameMode, MapMode mapMode) {
	/* Inicializa classe Map, MapLoad, todos os elementos do jogo e passa eles para a classe Map ja
	 * com suas coordenadas(uma vez recebido o mapa é preciso identificar as quantidades de 
	 * cada item nele e chamar a criação desses com as coordenadas obtidas */
		
	}
	
	public void market() {
	/* Cria loja para comprar item entre as quests */	
		
	}
	
	public void rollDice() {
	/* rola um d6 e devolve um valor, ver possibilidade de retornar true/false em certos casos */	
		
	}
	
	public void quest() {
	/* Define ou chama classe(precisa ser implementada) que monta uma quest */
		
	}
	
	public void startGame() {
	/* Loop principal do jogo, chama a criacao de novos mapas, chama verificacao de inimigo
	 * em area de ataque em map */	
		
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
