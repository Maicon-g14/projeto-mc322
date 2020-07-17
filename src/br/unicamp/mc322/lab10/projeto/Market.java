//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto;

import java.util.Scanner;

import br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes.Hero;

import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.CanCarry;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.Money.Money;

public class Market {
	private static final int INITIAL_FUNDS = 250;
	private static final int OUT = 0;
	private static final int BUY = 1;
	private static final int SELL = 2;
	
	CanCarry[] marketItems;
	Money money = new Money();
	
	public Market(CanCarry[] items) {
		marketItems = items;
		money.addMoney(INITIAL_FUNDS);
	}
	
	public void doShopping(Hero hero) {
	/* Loop de compras na loja, chama exibição dos itens da loja e selecionado um item
	 * para compra tenta debitar o valor da classe Money no Player, se retornar true,
	 * adiciona item no inventário do Player */
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int operation, itemNumber;
		
		System.out.println("Bem vindo a loja!");
		
		do {
			System.out.println("O que deseja fazer? (numero da operacao)\n 0.Sair  1.Comprar  2.Vender");
			
			operation = keyboard.nextInt();
			
			if(operation == BUY) {
				do {
					showMarketItems();
					System.out.println("Insira o numero do item que deseja comprar ou 0 para sair.");
					
					itemNumber = keyboard.nextInt();
					buyItem(hero,itemNumber);
				
				} while (itemNumber != OUT);
				
			} else if (operation == SELL) {
				do {
					showInventoryItems(hero);
					System.out.println("Insira o numero do item que deseja vender ou 0 para sair.");
					
					itemNumber = keyboard.nextInt();
					sellItem(hero,itemNumber);
				
				} while (itemNumber != OUT);
				
			} else if (operation != OUT)
				System.out.println("Numero da operacao invalido!");
			
		} while (operation != OUT);
		
		System.out.println("Volte sempre!");
		
	}
	
	private void buyItem(Hero hero, int item) {
		/* Player compra item da loja */
		if (item > 0 && item < marketItems.length) {
			CanCarry choosen = marketItems[item-1];
			if(hero.buy(choosen)) {
				System.out.println(choosen.getName() + " Adquirido!");
				money.addMoney(choosen.getPrice());
			}
			
		} else if (item < 0 || item > marketItems.length)
			System.out.println("Numero da operacao invalido!");
	}
	
	private void sellItem(Hero hero, int item) {
		/* Player vende item para a loja */
		CanCarry[] inventory = hero.getInventory();
		
		if (item > 0 && item <= hero.getInventoryLoad()) {
			CanCarry inventoryItem = inventory[item-1];
			
			int price = inventoryItem.getPrice();
			
			if (money.removeMoney(price)) {
				hero.removeInventory(item-1);
				System.out.println(inventoryItem.getName() + " vendido por " + price + "PO");
			} else
				System.out.println("Nao tenho fundos para aceitar tal oferta!");
		} else if (item < 0 || item > hero.getInventoryLoad())
			System.out.println("Numero da operacao invalido!");
		
	}
	
	private void showMarketItems() {
		/* Exibe os itens da loja e seus respectivos preços */
		System.out.println("Items disponiveis para venda:");
		
		for(int i = 0; i < marketItems.length; i++)
			System.out.println(i+1 + ". " + marketItems[i].getName() + "   " + marketItems[i].getPrice() + "PO");
	}
	
	private void showInventoryItems(Hero hero) {
		/* Exibe os itens do inventario e seus respectivos preços */
			CanCarry[] inventory = hero.getInventory();
		
			System.out.println("Seus items:");
			
			for(int i = 0; i < inventory.length; i++)
				System.out.println(i+1 + ". " + inventory[i].getName() + "   " + marketItems[i].getPrice() + "PO");
		}
}
