//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.structure.types;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.structure.Structure;

public class Stair extends Structure {

	private static final String NAME = "Stair";
	private static final char SPRITE = 'S';
	private static final GameTypeObjects ID = GameTypeObjects.STAIR;

	public Stair(Coordinate position) {
		super(NAME, new Sprite(SPRITE), ID, position);
	}

}
