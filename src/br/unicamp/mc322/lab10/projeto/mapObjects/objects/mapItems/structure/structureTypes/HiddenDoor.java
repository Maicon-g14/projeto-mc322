package br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;

public class HiddenDoor extends Door{
	private static final char HIDDEN_SPRITE = '#';
	private static final String NAME = "Hidden Door";
	private static final GameTypeObjects ID = GameTypeObjects.HIDDEN_DOOR;

	public HiddenDoor(Coordinate position) {
		super(NAME,new Sprite(HIDDEN_SPRITE),ID,position);
	}

	public void discoverDoor() {
		if (!isVisible())
			turnOnVisibility();
	}
	
}
