package br.unicamp.mc322.lab10.projeto.mapObjects.characters;
import br.unicamp.mc322.lab10.projeto.Map;
import br.unicamp.mc322.lab10.projeto.WhiteDiceSides;

public interface Controller {
	public void playTurn( Map map);
	public Character getCharacter();
	public int rollRedDices(int n);
	public int rollAttackDices();
	public int rollDefenseDices();
	public void attack(Controller target);
	public WhiteDiceSides rollWhiteDice();
}
