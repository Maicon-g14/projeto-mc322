//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.forniture.fornitureTypes;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.forniture.Forniture;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class Chest extends Forniture{
	private static final char SPRITE = 'C';
	private static final GameTypeObjects ID = GameTypeObjects.CHEST;
	private static final String NAME = "Chest";
	private CanCarry[] content;
	private Boolean open = false;
	
	public Chest(CanCarry[] content,Coordinate position) {
		super(NAME,new Sprite(SPRITE),ID, position);
		this.content = content;
	}
	
	public CanCarry[] getItems() {
		if(!open) {
			open = true;
			return content;
		}
		
		return null;
	}
}
