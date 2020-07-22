//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.structure.types;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.structure.Structure;

public class Wall extends Structure {

	private static final String NAME = "Wall";
	private static final char SPRITE = '#';
	private static final GameTypeObjects ID = GameTypeObjects.WALL;

	public Wall(Coordinate position) {
		super(NAME, new Sprite(SPRITE), ID, position);
	}
}
