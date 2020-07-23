package br.unicamp.mc322.lab10.projeto.map.objects.characters;

public interface Controller {

	Character getCharacter();

	int rollRedDices(int n);

	int rollAttackDices();

	int rollDefenseDices();
	
	int rollMagicDefenseDices();

	void attack(Controller target);
}
