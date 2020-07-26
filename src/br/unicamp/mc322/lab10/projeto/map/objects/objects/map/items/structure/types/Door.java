//RAs
//221329
//224956 
//242233

package br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.structure.types;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.map.items.structure.Structure;

public class Door extends Structure {

	private static final String NAME = "Door";
	private static final char SPRITE = 'U';
	private static final GameTypeObjects ID = GameTypeObjects.DOOR;

	public Door(Coordinate position) {
		super(NAME, new Sprite(SPRITE), ID, position);
	}

	protected Door(String name, Sprite sprite, GameTypeObjects id, Coordinate position) {
		super(name, sprite, id, position);
	}

}
