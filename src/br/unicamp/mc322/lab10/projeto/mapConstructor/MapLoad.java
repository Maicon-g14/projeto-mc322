package br.unicamp.mc322.lab10.projeto.mapConstructor;

import java.util.Arrays;
import java.util.Random;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.GameMode;
import br.unicamp.mc322.lab10.projeto.PlayableClasses;
import br.unicamp.mc322.lab10.projeto.QuestBase;
import br.unicamp.mc322.lab10.projeto.StartEquipment;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Character;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.CpuHero;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.HeroController;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Player;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.Barbarian;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.Dwarf;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.Elf;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.Wizard;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.Monster;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.classes.Goblin;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.classes.MageSkeleton;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.classes.Skeleton;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.forniture.fornitureTypes.Trap;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes.Door;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes.HiddenDoor;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes.Stair;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes.Wall;

public class MapLoad {

	private int currentMap;
	protected int mapsWidth;
	protected int mapsHeight;
	protected int mapsAmount;
	protected Coordinate[] coordinateArray;
	protected GameObject[][][] maps;
	protected GameMode gameMode;
	private static final int TRAP_DAMAGE_STANDART_MODE = 20;
	private static final int TRAP_DAMAGE_HARD_MODE = 10;
	HeroController[] heroes;
	
	//criar vetor de monstros(pelo controlador), salvar e retornar
	
	public MapLoad() {
		heroes = new HeroController[4];
		currentMap = 0;
	}
	
	public GameObject[][] getMap() {
		return (GameObject[][]) maps[currentMap];
	}
	
	public GameObject[][] previousMap(){
		if (currentMap == 0)
			return getMap();
		
		GameObject[][] map = maps[--currentMap];
		resetHeroesPosition();
		return map;
	}
	
	public GameObject[][] nextMap(){
		if (currentMap+1 >= maps.length)
			return getMap();
		
		GameObject[][] map = maps[++currentMap];
		resetHeroesPosition();
		return map;
	}
	
	protected Boolean randomlyChoice() {
		/* Aleatoriamente retorna true ou false */
		Random randomize = new Random();
		
		return randomize.nextBoolean();
	}
	
	protected void resizeCoordinateArray() {
		if (coordinateArray == null)
			coordinateArray = new Coordinate[1];
		else
			coordinateArray = Arrays.copyOf(coordinateArray, coordinateArray.length+1);
	}
	
	protected void storeCoordinate(int y, int z, GameTypeObjects type) {		//ver
		resizeCoordinateArray();
		coordinateArray[coordinateArray.length-1] = new Coordinate(y,z);
	}
	
	protected GameObject createObject(char type, Coordinate position) {
		/* Dado o caractere correspondente ao objeto, cria e retorna o 
		 * objeto criado */
		
		if (type == '#')
			return new Wall(position);
		if (type == 'U')
			return new Door(position);
		if (type == 'H')
			return new HiddenDoor(position);
		if (type == 'T') {
			if (gameMode == GameMode.STANDART)
				return new Trap(TRAP_DAMAGE_STANDART_MODE,position);
			else if (gameMode == GameMode.HARD)
				return new Trap(TRAP_DAMAGE_HARD_MODE,position);
		}
		if (type == 'S')
			return new Stair(position);
		if (type == 'M')
			return new MageSkeleton(position);
		if (type == 'G')
			return new Goblin(position);
		if (type == 'K')
			return new Skeleton(position);
		if (type != ' ')
			System.out.println("Objeto do tipo "+type+" não pode ser criado!");
		
		return null;
	}
	
	public void mapPrint() {
		//DEBUG - mostra todas as cenas
		for (int i = 0; i < mapsAmount; i++) {
			for (int j = 0; j < mapsHeight; j++) {
				for (int k = 0; k < mapsWidth; k++) {
					if (maps[i][j][k] == null)
						System.out.printf(" ");
					else
						maps[i][j][k].print();
				}
				System.out.printf("\n");
			}
			System.out.printf("\n");
			System.out.printf("\n");
		}
	}
	
	private void resetHeroesPosition() {
		/* Ao subir ou decer um andar, move os player para o entorno da escada no centro da sala*/
		int j = (int) mapsHeight/2;
		int k = (int) mapsWidth/2;
		
		maps[currentMap][j+1][k] = heroes[0].getCharacter();
		maps[currentMap][j+1][k].setPosition(new Coordinate(j+1, k));
		maps[currentMap][j][k+1] = heroes[1].getCharacter();
		maps[currentMap][j][k+1].setPosition(new Coordinate(j+1, k));
		maps[currentMap][j-1][k] = heroes[2].getCharacter();
		maps[currentMap][j-1][k].setPosition(new Coordinate(j+1, k));
		maps[currentMap][j][k-1] = heroes[3].getCharacter();
		maps[currentMap][j][k-1].setPosition(new Coordinate(j+1, k));
	}
	
	public HeroController[] addHeroes(PlayableClasses choosenClass, String playerName) {
		/* Define lugar de inicio dos players sempre no centro do mapa
		 * em volta da escada se existir */
		int j = (int) mapsHeight/2;
		int k = (int) mapsWidth/2;
		
		StartEquipment startEquipment = new StartEquipment();
		
		Barbarian barbarian = new Barbarian(startEquipment.getBarbarian());
		Dwarf dwarf = new Dwarf(startEquipment.getDwarf());
		Elf elf = new Elf(startEquipment.getElf());
		Wizard wizard = new Wizard(startEquipment.getWizard());
		
		barbarian.setPosition(new Coordinate(j+1, k));
		dwarf.setPosition(new Coordinate(j-1, k));
		elf.setPosition(new Coordinate(j, k+1));
		wizard.setPosition(new Coordinate(j, k-1));
		
		if(choosenClass == PlayableClasses.BARBARIAN) {
			heroes[0] = new Player(barbarian,playerName);
			heroes[1] = new CpuHero(elf);
			heroes[2] = new CpuHero(dwarf);
			heroes[3] = new CpuHero(wizard);
		} else if (choosenClass == PlayableClasses.DWARF) {
			heroes[0] = new Player(dwarf,playerName);
			heroes[1] = new CpuHero(elf);
			heroes[2] = new CpuHero(barbarian);
			heroes[3] = new CpuHero(wizard);
		} else if (choosenClass == PlayableClasses.ELF) {
			heroes[0] = new Player(elf,playerName);
			heroes[1] = new CpuHero(barbarian);
			heroes[2] = new CpuHero(dwarf);
			heroes[3] = new CpuHero(wizard);
		} else if (choosenClass == PlayableClasses.WIZARD) {
			heroes[0] = new Player(wizard,playerName);
			heroes[1] = new CpuHero(elf);
			heroes[2] = new CpuHero(dwarf);
			heroes[3] = new CpuHero(barbarian);
		} else
			throw new NullPointerException("Classe de personagem invalida!");
		
		maps[0][j+1][k] = barbarian;
		maps[0][j][k+1] = elf;
		maps[0][j-1][k] = dwarf;
		maps[0][j][k-1] = wizard;
		
		return heroes;
	}
	
	public int getFloorsNumber() {
		return mapsAmount;
	}
	
	public Boolean isValid(Coordinate position) {
		int x = position.getX();
		int y = position.getY();
		
		if(x > 0 && y > 0 && x < mapsHeight && y < mapsWidth)
			return true;
		return false;
	}
	
	public GameObject getPosition(Coordinate position) {
		int x = position.getX();
		int y = position.getY();
		
		return maps[currentMap][x][y];
	}
	
	private void trap(Hero hero, Coordinate position) {
		/* Se tiver armadilha na posicao, ativa ela, senao apenas move
		 * o heroi */
		int x = position.getX();
		int y = position.getY();
		
		if(maps[currentMap][x][y].getId() == GameTypeObjects.TRAP) {
			Trap trap = (Trap) maps[currentMap][x][y];
			trap.doDamage(hero);
		}
	}
	
	public void setPosition(GameObject item, Coordinate position) {
		/* Dado um objeto e uma nova posicao para ele(ja verificada),
		 * move esse objeto para a nova posicao */
		Coordinate oldPosition = item.getPosition();
		int x = position.getX();
		int y = position.getY();
		int w = oldPosition.getX();
		int z = oldPosition.getY();
		
		if(maps[currentMap][x][y] != null)
			trap((Hero) item,position);
		
		maps[currentMap][x][y] = maps[currentMap][w][z];
		maps[currentMap][w][z] = null;
		maps[currentMap][x][y].setPosition(position);
	}
	
	public void setQuest(QuestBase quest) {
		
	}
	
}
