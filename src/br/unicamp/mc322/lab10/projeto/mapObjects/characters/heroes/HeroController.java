package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes;

import java.util.Random;
import java.util.Scanner;
import br.unicamp.mc322.lab10.projeto.Map;
import br.unicamp.mc322.lab10.projeto.WhiteDiceSides;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.CharacterController;
import br.unicamp.mc322.lab10.projeto.mapObjects.Command;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.mapObjects.characters.monsters.Monster;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.Defense;


public abstract class HeroController extends CharacterController {
	protected static final int MOVE_DICES = 2;
	protected Command direction;
	protected int remainingSteps;
	protected boolean moving = false; 
	
	public HeroController(Hero personagem) {
		super(personagem);
	}
	
	public Hero getCharacter() {
		return (Hero)super.getCharacter();
	}
	

	@Override
	public int rollDefenseDices() {
		//rola um numero de dados brancos e retorna o numero de escudos obtidos
		WhiteDiceSides dado;
		Hero personagem = getCharacter();
		int n = personagem.getDefenseValue();
		int result = 0;
		for(int i = 0; i < n; i++) {
			dado = rollWhiteDice();
			if(dado == WhiteDiceSides.HERO_DEFENSE)
				result++;
		}
		return result;
	}
	
	
	public void equipAttackEquipment(Attack equipment) {
		//equipa o equipamento no personagem e altera o numero de dados de ataque de acordo com as propriedades do equipamento
		int equipmentBonus = equipment.getBonusDiceNumber();
		Hero personagem = getCharacter();
		Attack[] currentEquipment = personagem.getAttackEquipment();
		if(currentEquipment[0] == null) {
			personagem.setAttackEquipment(0, equipment);
			personagem.setAttackValue(personagem.getAttackValue() + equipmentBonus);
			personagem.setRange(equipment.getReach());
		}else if (currentEquipment[1] == null) {
			personagem.setAttackEquipment(1, equipment);
			personagem.setAttackValue(personagem.getAttackValue() + equipmentBonus);
			personagem.setRange(equipment.getReach());
		}
	}
	
	public void unequipAttackEquipment() {
		//remove equipamento do personagem e altera o numero de dados de ataque de acordo com as propriedades do equipamento
		Hero personagem = getCharacter();
		Attack[] currentEquipment = personagem.getAttackEquipment();
		int equipmentDices;
		for(int i = 0; i < 2; i ++) {
			if(currentEquipment[i] != null) {
				equipmentDices = currentEquipment[i].getBonusDiceNumber();
				personagem.setAttackEquipment(i, null);
				personagem.setAttackDices(personagem.getAttackDices() - equipmentDices);
			}
		}
		personagem.setAttackValue(personagem.getAttackDices());
	}
	
	public void equipDefenseEquipment(Defense equipment) {
		//equipa o equipamento no personagem e altera o numero de dados de ataque de acordo com as propriedades do equipamento
		int equipmentBonus = equipment.getDices();
		Hero personagem = getCharacter();
		personagem.setDefenseEquipment(equipment);
		personagem.setDefenseValue(personagem.getDefenseDices() + equipmentBonus);
	}
	
	public void unequipDefenseEquipment() {
		//remove equipamento do personagem e altera o numero de dados de ataque de acordo com as propriedades do equipamento
		Hero personagem = getCharacter();
		personagem.setDefenseEquipment(null);
		personagem.setDefenseValue(personagem.getDefenseDices());
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
