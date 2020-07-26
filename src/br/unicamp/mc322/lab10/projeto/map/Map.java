//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map;

import br.unicamp.mc322.lab10.projeto.GameMode;
import br.unicamp.mc322.lab10.projeto.PlayableClasses;
import br.unicamp.mc322.lab10.projeto.exceptions.FullInventoryException;
import br.unicamp.mc322.lab10.projeto.map.constructor.EquipmentLoad;
import br.unicamp.mc322.lab10.projeto.map.constructor.MonstersLoad;
import br.unicamp.mc322.lab10.projeto.map.objects.GameObject;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Character;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.CpuHero;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.HeroController;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.Player;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.classes.Barbarian;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.classes.Dwarf;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.classes.Elf;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.classes.Wizard;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.CpuHeroHunter;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.CpuMonster;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.Monster;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.classes.Goblin;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.classes.MageSkeleton;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.classes.Skeleton;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.equipment.StartEquipment;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.forniture.types.Chest;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.forniture.types.Trap;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.structure.types.Door;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.structure.types.HiddenDoor;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.structure.types.Stair;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.structure.types.Wall;
import com.sun.jdi.InvalidTypeException;

import java.util.Arrays;
import java.util.Random;

public class Map {

	private int currentMap;
	protected int mapsWidth;
	protected int mapsHeight;
	protected int mapsAmount;
	protected Coordinate[] coordinateArray;
	protected GameObject[][][] maps;
	protected GameMode gameMode;
	protected HeroController[] heroes;
	protected CpuMonster[][] monsters;
	protected EquipmentLoad findableEquipment;
	protected boolean loaded = true;
	private MonstersLoad monsterEquipment;

	private static final int TRAP_DAMAGE_STANDARD_MODE = 1;
	private static final int TRAP_DAMAGE_HARD_MODE = 2;

	public Map() {
		heroes = new HeroController[4];
		currentMap = 0;
		monsterEquipment = new MonstersLoad();
	}

	public boolean previousMap() {
		if (currentMap == 0) {
			return false;
		}

		--currentMap;
		resetHeroesPosition();
		return true;
	}

	public boolean nextMap() {
		if (currentMap + 1 >= maps.length) {
			return false;
		}

		++currentMap;
		resetHeroesPosition();
		return true;
	}

	public boolean isSuccessfullyLoaded() {
		return loaded;
	}

	public boolean allMonstersDefeated() {
		/* Retorna true em caso de fim de jogo por derrotar todos os monstros */
		for (int i = 0; i < mapsAmount; i++) {
			if (monsters != null && monsters[i] != null && monsters[i].length > 0) {
				return false;
			}
		}

		return true;
	}

	public boolean isEmptyPosition(Coordinate position, Character character) {
		/* Checa se personagem pode se mover para a posicao dada.
		 * Monstros nao se movem para cima de armadilhas */
		return isValid(position) && (getPosition(position) == null || (getPosition(position).getId() == GameTypeObjects.TRAP && character instanceof Hero));
	}

	public boolean isVisible(Coordinate pos1, Coordinate pos2) {
		/* Verifica se nao existe nenhum obstaculo entre um ponto e outro, retorna true se nao existir */
		int x1 = pos1.getX();
		int x2 = pos2.getX();
		int y1 = pos1.getY();
		int y2 = pos2.getY();

		if (x1 == x2) {
			int z = y1 - y2;

			if (z > 0) {
				for (int i = 1; i <= z; i++) {
					if (maps[currentMap][x1][y2 + i] != null) {
						return false;
					}
				}
				return true;
			} else if (z < 0) {
				z *= -1;
				for (int i = 1; i <= z; i++) {
					if (maps[currentMap][x1][y1 + i] != null) {
						return false;
					}
				}
				return true;
			}

		} else if (y1 == y2) {
			int z = x1 - x2;

			if (z > 0) {
				for (int i = 1; i <= z; i++) {
					if (maps[currentMap][x2 + i][y1] != null) {
						return false;
					}
				}
				return true;
			} else if (z < 0) {
				z *= -1;
				for (int i = 1; i <= z; i++) {
					if (maps[currentMap][x1 + i][y1] != null) {
						return false;
					}
				}
				return true;
			}
		}

		return false;
	}

	public boolean isTeleportablePosition(Coordinate position, Character character) {
		return isEmptyPosition(position, character) && isVisible(position, character.getPosition());
	}

	public HeroController[] getHeroes() {
		return heroes;
	}

	public CpuMonster[] getMonsters() {
		/* Retorna monstros do mapa atual */
		if (monsters != null)
			return monsters[currentMap];

		return null;
	}

	private Character checkHeroOnPosition(int x, int y) {
		Coordinate attackFrom = new Coordinate(x, y);

		if (isValid(attackFrom) && maps[currentMap][x][y] instanceof Hero) {
			return (Character) maps[currentMap][x][y];
		}
		return null;
	}

	private Character checkMonsterOnPosition(int x, int y) {
		Coordinate attackFrom = new Coordinate(x, y);

		if (isValid(attackFrom) && maps[currentMap][x][y] instanceof Monster) {
			return (Character) maps[currentMap][x][y];
		}
		return null;
	}

	private Controller getController(Character target) {
		/* Caca e retorna o controlador do personagem */
		if (target instanceof Hero) {
			for (HeroController hero : heroes) {
				if (hero.getCharacter() == target) {
					return hero;
				}
			}
		} else {
			for (CpuMonster monster : monsters[currentMap]) {
				if (monster.getCharacter() == target) {
					return monster;
				}
			}
		}
		return null;
	}

	private Controller findTarget(Coordinate position, int distance, boolean isMonsterHunting) {
		/* Busca nos arredores da posicao dada se tem oponente pra atacar */
		int x = position.getX();
		int y = position.getY();
		Character target;

		for (int i = -distance; i <= distance; i++) {
			for (int j = distance; j >= -distance; j--) {
				if (!(i == 0 && j == 0)) {
					if (isMonsterHunting) {
						target = checkHeroOnPosition(x + i, y + j);
					} else {
						target = checkMonsterOnPosition(x + i, y + j);
					}

					if (target != null) {
						return getController(target);
					}
				}
			}
		}

		return null;
	}


	public void callAttack(Controller person) {
		/* Chama verificacao de oponente na area de ataque do atacante, caso exista,
		 * chama funcao de ataque do atacante para com o oponente */
		Character hunter = person.getCharacter();
		Coordinate hunterPosition = hunter.getPosition();
		int weaponReach = hunter.getWeaponsReach();
		Controller target = null;
		boolean isMonsterHunting = true;        //monstro ataca heroi

		if (hunter instanceof Hero)
			isMonsterHunting = false;        //heroi ataca monstro

		for (int i = 1; i <= weaponReach; i++) {        //no raio de ataque da arma, da prioridade a que estiver mais proximo
			target = findTarget(hunterPosition, i, isMonsterHunting);

			if (target != null) {
				System.out.println(hunter.getName() + " ataca " + target.getCharacter().getName());
				person.attack(target);

				if (target.getCharacter().isDead()) {
					remove(target);
				}
				break;
			}
		}
	}

	public void remove(Controller target) {
		/* Remove um heroi ou monstro do mapa e vetor de herois/monstros */
		if (target.getCharacter() instanceof Monster) {
			for (int i = 0; i < monsters[currentMap].length; i++) {
				if (monsters[currentMap][i] == target) {
					monsters[currentMap][i] = monsters[currentMap][monsters[currentMap].length - 1];
					monsters[currentMap] = Arrays.copyOf(monsters[currentMap], monsters[currentMap].length - 1);        //diminui vetor de monstros
				}
			}
		} else if (target.getCharacter() instanceof Hero) {
			for (int i = 0; i < heroes.length; i++) {
				if (heroes[i] == target) {
					heroes[i] = heroes[heroes.length - 1];
					heroes[heroes.length - 1] = null;
				}
			}
		}

		Coordinate position = target.getCharacter().getPosition();
		maps[currentMap][position.getX()][position.getY()] = null;
	}

	public void setPosition(GameObject item, Coordinate position) {
		/* Dado um objeto e uma nova posicao para ele(ja verificada),
		 * move esse objeto para a nova posicao */
		Coordinate oldPosition = item.getPosition();
		int w = oldPosition.getX();
		int z = oldPosition.getY();
		int x = position.getX();
		int y = position.getY();

		if (maps[currentMap][x][y] != null) {
			trap((Hero) item, position);
		}

		maps[currentMap][x][y] = maps[currentMap][w][z];
		maps[currentMap][w][z] = null;

		if (maps[currentMap][x][y] != null) {
			maps[currentMap][x][y].setPosition(position);
		}
	}

	private boolean isFindableItem(Coordinate position) {
		/* Testa se item na posicao dada eh um item que pode ser encontrado(como armadilha ou porta secreta) */
		GameObject item = getPosition(position);

		return (item instanceof Trap || item instanceof HiddenDoor);
	}

	private GameObject[] getFindable(Coordinate center) {
		/* Se pos do player for igual a de algum objeto CanCarry no chao, pega ele pra por no inventario */
		GameObject[] surroundings = new GameObject[4];
		Coordinate side = new Coordinate(center.getX(), center.getY());

		side.setX(center.getX() + 1);

		if (isValid(side) && isFindableItem(side)) {        //em baixo
			surroundings[0] = getPosition(side);
		}

		side.setX(center.getX() - 1);

		if (isValid(side) && isFindableItem(side)) {
			surroundings[1] = getPosition(side);
		}

		side.setX(center.getX());
		side.setY(center.getY() + 1);

		if (isValid(side) && isFindableItem(side)) {
			surroundings[2] = getPosition(side);
		}

		side.setY(center.getY() - 1);

		if (isValid(side) && isFindableItem(side)) {
			surroundings[3] = getPosition(side);
		}

		return surroundings;
	}

	public void search(Character hero) {
		/* busca hidden door ou trap nos arredores, caso nao tenha nenhum dos dois tem
		 * uma pequena chance de encontrar um item e uma grande chance de encontrar um monstro */
		Coordinate heroPos = hero.getPosition();
		GameObject[] surroundings = getFindable(heroPos);
		boolean findSomething = false;

		for (GameObject surrounding : surroundings) {
			if (surrounding != null) {
				if (surrounding instanceof Trap) {        //procura por armadilha
					Trap trap = (Trap) surrounding;

					trap.disarmTrap();
					remove(trap.getPosition());

					findSomething = true;
				} else if (surrounding instanceof HiddenDoor) {        //procura por porta oculta
					HiddenDoor hiddenDoor = (HiddenDoor) surrounding;

					hiddenDoor.discoverDoor();

					findSomething = true;
				}
			}
		}

		if (!findSomething) {        //encontra item, monstro ou nada
			if (randomChoice()) {        //encontra monstro
				System.out.println("Voce escuta passos!");
				setMonsters(currentMap);

			} else if (randomChoice()) {        //encontra algo
				if (randomChoice()) {        //encontra dinheiro
					System.out.println("Voce pisa em alguma coisa!");
					hero.addRandomMoney();
				} else {        //encontra item
					CanCarry item = findableEquipment.getRandomLoot();
					System.out.println("Olhando atentamente voce encontra " + item.getName() + " jogado em um canto da sala!");
					hero.addToInventory(item);
				}

			} else {        //nao encontra nada
				System.out.println("Parece que nao ha nada por aqui!");

			}
		}
	}

	protected Coordinate getEmptyPosition(int i) {
		/* Retorna um tipo coordenada com uma posicao vazia do mapa escolhida aleatoriamente */
		Random randomize = new Random();
		int x;
		int y;

		do {
			x = randomize.nextInt(mapsHeight - 1);
			y = randomize.nextInt(mapsWidth - 1);

		} while (maps[i][x][y] != null);

		return new Coordinate(x, y);
	}

	protected void setMonsters(int i) {
		/* Chama a inicializacao dos monstros do mapa na posicao escolhida aleatoriamente */
		try {
			Coordinate pos;
			Random randomize = new Random();

			int monstersAmount = randomize.nextInt(3) + 3;

			for (int b = 0; b < monstersAmount; b++) {
				pos = getEmptyPosition(i);
				if (randomChoice()) {        //escolhe esqueleto como monstro
					if (randomChoice()) {
						maps[i][pos.getX()][pos.getY()] = createObject('M', pos, i);        //mage skeleton
					} else {
						maps[i][pos.getX()][pos.getY()] = createObject('K', pos, i);        //skeleton
					}

				} else {
					maps[i][pos.getX()][pos.getY()] = createObject('G', pos, i);
				}
			}
		} catch (InvalidTypeException e) {
			System.err.println(e.getMessage());
		}
	}

	private boolean isUsableItem(Coordinate position) {
		/* Testa se item na posicao dada eh um item que pode ser usado(bau, escada ou porta) */
		GameObject item = getPosition(position);

		return (item instanceof Door || item instanceof Chest || item instanceof Stair);
	}

	private GameObject[] getUsable(Coordinate center) {
		/* Devolve os itens ao redor da posicao dada na mapa */
		GameObject[] surroundings = new GameObject[4];
		Coordinate side = new Coordinate(center.getX(), center.getY());

		side.setX(center.getX() + 1);

		if (isValid(side) && isUsableItem(side)) {
			surroundings[0] = getPosition(side);
		}

		side.setX(center.getX() - 1);

		if (isValid(side) && isUsableItem(side)) {
			surroundings[1] = getPosition(side);
		}

		side.setX(center.getX());
		side.setY(center.getY() + 1);

		if (isValid(side) && isUsableItem(side)) {
			surroundings[2] = getPosition(side);
		}

		side.setY(center.getY() - 1);

		if (isValid(side) && isUsableItem(side)) {
			surroundings[3] = getPosition(side);
		}

		return surroundings;
	}

	private void remove(Coordinate position) {
		/* Dada uma coordenada valida do mapa, remove o item dela */
		maps[currentMap][position.getX()][position.getY()] = null;
	}

	private boolean stillHaveMonstersOnThisFloor() {
		/* Checa se ainda existem monstros no andar atual */
		if (monsters[currentMap] != null) {
			for (int i = 0; i < monsters[currentMap].length; i++) {
				if (monsters[currentMap][i] != null) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean use(Character hero) {
		/* Usado para abrir baus, portas ou subir escadas(so pode subir apos derrotar todos os monstros do andar)
		 * ao redor do player, caso nao haja nenhum destes, pergunta se quer usar health potion(se houver no inventario) */
		try {
			Coordinate heroPos = hero.getPosition();
			GameObject[] surroundings = getUsable(heroPos);

			for (GameObject surrounding : surroundings) {
				if (surrounding != null) {
					if (surrounding instanceof Chest) {
						Chest chest = (Chest) surrounding;
						CanCarry loot = chest.getItems();

						System.out.println(loot.getName() + " adquirido!");
						hero.addToInventory(loot);
						remove(chest.getPosition());

						return true;
					} else if (surrounding instanceof Door) {
						Door door = (Door) surrounding;

						remove(door.getPosition());

						return true;
					} else if (surrounding instanceof Stair) {
						if (stillHaveMonstersOnThisFloor()) {
							System.out.println("Parece que ainda tem monstros nesse andar!");
							return true;
						}

						return false;        //sinal para trocar de mapa
					}
				}
			}

			hero.askPotion();
			return true;
		} catch (FullInventoryException e) {
			System.err.println(e.getMessage());
			return false;
		}

	}
	
	private void discoverMap() {
		heroes[0].getCharacter().showSprite();
		Coordinate player = heroes[0].getCharacter().getPosition();
		int playerX = player.getX();
		int playerY = player.getY();
		
		for (int x = playerX+1; x < mapsHeight; x++) {		//baixo
			if (maps[currentMap][x][playerY] != null && maps[currentMap][x][playerY].getId() != GameTypeObjects.TRAP) {
				maps[currentMap][x][playerY].showSprite();
				break;
			}
		}
		
		for (int x = playerX-1; x >= 0; x--) {		//cima
			if (maps[currentMap][x][playerY] != null && maps[currentMap][x][playerY].getId() != GameTypeObjects.TRAP) {
				maps[currentMap][x][playerY].showSprite();
				break;
			}
		}
		
		for (int y = playerY+1; y < mapsWidth; y++) {		//direita
			if (maps[currentMap][playerX][y] != null && maps[currentMap][playerX][y].getId() != GameTypeObjects.TRAP) {
				maps[currentMap][playerX][y].showSprite();
				break;
			}
		}
		
		for (int y = playerY-1; y >= 0; y--) {		//esquerda
			if (maps[currentMap][playerX][y] != null && maps[currentMap][playerX][y].getId() != GameTypeObjects.TRAP) {
				maps[currentMap][playerX][y].showSprite();
				break;
			}
		}
	}

	public void printScene() {
		/* Chama refreshMap e mostra map recebido na tela */
		discoverMap();
		
		for (int j = 0; j < mapsHeight; j++) {
			for (int k = 0; k < mapsWidth; k++) {
				if (maps[currentMap][j][k] == null) {
					System.out.print(" ");
				} else {
					maps[currentMap][j][k].print();
				}
			}

			System.out.print("\n");
		}

		System.out.print("\n");
	}

	protected boolean randomChoice() {
		/* Aleatoriamente retorna true ou false */
		Random randomize = new Random();
		return randomize.nextBoolean();
	}

	protected Monster increaseMonster(Monster monster, int mapNumber) {
		/* Aloca espaco no vetor de monstros, cria e insere um monstro em seu controlador no vetor */
		if (monsters[mapNumber] == null) {
			monsters[mapNumber] = new CpuMonster[1];
		} else {
			monsters[mapNumber] = Arrays.copyOf(monsters[mapNumber], monsters[mapNumber].length + 1);
		}

		if (monster.getId() == GameTypeObjects.GOBLIN) {
			monsters[mapNumber][monsters[mapNumber].length - 1] = new CpuHeroHunter(monster);
		} else {
			monsters[mapNumber][monsters[mapNumber].length - 1] = new CpuMonster(monster);
		}

		return monster;
	}

	protected GameObject createObject(char type, Coordinate position, int mapNumber) throws InvalidTypeException {
		/* Dado o caractere correspondente ao objeto, cria e retorna o
		 * objeto criado */
		switch (type) {
			case '#':
				return new Wall(position);
			case 'U':
				return new Door(position);
			case 'H':
				return new HiddenDoor(position);
			case 'S':
				return new Stair(position);
			case 'C':
				return createChest(position);
			case 'M':
				return increaseMonster(new MageSkeleton(position, monsterEquipment.getMageSkeletonEquipment()), mapNumber);
			case 'G':
				return increaseMonster(new Goblin(position, monsterEquipment.getGoblinEquipment()), mapNumber);
			case 'K':
				return increaseMonster(new Skeleton(position, monsterEquipment.getSkeletonEquipment()), mapNumber);
			case 'T':
				if (gameMode == GameMode.STANDARD) {
					return new Trap(TRAP_DAMAGE_STANDARD_MODE, position);
				} else if (gameMode == GameMode.HARD) {
					return new Trap(TRAP_DAMAGE_HARD_MODE, position);
				}

				break;
			case ' ':
				return null;
			default:
				throw new InvalidTypeException("Objeto do tipo " + type + " nao pode ser criado!");
		}

		return null;
	}

	protected void resizeCoordinateArray() {
		if (coordinateArray == null) {
			coordinateArray = new Coordinate[1];
		} else {
			coordinateArray = Arrays.copyOf(coordinateArray, coordinateArray.length + 1);
		}
	}

	protected void storeCoordinate(int y, int z, GameTypeObjects type) {        //ver
		resizeCoordinateArray();
		coordinateArray[coordinateArray.length - 1] = new Coordinate(y, z);
	}

	protected void setHeroes(PlayableClasses chosenClass, String playerName) {
		/* Define lugar de inicio dos players sempre no centro do mapa
		 * em volta da escada se existir */
		int j = mapsHeight / 2;
		int k = mapsWidth / 2;

		StartEquipment startEquipment = new StartEquipment();

		Barbarian barbarian = new Barbarian(startEquipment.getBarbarian());
		Dwarf dwarf = new Dwarf(startEquipment.getDwarf());
		Elf elf = new Elf(startEquipment.getElf(), startEquipment.getElfSpells());
		Wizard wizard = new Wizard(startEquipment.getWizard(), startEquipment.getWizardSpells());

		barbarian.setPosition(new Coordinate(j + 1, k));
		dwarf.setPosition(new Coordinate(j - 1, k));
		elf.setPosition(new Coordinate(j, k + 1));
		wizard.setPosition(new Coordinate(j, k - 1));

		if (chosenClass == PlayableClasses.BARBARIAN) {
			heroes[0] = new Player(barbarian, playerName);
			heroes[1] = new CpuHero(elf);
			heroes[2] = new CpuHero(dwarf);
			heroes[3] = new CpuHero(wizard);
		} else if (chosenClass == PlayableClasses.DWARF) {
			heroes[0] = new Player(dwarf, playerName);
			heroes[1] = new CpuHero(elf);
			heroes[2] = new CpuHero(barbarian);
			heroes[3] = new CpuHero(wizard);
		} else if (chosenClass == PlayableClasses.ELF) {
			heroes[0] = new Player(elf, playerName);
			heroes[1] = new CpuHero(barbarian);
			heroes[2] = new CpuHero(dwarf);
			heroes[3] = new CpuHero(wizard);
		} else if (chosenClass == PlayableClasses.WIZARD) {
			heroes[0] = new Player(wizard, playerName);
			heroes[1] = new CpuHero(elf);
			heroes[2] = new CpuHero(dwarf);
			heroes[3] = new CpuHero(barbarian);
		} else {
			throw new NullPointerException("Classe de personagem invalida!");
		}

		maps[0][j + 1][k] = barbarian;
		maps[0][j][k + 1] = elf;
		maps[0][j - 1][k] = dwarf;
		maps[0][j][k - 1] = wizard;
	}

	private boolean isValid(Coordinate position) {
		/* Testa se uma coordenada dada esta dentro dos limites do mapa */
		int x = position.getX();
		int y = position.getY();

		return x > 0 && y > 0 && x < mapsHeight && y < mapsWidth;
	}

	private GameObject getPosition(Coordinate position) {
		int x = position.getX();
		int y = position.getY();

		return maps[currentMap][x][y];
	}

	private Chest createChest(Coordinate position) {
		Chest chest = new Chest(position);
		chest.setContent(findableEquipment.getRandomLoot());

		return chest;
	}

	private void hideMap() {		//ver se eh necessario
		/* Oculta todas as sprites do mapa */
		for (int y = 0; y < mapsHeight; y++) {
			for (int z = 0; z < mapsWidth; z++) {
				if (maps[currentMap][y][z] != null) {
					maps[currentMap][y][z].hideSprite();
				}
			}
		}
	}
	
	private void resetHeroesPosition() {
		/* Ao subir ou decer um andar, move os player para o entorno da escada no centro da sala*/
		int j = mapsHeight / 2;
		int k = mapsWidth / 2;

		if (heroes[0] != null) {
			maps[currentMap][j + 1][k] = heroes[0].getCharacter();
			maps[currentMap][j + 1][k].setPosition(new Coordinate(j + 1, k));
		}

		if (heroes[1] != null) {
			maps[currentMap][j][k + 1] = heroes[1].getCharacter();
			maps[currentMap][j][k + 1].setPosition(new Coordinate(j, k + 1));
		}

		if (heroes[2] != null) {
			maps[currentMap][j - 1][k] = heroes[2].getCharacter();
			maps[currentMap][j - 1][k].setPosition(new Coordinate(j - 1, k));
		}

		if (heroes[3] != null) {
			maps[currentMap][j][k - 1] = heroes[3].getCharacter();
			maps[currentMap][j][k - 1].setPosition(new Coordinate(j, k - 1));
		}
		
		//hideMap();
	}

	private void trap(Hero hero, Coordinate position) {
		/* Verifica se a posicao que o heroi vai se mover tem uma armadilha,
		 * se houver, ativa ela */
		int x = position.getX();
		int y = position.getY();

		if (maps[currentMap][x][y].getId() == GameTypeObjects.TRAP) {
			Trap trap = (Trap) maps[currentMap][x][y];
			trap.doDamage(hero);
		}
	}

	private Controller[] increaseController(Controller[] controller) {
		/* Dado um tipo Controller, inicializa o vetor com 1 posicao ou aumenta
		 * o vetor em 1 posicao */
		if (controller == null) {
			controller = new Controller[1];
		} else {
			controller = Arrays.copyOf(controller, controller.length + 1);
		}

		return controller;
	}

	private Controller[] addControllers(Controller[] c1, Controller[] c2) {
		if (c1 == null) {
			return Arrays.copyOf(c2, c2.length);
		} else if (c2 != null) {
			for (int i = 0; i < c2.length; i++) {
				c1 = increaseController(c1);
				c1[c1.length - 1] = c2[i];
			}
		}

		return c1;
	}

	public Controller[] getAdjacentTargetsInDelimitedArea(Coordinate position, int distance, boolean isMonsterHunting) {
		/* Delimita a area de ataque e retorna todos os alvos encontrados
		 * nessa area */
		Controller[] allTargets = null;
		Controller[] targets;
		for (int i = 1; i <= distance; i++) {
			targets = findAreaTargets(position, i, isMonsterHunting);

			if (targets != null)
				allTargets = addControllers(allTargets, targets);
		}

		return allTargets;
	}

	private Controller[] findAreaTargets(Coordinate position, int distance, boolean isMonsterHunting) {
		/* Busca nos arredores da posicao dada se tem oponentes pra atacar, se hover, devolve vetor
		 * com todos os oponentes no raio */
		int x = position.getX();
		int y = position.getY();
		Character target;
		Controller[] targets = null;

		for (int i = -distance; i <= distance; i++) {
			for (int j = distance; j >= -distance; j--) {
				if (!(i == 0 && j == 0)) {
					if (isMonsterHunting) {
						target = checkHeroOnPosition(x + i, y + j);
					} else {
						target = checkMonsterOnPosition(x + i, y + j);
					}

					if (target != null) {
						targets = increaseController(targets);
						targets[targets.length - 1] = getController(target);
					}
				}
			}
		}
		if (targets == null) {
			System.out.println("Nenhum alvo encontrado! (Sua area de ataque eh " + distance + " casas ao redor do alvo).");
		} else {
			System.out.println(targets.length + " alvos adjacentes encontrados!");
		}
		return targets;
	}

	public Controller findSpellTarget(Coordinate position, int distance, boolean isMonsterHunting) {
		/* Dado o raio de alcance do Caster, em torno dele, da regiao mais proxima a regiao mais logiqua
		 * onde consegue atacar, chama a busca por um alvo e retorna o primeiro encontrado (mais proximo
		 * a ele) */
		Controller target;

		for (int i = 1; i <= distance; i++) {
			target = findTarget(position, i, isMonsterHunting);

			if (target != null)
				return target;
		}

		return null;
	}
}
