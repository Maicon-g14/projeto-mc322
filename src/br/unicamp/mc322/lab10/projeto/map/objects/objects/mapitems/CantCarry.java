//RAs
//
//
//


package br.unicamp.mc322.lab10.projeto.map.objects.objects.mapitems;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.NotAlive;

public class CantCarry extends NotAlive {

	public CantCarry(String name, Sprite sprite, GameTypeObjects id, Coordinate position) {
		super(name, sprite, id, position);
	}
}
