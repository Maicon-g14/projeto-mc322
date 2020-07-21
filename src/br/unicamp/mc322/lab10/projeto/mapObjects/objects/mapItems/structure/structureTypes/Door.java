//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.Structure;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class Door extends Structure{
	private static final String NAME = "Door";
	private static final char SPRITE = 'U';
	private static final GameTypeObjects ID = GameTypeObjects.DOOR;
	
	public Door(Coordinate position) {
		super(NAME,new Sprite(SPRITE),ID,position);
	}
	
	protected Door(String name, Sprite sprite, GameTypeObjects id,Coordinate position) {
		super(name,sprite,id,position);
	}
	
}
