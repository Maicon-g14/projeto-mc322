package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes;

import java.util.Random;
import java.util.Scanner;

import br.unicamp.mc322.lab10.projeto.Map;
import br.unicamp.mc322.lab10.projeto.mapObjects.Command;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.Defense;

public abstract class HeroController implements Controller {
	private Hero personagem;
	protected static final int MOVE_DICES = 2;
	protected Command direction;
	protected int remainingSteps;
	protected boolean moving = false; 
	
	
	public HeroController(Hero personagem) {
		this.personagem = personagem;
	}

	public Hero getCharacter() {
		return personagem;
	}
	
	public int rollRedDices(int n) {
		int result = 0;
		Random gerador = new Random();
		for(int i = 0; i < n; i ++) {
			result += 1 + gerador.nextInt(6);
		}
		return result;
	}
	
	public int rollAttackDices() {
		//rola todos os dados de ataque do personagem e retorna o numero de caveiras obtidas
		return 0;
	}
	
	public int rollDefenseDices() {
		//rola todos os dados de defesa do personagem e retorna o numero de escudos obtidos
		return 0;
	}
	
	public void attack(Controller target) {
		//rola os dados de ataque do personagem, faz o alvo rolar os dados de defesa e chama a função de ataque do personagem
		int skulls = rollAttackDices();
		int shields = rollDefenseDices();
		if (skulls > shields)
			personagem.attack(target.getCharacter(), skulls - shields);
	}
	
	public void equipAttackEquipment(Attack equipment) {
		//equipa o equipamento no personagem e altera o numero de dados de ataque de acordo com as propriedades do equipamento
	}
	
	public void unequipAttackEquipment() {
		//remove equipamento do personagem e altera o numero de dados de ataque de acordo com as propriedades do equipamento
	}
	
	public void equipDefenseEquipment(Defense equipment) {
		//equipa o equipamento no personagem e altera o numero de dados de ataque de acordo com as propriedades do equipamento
	}
	
	public void unequipDefenseEquipment() {
		//remove equipamento do personagem e altera o numero de dados de ataque de acordo com as propriedades do equipamento
	}
	
	protected void callMove(Map map) {
		/* Chama movimentacao do player, se encontrar com obstaculo, desativa sinal
		 * de que esta se movimentando */
		if(!getCharacter().move(direction, map))
			moving = false;
	}
	
	public void playTurn(Map map){
		/* Turno do jogador */
		Scanner scanner = new Scanner(System.in);
		
		if(!moving) {
			//action(map,scanner);
			newDirection(map,scanner);
		} else {
			callMove(map);
			//action(map,scanner);
		}
		
		if(--remainingSteps <= 0)
			moving = false;
	}
	
	protected abstract void newDirection(Map map, Scanner scanner);		//possibilidade de controlar todos os demais herois
	
	protected abstract void action(Map map, Scanner scanner);
}
