//RAs
//
//
//

package br.unicamp.mc322.lab10.projeto.mapObjects;
import br.unicamp.mc322.lab10.projeto.Coordinate;

public class GameObject {
	private String name;
	private boolean visible = true;
	private boolean collide = true;		//antes de mover algo sempre verificar se nao exite obj no lugar e caso exista se ele tem colisao
											//obj sem colisao sao sobrescritos pelos que se movem
	private Coordinate mapPosition;		//posicao do objeto no mapa
	private String sprite;		//simbolo que representa cada objeto no mapa(uma constante)
	private int id;		//cada tipo de objeto tem seu ID proprio para busca
	
	public GameObject(String name, String sprite, int id) {
		this.name = name;
		this.sprite = sprite;
		this.id = id;
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
	
	public String getSprite() {
		return sprite;
	}
	
	public void setSprite(String sprite) {
	/* Muda sprite do objeto */
		this.sprite = sprite;
	}
	
	public void disableCollision() {
		collide = false;		//pode ser usado para pisar em cima da escada depois que derrotar todos os monstros
	}
	
	public void enableCollision() {
		collide = true;
	}
	
	public void turnOnVisibility() {
		visible = true;		//simula o que o player consegue enxergar
	}
	
	public void turnOffVisibility() {
		visible = false;
	}
	
	public Boolean willCollide() {
		return collide;
	}
	
	public Boolean isVisible() {
		return visible;
	}
	
	public int getiId() {
		return id;		//id usado para encontrar um objeto
	}
}
