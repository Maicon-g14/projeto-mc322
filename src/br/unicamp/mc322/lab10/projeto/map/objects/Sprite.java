//RAs
//221329
//224956 
//242233

package br.unicamp.mc322.lab10.projeto.map.objects;

public class Sprite {

	char[] sprite;
	char hide;
	int now;
	boolean hidden = false;

	public Sprite() {
		sprite = new char[1];
		hide = ' ';
		now = 0;
		sprite[now] = '?';
		hidden = true;
	}

	public Sprite(char sprite) {
		this.sprite = new char[1];
		hide = ' ';
		now = 0;
		this.sprite[now] = sprite;
		hidden = true;
	}

	public Sprite(char sprite, char hide) {
		this.sprite = new char[1];
		this.hide = hide;
		now = 0;
		this.sprite[now] = sprite;
		hidden = true;
	}

	public Sprite(char[] sprite) {
		hide = ' ';
		now = 0;
		this.sprite = sprite;
		hidden = true;
	}

	public Sprite(char[] sprite, char hide) {
		this.hide = hide;
		now = 0;
		this.sprite = sprite;
		hidden = true;
	}

	public void nextSprite() {
		if (now < sprite.length - 1) {
			now++;
		}
	}

	public void prevSprite() {
		if (now > 0) {
			now--;
		}
	}

	public void showSprite() {
		if (hidden) {
			System.out.printf("%c", hide);
		} else {
			System.out.printf("%c", sprite[now]);
		}
	}

	public void show() {
		hidden = false;
	}

	public void hide() {
		hidden = true;
	}

}
