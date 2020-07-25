//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types;

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
	private static final int PRICE = 10;

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

		} while (amount > 5 || amount < 0);		//trocar o 5 pela visibilidade do mapa
		
		return amount;
	}

	public boolean use(Map map, Controller target, Scanner scanner) {
		/* Pergunta e teleporta o usuario para uma posicao visivel por ele */
		int x = target.getCharacter().getPosition().getX();
		int y = target.getCharacter().getPosition().getY();
		Coordinate newPosition = new Coordinate(x,y);
		
		System.out.println("Para qual dos lados deseja se teleportar: (1. Direita, 2. Esquerda, 3. Cima, 4. Baixo)");
		int side = readInteger(scanner);
		
		System.out.print("Quantas casas quer se mover: ");
		int distance = readInteger(scanner);
		
		switch(side) {
		case 1:
			newPosition.setY(y + distance);

			if (map.isTeleportablePosition(newPosition, target.getCharacter())) {
				map.setPosition(target.getCharacter(), newPosition);
				return true;
			}

			break;
		case 2:
			newPosition.setY(y - distance);

			if (map.isTeleportablePosition(newPosition, target.getCharacter())) {
				map.setPosition(target.getCharacter(), newPosition);
				return true;
			}

			break;
		case 3:
			newPosition.setX(x - distance);

			if (map.isTeleportablePosition(newPosition, target.getCharacter())) {
				map.setPosition(target.getCharacter(), newPosition);
				return true;
			}

			break;
		case 4:
			newPosition.setX(x + distance);

			if (map.isTeleportablePosition(newPosition, target.getCharacter())) {
				map.setPosition(target.getCharacter(), newPosition);
				return true;
			}

			break;
		default:
			break;
		}
		
		return false;
	}

	@Override
	public boolean use(Controller caster) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean use(Map map, Controller caster) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void use(Map map, Controller caster, Controller target) {
		// TODO Auto-generated method stub
		
	}

}
