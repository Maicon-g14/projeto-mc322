package br.unicamp.mc322.lab10.projeto;

import java.util.Arrays;

import br.unicamp.mc322.lab10.projeto.mapObjects.GameObject;

public class QuestBase {
	private GameObject[] keyItem;
	private GameObject[][] reward;
	private int numberOfQuests;
	private int nowQuest;
	
	public QuestBase() {
		this.numberOfQuests = 0;
		this.nowQuest = 0;
	}
	
	public GameObject[] getReward(GameObject keyItem) {
		if(this.keyItem[nowQuest].getId() == keyItem.getId())
			return reward[nowQuest++];
		return null;
	}
	
	public GameObject[] getReward() {
		if(this.keyItem[nowQuest] == null)
			return reward[nowQuest++];
		return null;
	}
	
	public Boolean isFinished() {
		if (nowQuest >= numberOfQuests)
			return true;
		return false;
	}
	
	private void increaseRewardArray() {
		if (reward == null)
			reward = new GameObject[1][1];
		else
			reward[numberOfQuests] = Arrays.copyOf(reward[numberOfQuests], reward[numberOfQuests].length+1);
	}
	
	private void increaseKeyItemArray() {
		if (keyItem == null)
			keyItem = new GameObject[1];
		else
			keyItem = Arrays.copyOf(keyItem, keyItem.length+1);
	}
	
	public void addQuest(GameObject[] reward) {
		increaseRewardArray();
		this.reward[numberOfQuests++] = reward;
	}
	
	public void addQuest(GameObject keyItem, GameObject[] reward) {
		addQuest(reward);
		increaseKeyItemArray();
		this.keyItem[numberOfQuests-1] = keyItem;
	}
}
