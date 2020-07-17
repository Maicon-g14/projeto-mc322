//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.quest.questItems;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.quest.QuestItems;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.quest.QuestType;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class Key extends QuestItems{
	private static final char SPRITE = 'K';
	private static final GameTypeObjects ID = GameTypeObjects.QUEST_KEY;
	private static final String NAME = "Key";
	private static final QuestType QUEST_TYPE = QuestType.KEY;
	
	public Key() {
		super(NAME,new Sprite(SPRITE),ID,QUEST_TYPE);
	}
}
