package br.unicamp.mc322.lab10.projeto.map.objects.characters;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.WhiteDiceSides;

public interface Controller {

	Character getCharacter();

	boolean playTurn(Map map);

	int rollRedDices(int n);

	int rollWhiteDices(int qtde, WhiteDiceSides lookingFor);

	int rollAttackDices();

	int rollDefenseDices();

	int rollMagicAttack(int dices);

	int rollMagicDefenseDices();

	void attack(Controller target);
}
