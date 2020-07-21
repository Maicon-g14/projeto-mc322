//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.Structure;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class Stair extends Structure{
	private static final String NAME = "Stair";
	private static final char SPRITE = 'S';
	private static final GameTypeObjects ID = GameTypeObjects.STAIR;
	
	public Stair(Coordinate position) {
		super(NAME,new Sprite(SPRITE),ID,position);
	}
	
}
