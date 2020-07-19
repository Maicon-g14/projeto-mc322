package br.unicamp.mc322.lab10.projeto.mapObjects.characters.heroes;

import java.util.Random;

import br.unicamp.mc322.lab10.projeto.mapObjects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.attack.Attack;
import br.unicamp.mc322.lab10.projeto.mapObjects.objects.inventoryItems.equipment.defense.Defense;

public abstract class HeroController implements Controller {
	private Hero personagem;
	
	
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
	
}
