//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class GameObject {
	private String name;
	private GameTypeObjects id;		//cada tipo de objeto tem seu ID proprio para busca
	private GameTypeObjects type = GameTypeObjects.GAME_OBJECT;
	private Coordinate mapPosition;		//posicao do objeto no mapa
	private Sprite sprite;		//simbolo que representa cada objeto no mapa(uma constante)
	private boolean visible = true;
	
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
	
	public GameObject(String name, Sprite sprite, GameTypeObjects id, Coordinate mapPosition, GameTypeObjects type) {
		this.name = name;
		this.sprite = sprite;
		this.id = id;
		this.mapPosition = mapPosition;
		this.type = type;
	}
	
	public GameObject(String name, Sprite sprite, GameTypeObjects id, GameTypeObjects type) {
		this.name = name;
		this.sprite = sprite;
		this.id = id;
		this.mapPosition = null;
		this.type = type;
	}
	
	public void setPlayerName(String name, GameTypeObjects player) {
		/* O nome de um objeto so pode ser trocado se o objeto for o nome do player */
		if (player == GameTypeObjects.PLAYER)
			this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Coordinate getPosition() {
		return mapPosition;
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
	
	public GameTypeObjects getType() {
		return type;		//tipo generico do item
	}
	
	protected void turnOnVisibility() {
		visible = true;
		sprite.show();
	}
	
	protected void turnOffVisibility() {
		visible = false;
		sprite.hide();
	}
	
	public Boolean isVisible() {
		return visible;
	}
	
	public GameTypeObjects getId() {
		return id;		//tipo especifico do item
	}
	
}
