//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.structureTypes;

import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.structure.Structure;

public class Door extends Structure{
	private final String SPRITE = "";
	private final int ID = 0;
	private final String NAME = "Door";
	private boolean isOpen = false;
	
	public Door() {
		
	}
	
	public void discoverDoor() {
		
	}
	
	public void changeStatus() {
	/* Abre e fecha porta ao interagir */
	
	}
	
	public String toString() {
		if (!isVisible)
			return null;
		return SPRITE;
	}
}
