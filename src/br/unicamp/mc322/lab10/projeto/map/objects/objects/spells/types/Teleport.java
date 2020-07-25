//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SelfSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellElements;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellTypes;

import java.util.Scanner;

public class Teleport extends SelfSpell {

	private static final String NAME = "Teleport";
	private static final SpellElements ELEMENT = SpellElements.AIR;
	private static final SpellTypes TYPE = SpellTypes.SUPPORT;
	private static final GameTypeObjects ID = GameTypeObjects.TELEPORT;

	public Teleport() {
		super(NAME, new Sprite(), ID, ELEMENT, TYPE);
	}

	public boolean use(Controller target) {
		/* Pergunta e teleporta o usuario para uma posicao visivel por ele */
		int x = target.getCharacter().getPosition().getX();
		int y = target.getCharacter().getPosition().getY();
		Coordinate newPosition = new Coordinate(x, y);

		Scanner leitor = new Scanner(System.in);
		System.out.println("Para qual dos lados deseja se teleportar: (1. Direita, 2. Esquerda, 3. Cima, 4. Baixo)");
		int side = leitor.nextInt();

		System.out.print("Quantas casas quer se mover: ");
		int distance = leitor.nextInt();
		leitor.close();

		switch (side) {
			case 1:
				newPosition.setY(y + distance);
				//por condicao de so teleportar pra areas visiveis aqui
				target.getCharacter().setPosition(newPosition);
				return true;
			case 2:
				newPosition.setY(y - distance);
				//por condicao de so teleportar pra areas visiveis aqui
				target.getCharacter().setPosition(newPosition);
				return true;
			case 3:
				newPosition.setX(x - distance);
				//por condicao de so teleportar pra areas visiveis aqui
				target.getCharacter().setPosition(newPosition);
				return true;
			case 4:
				newPosition.setX(x + distance);
				//por condicao de so teleportar pra areas visiveis aqui
				target.getCharacter().setPosition(newPosition);
				return true;
			default:
				break;
		}

		return false;
	}
}
