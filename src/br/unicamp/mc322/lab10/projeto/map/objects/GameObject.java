//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.map.objects;

import br.unicamp.mc322.lab10.projeto.map.Coordinate;

public class GameObject {

	private String name;
	private GameTypeObjects id;        //cada tipo de objeto tem seu ID proprio para busca
	private Coordinate mapPosition;        //posicao do objeto no mapa
	private Sprite sprite;        //simbolo que representa cada objeto no mapa(uma constante)

	public GameObject(String name, Sprite sprite, GameTypeObjects id, Coordinate mapPosition) {
		this.name = name;
		this.sprite = sprite;
		this.id = id;
		this.mapPosition = mapPosition;
	}

	public GameObject(String name, Sprite sprite, GameTypeObjects id) {
		this.name = name;
		this.sprite = sprite;
		this.id = id;
		this.mapPosition = null;
	}

	public String getName() {
		return name;
	}

	public Coordinate getPosition() {
		return mapPosition;
	}

	public GameTypeObjects getId() {
		return id;        //tipo especifico do item
	}

	public void setPlayerName(String name, GameTypeObjects player) {
		/* O nome de um objeto so pode ser trocado se o objeto for o nome do player */
		if (player == GameTypeObjects.PLAYER) {
			this.name = name;
		}
	}

	public void setPosition(Coordinate position) {
		mapPosition = position;
	}

	public void print() {
		sprite.showSprite();
	}

	public void nextSprite(int n) {
		sprite.nextSprite();
	}

	public void previousSprite(int n) {
		sprite.prevSprite();
	}

	public void hideSprite() {
		sprite.hide();
	}

	public void showSprite() {
		sprite.show();
	}
}
