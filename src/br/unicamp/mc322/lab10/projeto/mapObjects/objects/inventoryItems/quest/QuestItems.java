//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.quest;
import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;

public class QuestItems extends CanCarry{
	private QuestType questType;
	
	public QuestItems(String name, Sprite sprite, GameTypeObjects id, QuestType questType,Coordinate position) {
		super(name,sprite,id,position);
	}
	
	public QuestType getType() {
		return questType;
	}
}
