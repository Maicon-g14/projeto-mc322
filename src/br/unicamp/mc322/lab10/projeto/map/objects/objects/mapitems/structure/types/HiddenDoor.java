package br.unicamp.mc322.lab10.projeto.map.objects.objects.mapitems.structure.types;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;

public class HiddenDoor extends Door {
	private static final char HIDDEN_SPRITE = '#';
	private static final String NAME = "Hidden Door";
	private static final GameTypeObjects ID = GameTypeObjects.HIDDEN_DOOR;

	public HiddenDoor(Coordinate position) {
		super(NAME, new Sprite(HIDDEN_SPRITE), ID, position);
	}

	public void discoverDoor() {
		if (!isVisible()) {
			turnOnVisibility();
		}
	}

}
