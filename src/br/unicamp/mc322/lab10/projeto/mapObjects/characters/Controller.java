package br.unicamp.mc322.lab10.projeto.mapObjects.characters;

public interface Controller {
	public Character getCharacter();
	public int rollRedDices(int n);
	public int rollAttackDices();
	public int rollDefenseDices();
	public void attack(Controller target);
}
