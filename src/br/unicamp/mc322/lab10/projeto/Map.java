//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

import java.util.Arrays;
import java.util.Random;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.CpuHero;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.HeroController;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Player;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.Barbarian;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.Dwarf;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.Elf;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.classes.Wizard;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.CpuHeroHunter;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.CpuMonster;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.Monster;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.classes.Goblin;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.classes.MageSkeleton;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.classes.Skeleton;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.StartEquipment;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.forniture.fornitureTypes.Chest;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.forniture.fornitureTypes.Trap;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes.Door;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes.HiddenDoor;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes.Stair;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes.Wall;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Character;

public class Map {
	private int currentMap;
	protected int mapsWidth;
	protected int mapsHeight;
	protected int mapsAmount;
	protected Coordinate[] coordinateArray;
	protected GameObject[][][] maps;
	protected GameMode gameMode;
	private static final int TRAP_DAMAGE_STANDART_MODE = 1;
	private static final int TRAP_DAMAGE_HARD_MODE = 2;
	protected HeroController[] heroes;
	protected CpuMonster[][] monsters;
	private Chest[] chests;
	
	public Map() {
		heroes = new HeroController[4];
		currentMap = 0;
	}
	
	public boolean previousMap(){
		if (currentMap == 0)
			return false;
		
		--currentMap;
		resetHeroesPosition();
		return true;
	}
	
	public boolean nextMap(){
		if (currentMap+1 >= maps.length)
			return false;
		
		++currentMap;
		resetHeroesPosition();
		return true;
	}
	
	public boolean allMonstersDefeated() {
		/* Retorna true em caso de fim de jogo por derrotar todos os monstros */
		for (int i = 0; i < mapsAmount; i++)
			if (monsters[i] != null)
				return false;
		
		return true;
	}
	
	public boolean isEmptyPosition(Coordinate position, GameTypeObjects type) {
		/* Checa se personagem pode se mover para a posicao dada.
		 * Monstros nao se movem para cima de armadilhas */
		if(isValid(position) && (getPosition(position) == null || (getPosition(position).getId() == GameTypeObjects.TRAP && type == GameTypeObjects.HERO)))
			return true;
		return false;
	}
	
	public HeroController[] getHeroes() {
		return heroes;
	}
	
	public CpuMonster[] getMonsters() {
		/* Retorna monstros do mapa atual */
		return monsters[currentMap];
	}
	
	public Character findTarget(Coordinate position) {		//vazia
		/* Busca nos arredores da posicao dada se tem oponente pra atacar */
		return null;
	}
	
	public Chest[] getChests() {
		return chests;
	}
	
	public void setPosition(GameObject item, Coordinate position) {
		/* Dado um objeto e uma nova posicao para ele(ja verificada),
		 * move esse objeto para a nova posicao */
		Coordinate oldPosition = item.getPosition();
		int w = oldPosition.getX();
		int z = oldPosition.getY();
		int x = position.getX();
		int y = position.getY();
		
		if(maps[currentMap][x][y] != null)
			trap((Hero) item,position);
		
		maps[currentMap][x][y] = maps[currentMap][w][z];
		maps[currentMap][w][z] = null;
		maps[currentMap][x][y].setPosition(position);
	}
		
	public void climbStair(Stair stair) {		//vazia
		
	}
	
	public void openChest() {		//vazia
		
	}
	
	public void searchTrap() {		//vazia
		
	}
	
	public void searchItem() {		//vazia
		/* Se pos do player for igual a de algum objeto CanCarry no chao, pega ele pra por no inventario */	
			
	}
	
	public void printScene() {
		/* Chama refreshMap e mostra map recebido na tela */
		for (int j = 0; j < mapsHeight; j++) {
			for (int k = 0; k < mapsWidth; k++) {
				if (maps[currentMap][j][k] == null)
					System.out.printf(" ");
				else
					maps[currentMap][j][k].print();
			}
			System.out.printf("\n");
		}
		System.out.printf("\n");
	}
	
	protected boolean randomlyChoice() {
		/* Aleatoriamente retorna true ou false */
		Random randomize = new Random();
		return randomize.nextBoolean();
	}
	
	protected Monster increaseMonster(Monster monster, int mapNumber) {
		/* Aloca espaço no vetor de monstros, cria e insere um monstro em seu controlador no vetor */
		if(monsters[mapNumber] == null)
			monsters[mapNumber] = new CpuMonster[1];
		else
			monsters[mapNumber] = Arrays.copyOf(monsters[mapNumber], monsters[mapNumber].length+1);
		
		if(monster.getId() == GameTypeObjects.GOBLIN)
			monsters[mapNumber][monsters[mapNumber].length-1] = new CpuHeroHunter(monster);
		else
			monsters[mapNumber][monsters[mapNumber].length-1] = new CpuMonster(monster);
		
		return monster;
	}
	
	protected GameObject createObject(char type, Coordinate position, int mapNumber) {
		/* Dado o caractere correspondente ao objeto, cria e retorna o 
		 * objeto criado */
		if (type == '#')
			return new Wall(position);
		if (type == 'U')
			return new Door(position);
		if (type == 'H')
			return new HiddenDoor(position);
		if (type == 'S')
			return new Stair(position);
		if (type == 'C')
			return createChest(position);
		if (type == 'M')
			return increaseMonster(new MageSkeleton(position), mapNumber);
		if (type == 'G')
			return increaseMonster(new Goblin(position), mapNumber);
		if (type == 'K')
			return increaseMonster(new Skeleton(position), mapNumber);
		if (type == 'T') {
			if (gameMode == GameMode.STANDART)
				return new Trap(TRAP_DAMAGE_STANDART_MODE,position);
			else if (gameMode == GameMode.HARD)
				return new Trap(TRAP_DAMAGE_HARD_MODE,position);
		}
		if (type != ' ')
			System.out.println("Objeto do tipo "+type+" não pode ser criado!");
		
		return null;
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
	
	protected void setHeroes(PlayableClasses choosenClass, String playerName) {
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
	}
	
	private boolean isValid(Coordinate position) {
		/* Testa se uma coordenada dada esta dentro dos limites do mapa */
		int x = position.getX();
		int y = position.getY();
		
		if(x > 0 && y > 0 && x < mapsHeight && y < mapsWidth)
			return true;
		return false;
	}
	
	private GameObject getPosition(Coordinate position) {
		int x = position.getX();
		int y = position.getY();
		
		return maps[currentMap][x][y];
	}
	
	private GameObject createChest(Coordinate position) {
		if(chests == null)
			chests = new Chest[1];
		else
			chests = Arrays.copyOf(chests, chests.length+1);
		
		chests[chests.length-1] = new Chest(position);
		
		return chests[chests.length-1];
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
	
	private void trap(Hero hero, Coordinate position) {
		/* Verifica se a posicao que o heroi vai se mover tem uma armadilha,
		 * se houver, ativa ela */
		int x = position.getX();
		int y = position.getY();
		
		if(maps[currentMap][x][y].getId() == GameTypeObjects.TRAP) {
			Trap trap = (Trap) maps[currentMap][x][y];
			trap.doDamage(hero);
		}
	}
}
