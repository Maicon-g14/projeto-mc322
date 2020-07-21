//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects;

import br.unicamp.mc322.lab10.projeto.map.objects.GameObject;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class NotAlive extends GameObject {
	public NotAlive(String name, Sprite sprite, GameTypeObjects id) {
		super(name, sprite, id);
	}

	public NotAlive(String name, Sprite sprite, GameTypeObjects id, Coordinate position) {
		super(name, sprite, id, position);
	}
}
