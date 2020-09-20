package gameTut;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class SmartBoss extends GameObject{
	
	private Handler handler; 
	private GameObject player; 

	public SmartBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler; 
		
		for(int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getID() == ID.Wizard || handler.object.get(i).getID() == ID.Knight) {
				player = handler.object.get(i);
			}
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getx() - 8; 
		float diffY = y - player.gety() - 8;
		float distance = (float) Math.sqrt((x-player.getx())*(x-player.getx()) + (y-player.gety())*(y-player.gety()));
		velX = (float) ((-1.0/distance) * diffX);
		velY = (float) ((-1.0/distance) * diffY);
		
		if (y <= 0 || y>= Game.HEIGHT - 32) {
			velY *= -1;
		}
		
		if (x <= 0 || x >= Game.WIDTH - 32) {
			velX *= -1;
		}
		
		handler.addObject(new Trail(x,y, ID.Trail, handler, Color.green, 0.05f, 16, 16));
		
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 20, 20);
		
	}

}
