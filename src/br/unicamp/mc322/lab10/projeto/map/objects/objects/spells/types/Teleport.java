//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types;

import java.util.Scanner;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.Command;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellElements;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellTypes;

public class Teleport extends Spell {

	private static final String NAME = "Teleport";
	private static final int DICES = 0;        //nao se aplica
	private static final SpellElements ELEMENT = SpellElements.AIR;
	private static final SpellTypes TYPE = SpellTypes.SUPPORT;
	private static final GameTypeObjects ID = GameTypeObjects.TELEPORT;

	public Teleport() {
		super(NAME, new Sprite(), ID, DICES, ELEMENT, TYPE);
	}

	public void use(Controller target) {
		/*Implementação provisória, precisa ser testada e o código precisa ser melhorado. */
		int xDistance;
		int yDistance;
		int currentX;
		int currentY;
		Coordinate novaPosicao;
		
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite quantas posições quer se mover no eixo horizontal(positivos para a direita e negativo para a esquerda)");
		xDistance = leitor.nextInt();
		System.out.println("Digite quantas posições quer se mover no eixo vertical(positivos para cima e negativo para baixo)");
		yDistance = leitor.nextInt();
		leitor.close();
		
		novaPosicao = new Coordinate();
		currentX = target.getCharacter().getPosition().getX();
		currentY = target.getCharacter().getPosition().getY();
		novaPosicao.setX(currentX + xDistance);
		novaPosicao.setY(currentY + yDistance);
		target.getCharacter().setPosition(novaPosicao);
	}
}
