package gameTut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject{

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler; 
	}

	Handler handler; 
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}
	
	public void tick() {
		x+= velX;
		y+= velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 32);
		y = Game.clamp(y, 0, Game.HEIGHT - 32);
		
		collision();
		
	}
	
	public ID getID() {
		return this.id;
	}
	
	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID() == ID.BasicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.baseHEALTH -= 1; 
				}
					
			} else if (tempObject.getID() == ID.Boss || tempObject.getID() == ID.SmartBoss) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.baseHEALTH -= 3;
				}
			}
		}
	}

	
	public void render(Graphics g) {
			
		
		if (id == ID.Wizard) {
			g.setColor(Color.blue);
		} else if (id == ID.Knight) {
			g.setColor(Color.yellow);
		} else {
			g.setColor(Color.green);
		}
		g.fillRect(x, y, 32, 32);
	}

	
}
