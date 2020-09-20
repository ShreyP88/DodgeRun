package gameTut;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int x, y;
	protected ID id;
	protected float velX;
	protected float velY;
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	} 
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds(); 
	
	public void setx(int x) {
		this.x = x;
	}
	
	public void sety(int y) {
		this.y = y;
	}
	
	public int getx() {
		return x;
	}
	
	public int gety() {
		return y; 
	}
	
	public void setID(ID id) {
		this.id = id;
	}
	
	public ID getID() {
		return id;
	}
	
	public void setvelX(int velX) {
		this.velX = velX;
	}
	
	public void setvelY(int velY) {
		this.velY = velY;
	}
	
	public float getvelX() {
		return velX;
	}
	
	public float getvelY() {
		return velY;
	}
	
	
}
