//RAs
//
//
//


package br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.NotAlive;

public class CantCarry extends NotAlive{
	public CantCarry(String name, Sprite sprite, GameTypeObjects id,Coordinate position) {
		super(name,sprite,id,position);
	}
}
