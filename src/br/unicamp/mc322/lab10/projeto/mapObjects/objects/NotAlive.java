//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class NotAlive extends GameObject{
	public NotAlive(String name, Sprite sprite, GameTypeObjects id) {
		super(name,sprite,id);
	}
	
	public NotAlive(String name, Sprite sprite, GameTypeObjects id, Coordinate position) {
		super(name,sprite,id,position);
	}
}
