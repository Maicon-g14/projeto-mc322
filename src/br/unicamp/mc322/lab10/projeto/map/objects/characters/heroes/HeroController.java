package br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes;

import br.unicamp.mc322.lab10.projeto.exceptions.FullInventoryException;
import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.classes.SpellCaster;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.inventory.items.CanCarry;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellTypes;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.CommonControllers;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;

import java.util.Scanner;

public abstract class HeroController extends CommonControllers {

	private Hero personagem;

	public HeroController(Hero personagem) {
		this.personagem = personagem;
	}
	
	public int rollAttackDices() {
		//rola todos os dados de ataque do personagem e retorna o numero de caveiras obtidas
		return rollWhiteDices(personagem.getAttackDices(), WhiteDiceSides.ATTACK);
	}

	public int rollDefenseDices() {
		//rola todos os dados de defesa do personagem e retorna o numero de escudos obtidos
		return rollWhiteDices(personagem.getDefenseDices(), WhiteDiceSides.HERO_DEFENSE);
	}

	//Leitura de um numero do teclado, pode ser removida se houver uma classe mais apropriada para ela
	public int numberFromKeyboard() {
		@SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);

		int entrada;
		entrada = leitor.nextInt();

		return entrada;
	}

	public Hero getCharacter() {
		return personagem;
	}
	
	public void attack(Controller target) {
		//rola os dados de ataque do personagem, faz o alvo rolar os dados de defesa e chama a fun�ao de ataque do personagem
		int skulls = rollAttackDices();
		int shields = target.rollDefenseDices();

		if (skulls > shields) {
			personagem.attack(target.getCharacter(), skulls - shields);
		}
	}

	public void addToInventory(CanCarry item) {
		/* Adiciona um item qualquer(carregavel) ao inventario, se for equipamento e melhor que o atual,
		 * equipa automaticamente */
		try {
			getCharacter().addToInventory(item);
		} catch (FullInventoryException e) {
			System.err.println(e.getMessage());
		}

	}

	public void askPotion() {
		getCharacter().askPotion();
	}

	public void useMagic(Map map) {
		SpellCaster caster;
		Spell spell;
		Controller target;
		int dice;

		if (isMagicUser()) {
			caster = (SpellCaster) personagem;
			spell = chooseSpell(caster.getSpells());
			dice = rollRedDices(1); //rolagem do dado que define se a magia foi sucesso ou não

			if (spell.getSpellType() == SpellTypes.SUPPORT) {
				caster.castSpell(this, spell, dice);//magias de support são sempre utilizadas no próprio usuario

			} else if (spell.getSpellType() == SpellTypes.ATTACK) {
				//target = map.callAttack(this);//chamar funcao que escolhe o alvo
				//caster.castSpell(target, spell, dice);

			}
		}

	}

	public void displaySpells() {
		Spell[] spellList;
		if(isMagicUser()) {
			SpellCaster caster = (SpellCaster)personagem;
			spellList = caster.getSpells();
			for(int i = 0; i < caster.getQtdSpells(); i++) {
				System.out.println(i + "- " + spellList[i].getName());
			}
		}
	}
	
	private boolean isMagicUser() {
		if(personagem.getId() == GameTypeObjects.ELF || personagem.getId() == GameTypeObjects.WIZARD)
			return true;
		return false;
	}

	public abstract Spell chooseSpell(Spell[] spells);
	
	public int rollMagicDefenseDices() {
		/*Rola dados brancos de acordo com a inteligencia do personagem e retorna o numero de escudos obtidos*/
		return rollWhiteDices(personagem.getIntelligence(), WhiteDiceSides.HERO_DEFENSE);
	}

}
