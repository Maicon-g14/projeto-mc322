package br.unicamp.mc322.lab10.projeto.mapObjects.characters;
import br.unicamp.mc322.lab10.projeto.Map;

public interface Controller {
	public void playTurn( Map map);
	public Character getCharacter();
	public int rollDices(int n);
	public int rollAttackDices();
	public int rollDefenseDices();
	public void attack(Controller target);
}
