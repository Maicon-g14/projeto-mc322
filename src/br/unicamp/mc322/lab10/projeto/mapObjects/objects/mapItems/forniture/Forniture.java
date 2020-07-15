//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.forniture;

import br.unicamp.mc322.lab10.projeto.Coordinate;
import br.unicamp.mc322.lab10.projeto.mapObjects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.mapObjects.Sprite;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.mapItems.CantCarry;

public class Forniture extends CantCarry{
	
	public Forniture(String name, Sprite sprite, GameTypeObjects id,Coordinate position) {
		super(name,sprite,id,position);
	}
}
