//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types;

import java.util.Random;
import java.util.Scanner;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SelfSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellElements;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellTypes;

public class Teleport extends SelfSpell {

	private static final String NAME = "Teleport";
	private static final SpellElements ELEMENT = SpellElements.AIR;
	private static final SpellTypes TYPE = SpellTypes.SUPPORT;
	private static final GameTypeObjects ID = GameTypeObjects.TELEPORT;
	private static final int PRICE = 80;

	public Teleport() {
		super(NAME, new Sprite(), ID, ELEMENT, TYPE, PRICE);
	}
	
	private int readInteger(Scanner scanner) {
		int amount = 0;
		
		do {
			if (!scanner.hasNextInt())
				scanner.next();
			else
				amount = scanner.nextInt();

		} while (amount < 0);
		
		return amount;
	}
	
	private boolean doTeleport(Map map, Controller caster, int side, int distance) {
		int x = caster.getCharacter().getPosition().getX();
		int y = caster.getCharacter().getPosition().getY();
		Coordinate newPosition = new Coordinate(x,y);
		
		switch(side) {
		case 1:
			newPosition.setY(y + distance);

			if (map.isTeleportablePosition(newPosition, caster.getCharacter())) {
				map.setPosition(caster.getCharacter(), newPosition);
				return true;
			}

			break;
		case 2:
			newPosition.setY(y - distance);

			if (map.isTeleportablePosition(newPosition, caster.getCharacter())) {
				map.setPosition(caster.getCharacter(), newPosition);
				return true;
			}

			break;
		case 3:
			newPosition.setX(x - distance);

			if (map.isTeleportablePosition(newPosition, caster.getCharacter())) {
				map.setPosition(caster.getCharacter(), newPosition);
				return true;
			}

			break;
		case 4:
			newPosition.setX(x + distance);

			if (map.isTeleportablePosition(newPosition, caster.getCharacter())) {
				map.setPosition(caster.getCharacter(), newPosition);
				return true;
			}

			break;
		default:
			break;
		}
		
		return false;
	}

	public boolean use(Map map, Controller target, Scanner scanner) {
		/* Pergunta e teleporta o usuario para uma posicao visivel por ele */
		
		System.out.println("Para qual dos lados deseja se teleportar: (1. Direita, 2. Esquerda, 3. Cima, 4. Baixo)");
		int side = readInteger(scanner);
		
		System.out.print("Quantas casas quer se mover: ");
		int distance = readInteger(scanner);
		
		return doTeleport(map, target, side, distance);
	}

	@Override
	public boolean use(Controller caster) {
		return false;
	}

	@Override
	public boolean use(Map map, Controller caster) {
		/* Teleporte aleatorio de npcs */
		Random randomize = new Random();
		
		int side = randomize.nextInt(4)+1;
		
		int distance = randomize.nextInt(4)+1;
		
		return doTeleport(map, caster, side, distance);
	}

	@Override
	public void use(Map map, Controller caster, Controller target) {
		//metodo vazio
	}
}
