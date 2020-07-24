package br.unicamp.mc322.lab10.projeto.map.objects.characters;

import br.unicamp.mc322.lab10.projeto.map.objects.characters.Character;

public interface Controller {

	Character getCharacter();

	int rollRedDices(int n);

	int rollAttackDices();

	int rollDefenseDices();
	
	int rollMagicDefenseDices();

	void attack(Character target);
}
