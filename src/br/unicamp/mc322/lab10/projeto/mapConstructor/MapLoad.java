package br.unicamp.mc322.lab10.projeto.mapConstructor;

import java.util.Arrays;
import java.util.Random;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.GameMode;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.enemy.enemyTypes.Goblin;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.enemy.enemyTypes.MageSkeleton;
import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable.enemy.enemyTypes.Skeleton;
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
	
	public MapLoad() {
		currentMap = 0;
	}
	
	public GameObject[][] getMap() {
		return (GameObject[][]) maps[currentMap];
	}
	
	public GameObject[][] previousMap(){
		if (currentMap == 0)
			return null;
		return (GameObject[][]) maps[--currentMap];
	}
	
	public GameObject[][] nextMap(){
		if (currentMap >= maps.length)
			return null;
		return (GameObject[][]) maps[++currentMap];
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
		//DEBUG
		for (int i = 0; i < mapsAmount; i++) {
			for (int j = 0; j < mapsHeight; j++) {
				for (int k = 0; k < mapsWidth; k++) {
					if (maps[i][j][k] == null)
						System.out.printf(" ");
					else
						System.out.printf("%s",maps[i][j][k].toString());
				}
				System.out.printf("\n");
			}
			System.out.printf("\n");
			System.out.printf("\n");
		}
	}
	
}
