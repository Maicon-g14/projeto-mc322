//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class GameObject {
	private String name;
	private GameTypeObjects id;		//cada tipo de objeto tem seu ID proprio para busca
	private Coordinate mapPosition;		//posicao do objeto no mapa
	private Sprite sprite;		//simbolo que representa cada objeto no mapa(uma constante)
	private boolean visible = true;
	private boolean collide = true;
	protected boolean disable = false;
	
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
	
	public void setSprite(Sprite sprite) {
	/* Muda sprite do objeto */
		this.sprite = sprite;
	}
	
	protected void disableCollision() {
		collide = false;		//pode ser usado para pisar em cima da escada depois que derrotar todos os monstros
	}
	
	protected void enableCollision() {
		collide = true;
	}
	
	protected void turnOnVisibility() {
		visible = true;
		sprite.show();
	}
	
	protected void turnOffVisibility() {
		visible = false;
		sprite.hide();
	}
	
	public Boolean willCollide() {
		return collide;
	}
	
	public Boolean isVisible() {
		return visible;
	}
	
	public GameTypeObjects getId() {
		return id;		//id usado para encontrar um objeto
	}
	
	public Boolean disabled() {
		/* Checagem se o objeto ja foi usado e deve ser excluido do mapa */
		return disable;
	}
	
}
