//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.types;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.Sprite;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.AreaSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellElements;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellTypes;

public class Fireball extends AreaSpell {

	private static final String NAME = "Fireball";
	private static final int DICES = 6;
	private static final SpellElements ELEMENT = SpellElements.FIRE;
	private static final SpellTypes TYPE = SpellTypes.AREA_ATTACK;
	private static final GameTypeObjects ID = GameTypeObjects.FIREBALL;
	private static final int PRICE = 250;
	private static final int REACH = 3;		//distancia maxima do atacante ate o alvo
	private static final int ADJACENT_RANGE = 1;		//distancia adjacente ao alvo em que os oponentes podem sofrer dano	

	public Fireball() {
		super(NAME, new Sprite(), ID, ELEMENT, TYPE, REACH, ADJACENT_RANGE, PRICE);
	}

	public void use(Map map, Controller caster, Controller mainTarget, Controller[] adjacentTargets) {
		int damage = caster.rollMagicAttack(DICES);
		int shields = mainTarget.rollDefenseDices();

		if (damage - shields > 0) {
			mainTarget.getCharacter().takeDamage(damage - shields);
			if (mainTarget.getCharacter().isDead()) {
				map.remove(mainTarget);
			}
		} else {
			System.out.println("Mas " + mainTarget.getCharacter().getName() + "se defende e nao toma dano!");
		}

		if (adjacentTargets != null) {
			damage = caster.rollMagicAttack(DICES / 2);        //metade do dano

			for (Controller adjacentTarget : adjacentTargets) {

				if (adjacentTarget != null) {
					shields = adjacentTarget.rollDefenseDices();

					if (damage - shields > 0) {
						adjacentTarget.getCharacter().takeDamage(damage - shields);

						if (adjacentTarget.getCharacter().isDead()) {
							map.remove(adjacentTarget);
						}

					} else {
						System.out.println(adjacentTarget.getCharacter().getName() + " se defende sem tomar dano!");
					}
				}
			}
		}
	}

	@Override
	public void use(Map map, Controller caster, Controller target) {
		// TODO Auto-generated method stub

	}
}
