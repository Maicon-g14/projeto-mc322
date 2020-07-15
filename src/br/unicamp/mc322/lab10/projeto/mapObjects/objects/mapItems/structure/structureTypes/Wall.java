//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.Structure;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class Wall extends Structure{
	private static final String NAME = "Wall";
	private static final char SPRITE = '#';
	private static final GameTypeObjects ID = GameTypeObjects.WALL;
	
	public Wall(Coordinate position){
		super(NAME,new Sprite(SPRITE),ID,position);
	}
}
