//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;

public class Market {
	
	CanCarry[] marketItems;
	int[] marketPrices;
	
	public Market() {
		
	}
	
	public void addItems(CanCarry[] items, int[] itemsPrice) {
	/* Adiciona lista de items como op��es de compra na loja e seus respectivos pre�os */
		
	}
	
	public void addItems(CanCarry item, int itemPrice) {
	/* Adiciona item como op��es de compra na loja e seu respectivo pre�o */
		
	}
	
	public void removeItem(int itemId) {
	/* Encontra e remove item da loja e de seu vetor de pre�os */
		
	}
	
	public void doShopping(Hero hero) {
	/* Loop de compras na loja, chama exibi��o dos itens da loja e selecionado um item
	 * para compra tenta debitar o valor da classe Money no Player, se retornar true,
	 * adiciona item no invent�rio do Player */
	
	}
	
	public void showItems() {
	/* Exibe os itens da loja e seus respectivos pre�os */
		
	}
}
