//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapConstructor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.GameMode;
import br.unicamp.mc322.lab10.projeto.QuestBase;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes.Door;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes.Wall;

public class RandomMap extends MapLoad{
	private static final String path = "./src\\\\br\\\\unicamp\\\\mc322\\\\lab10\\\\projeto\\\\mapConstructor\\\\";
	private static final String fileName = "standartWalls.txt";
	private static final int MAPS_WIDTH = 36;
	private static final int MAPS_HEIGHT = 27;
	private static final int MAPS_AMOUNT = 3;
	private static final int HIDDEN_DOORS_MAX_AMOUNT_STANDART_MODE = 20;
	private static final int HIDDEN_DOORS_MAX_AMOUNT_HARD_MODE = 10;
	
	public RandomMap(GameMode gameMode) {
		/* A partir de um mapa pré-definido de paredes e possives posicoes de portas
		 * lido do HD, gera aleatoriamente um mapa com monstros, armadilhas e portas
		 * ocultas */		
		mapsAmount = MAPS_AMOUNT;
		mapsHeight = MAPS_HEIGHT;
		mapsWidth = MAPS_WIDTH;
		
		this.gameMode = gameMode;
		
		maps = new GameObject[mapsAmount][mapsHeight][mapsWidth];
		
		setFixedContent();
		
		for (int i = 0; i < mapsAmount; i++) {			
			if (i < mapsAmount-1)
				setStair(i);
			else
				setItemQuest(i);
			
			setAllies(i);
			setMonsters(i);
			
			if (randomlyChoice())
				setTrap(i);
			
			setHiddenDoor(i);
		}
		
	}
	
	private void setFixedContent() {
		/* Carrega as paredes internas e possiveis posiçoes de portas do mapa */
		try {
			FileInputStream fileInputStream = new FileInputStream(path+fileName);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);		//no windows usar notepad++ e salvar com encode "utf-8" (variantes geram lixo na saida)
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);		
			
			createFixedContent(bufferedReader);
			
			bufferedReader.close();
		
		} catch (FileNotFoundException error) {
			System.out.println("Arquivo base das paredes do mapa nao encontrado!");
			
		} catch (IOException | NumberFormatException error) {
			System.out.println("O arquivo base das paredes do mapa nao pode ser carregado!");
		}	
	}
	
	protected void createFixedContent(BufferedReader bufferedReader) throws IOException {
		/* Percorre os mapas carregados transformando em matriz de objetos */
		String line = bufferedReader.readLine();
		char aux;
		
		Random randomize = new Random();
		char choosenSetOfDoors = (char) (48 + randomize.nextInt(3) + 1);		//escolhe qual dentre os 3 sets de porta vai ser usado
		
		maps = new GameObject[mapsAmount][mapsHeight][mapsWidth];
		int y = 0;
		
		while(line != null && !line.isEmpty() && y < mapsHeight) {		//enquanto a linha nao for vazia
			
			for (int z = 0; z < mapsWidth; z++)
				
				if ((aux = line.charAt(z)) != ' ')
					
					for(int x = 0; x < mapsAmount; x++)
						maps[x][y][z] = createFixedObject(aux, choosenSetOfDoors, new Coordinate(y,z));		//le cada caractere da linha

			line = bufferedReader.readLine();		//avança para proxima linha
			y++;
		}
	}
	
	private GameObject createFixedObject(char type, char doorsSet, Coordinate position) {
		/* Dado o caractere correspondente ao objeto, cria e retorna o 
		 * objeto criado */
		if (type == doorsSet)
			return new Door(position);
		if (type == '#' || type == '1' || type == '2' || type == '3')		//ver como eh o espaco vazio para ignorar
			return new Wall(position);
		
		return null;
	}
	
	private void setStair(int i) {
		/* Define a escada do mapa(ate o penultimo andar) como sendo o centro do mapa atual */
		int j = (int) MAPS_HEIGHT/2;
		int k = (int) MAPS_WIDTH/2;
		
		maps[i][j][k] = createObject('S', new Coordinate(j,k));
	}
	
	private void setItemQuest(int i) {		//ver a fundo
		/* No ultimo andar, ao invés da escada no centro do mapa, é colocado o item de quest
		 * (bau com recompensas ou item a ser coletado) */
		int j = (int) MAPS_HEIGHT/2;
		int k = (int) MAPS_WIDTH/2;
		
		maps[i][j][k] = createObject('C', new Coordinate(j,k));
	}
	
	private void setAllies(int i) {
		/* Define lugar de inicio dos players sempre no centro do mapa
		 * em volta da escada se existir */
		int j = (int) MAPS_HEIGHT/2;
		int k = (int) MAPS_WIDTH/2;
		
		maps[i][j+1][k] = createObject('E', new Coordinate(j+1,k));
		maps[i][j][k+1] = createObject('D', new Coordinate(j,k+1));
		maps[i][j-1][k] = createObject('B', new Coordinate(j-1,k));
		maps[i][j][k-1] = createObject('W', new Coordinate(j,k-1));
	}
	
	private Coordinate getEmptyPosition(int i) {
		/* Retorna um tipo coordenada com uma posicao vazia do mapa escolhida aleatoriamente */
		Random randomize = new Random();
		int x,y;
		
		do {
			x = randomize.nextInt(mapsHeight-1);
			y = randomize.nextInt(mapsWidth-1);
		
		} while(maps[i][x][y] != null);
		
		return new Coordinate(x,y);
	}
	
	private void setMonsters(int i) {		//o tipo de monstro gerado deve ser especificado aqui
		/* Chama a inicializacao dos monstros do mapa na posicao escolhida aleatoriamente */
		Coordinate pos;
		Random randomize = new Random();
		
		int monstersAmount = randomize.nextInt(3)+3;
		
		for(int b = 0; b < monstersAmount; b++) {
			pos = getEmptyPosition(i);
			
			if(randomlyChoice())		//escolhe esqueleto como monstro
				if(randomlyChoice())
					maps[i][pos.getX()][pos.getY()] = createObject('M',pos);		//mage skeleton
				else
					maps[i][pos.getX()][pos.getY()] = createObject('K',pos);		//skeleton
				
			else
				maps[i][pos.getX()][pos.getY()] = createObject('G',pos);
		}
	}
	
	private void setTrap(int i) {
		/* Caso existam, chama a inicializacao de armadilhas em posicoes aleatorias */
		Coordinate pos;
		Random randomize = new Random();
		
		int trapsAmount = randomize.nextInt(4);
		
		for(int b = 0; b < trapsAmount; b++) {
			pos = getEmptyPosition(i);
			
			maps[i][pos.getX()][pos.getY()] = createObject('T',pos);
		}
	}
	
	private Boolean wallIsFree(int x, int y, int z) {
		/* Checa se a posicao dada pertence a uma parede e, retorna true se a parede estiver livre 
		 * em dois de seus lados para posicionar uma porta */
		if (maps[x][y][z] != null && maps[x][y][z].getId() ==  GameTypeObjects.WALL && ((maps[x][y][z+1] == null && maps[x][y][z-1] == null) || (maps[x][y+1][z] == null && maps[x][y-1][z] == null)))
			return true;
		return false;
	}
	
	private Coordinate getWallPosition(int x) {
		/* Retorna a posicao de uma parede com dois de seus lados livres para posicionar uma porta */
		Random randomize = new Random();
		int y,z;
		
		do {
			y = randomize.nextInt(mapsHeight-2)+1;
			z = randomize.nextInt(mapsWidth-2)+1;
		
		} while(wallIsFree(x,y,z));
		
		return new Coordinate(y,z);
	}
	
	private void setHiddenDoor(int i) {
		/* Aleatoriamente chama a inicializacao de portas ocultas segundo a dificuldade de jogo
		 * escolhida */
		Coordinate pos;
		Random randomize = new Random();
		int hiddenDoorsAmount = 0;
		
		if (gameMode == GameMode.STANDART)
			hiddenDoorsAmount = randomize.nextInt(HIDDEN_DOORS_MAX_AMOUNT_STANDART_MODE)+1;
		else if (gameMode == GameMode.HARD)
			hiddenDoorsAmount = randomize.nextInt(HIDDEN_DOORS_MAX_AMOUNT_HARD_MODE)+1;
		
		for(int b = 0; b < hiddenDoorsAmount; b++) {
			pos = getWallPosition(i);
			
			maps[i][pos.getX()][pos.getY()] = createObject('H',pos);
		}
	}
	
}
