//RAs
//
//
//


package br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.notPlayable;

import br.unicamp.mc322.lab10.projeto.mapObjects.aliveCreatures.Alive;

public class NotPlayable extends Alive {
	
	public NotPlayable(String name, int hp, int mp, int atk, int def, String sprite, int attackDices, int defenseDices) {
	
	}
	
	public void searchAttack(Alive creatures) {
	/* Dado um adversário visivel no mapa, escolhe a direcao para ir ate ele e chama walk ou
	 * caso nao seja visivel chama chooseSideToWalk */
		
	}
	
	public void chooseSideToWalk() {
	/* Aleatoriamente escolhe uma direcao para andar e chama walk */
	
	}
	
	public void walk(int maxSteps) {
	/* Aleatoriamente escolhe uma qtde de passos p/ andar <=maxSteps obtida no dado */	
		
	}
}
