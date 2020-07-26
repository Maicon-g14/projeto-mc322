package br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters;

import java.util.Random;

import br.unicamp.mc322.lab10.projeto.map.Map;
import br.unicamp.mc322.lab10.projeto.map.objects.GameTypeObjects;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.CommonControllers;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.Controller;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.heroes.WhiteDiceSides;
import br.unicamp.mc322.lab10.projeto.map.objects.characters.monsters.classes.MonsterSpellCaster;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.AreaSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SelfSpell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.Spell;
import br.unicamp.mc322.lab10.projeto.map.objects.objects.spells.SpellTypes;

public class CpuMonster extends CommonControllers {
	
	private static final boolean IS_MONSTER_HUNTING = true;
	protected Monster monster;

	public CpuMonster(Monster monster) {
		this.monster = monster;
	}

	@Override
	public int rollAttackDices() {
		//rola todos os dados de ataque do getCharacter() e retorna o numero de caveiras obtidas
		return rollWhiteDices(monster.getAttackDices(), WhiteDiceSides.ATTACK);
	}

	@Override
	public int rollDefenseDices() {
		return rollWhiteDices(monster.getDefenseDices(), WhiteDiceSides.MONSTER_DEFENSE);
	}

	@Override
	public int rollMagicDefenseDices() {
		return rollWhiteDices(monster.getIntelligence(), WhiteDiceSides.MONSTER_DEFENSE);
	}

	@Override
	public Monster getCharacter() {
		return monster;
	}



	private void castAttack(Map map, Spell spell, int dice, MonsterSpellCaster caster) {
		/* Lanca ataque magico no oponente se estiver no raio de ataque */
		Controller target = map.findSpellTarget(getCharacter().getPosition(), spell.getReach(), IS_MONSTER_HUNTING);
		
		if (target != null) {		//cancela ataque caso nao tenha alvo
			System.out.println(getCharacter().getName() + " tenta lancar feitico " + spell.getName() + " em " + target.getCharacter().getName() + "!");
			caster.castSpell(map, this, target, spell, dice);
		}
	}
	
	private void castAreaAttack(Map map, AreaSpell spell, int dice, MonsterSpellCaster caster) {
		/* Procura por alvo mais proximo dentro do raio dado, se encontrar,
		 * ataca ele e os possiveis alvos adjacentes a ele com o feitico */
		Controller target = map.findSpellTarget(getCharacter().getPosition(), spell.getReach(), IS_MONSTER_HUNTING);		//busca por alvo principal
		
		if (target != null) {		//cancela ataque caso nao tenha alvo
			System.out.println(getCharacter().getName() + " tenta lancar feitico " + spell.getName() + " em " + target.getCharacter().getName() + " e em todos ao seu redor!");
			Controller[] additionalTargets = map.getAdjacentTargetsInDelimitedArea(target.getCharacter().getPosition(), spell.getAdjacentReach(), IS_MONSTER_HUNTING);		//busca por alvos secundarios em torno do principal na distancia especificada
			
			caster.castSpell(map, this, target, additionalTargets, spell, dice);
		}
	}

	private Spell chooseSpell(Spell[] spells) {
		Random gerador = new Random();
		MonsterSpellCaster caster = (MonsterSpellCaster) getCharacter();
		
		if (caster.getQtdSpells() > 0) {
			int index = gerador.nextInt(caster.getQtdSpells());
			return spells[index];
		}
		return null;
	}
	
	@Override
	public boolean useMagic(Map map) {

		if (GameTypeObjects.isMagicUser(getCharacter())) {		//se atacante for do tipo que usa magias
			
			MonsterSpellCaster caster = (MonsterSpellCaster) getCharacter();
			Spell spell = chooseSpell(caster.getSpells());		//sobrescrever essa parte pro npc
			
			if (spell == null) {
				return false;
			}
			
			int dice = rollRedDices(1);		//rolagem do dado que define se a magia foi sucesso ou nao

			if (spell.getSpellType() == SpellTypes.SUPPORT) {
				System.out.println(getCharacter().getName() + " tenta usar o feitico " + spell.getName() + " em si mesmo!");
				if (spell.getId() == GameTypeObjects.TELEPORT) {
					caster.castSpell(map, this, (SelfSpell) spell, dice);
				} else {
					caster.castSpell(this, (SelfSpell) spell, dice);		//magias de support sao sempre utilizadas no proprio usuario
				}
			} else if (spell.getSpellType() == SpellTypes.ATTACK) {
				castAttack(map,spell,dice,caster);
			
			} else if (spell.getSpellType() == SpellTypes.AREA_ATTACK) {
				castAreaAttack(map,(AreaSpell) spell,dice,caster);
			}
		} else {
			return false;
		}
		return true;
	}

}
