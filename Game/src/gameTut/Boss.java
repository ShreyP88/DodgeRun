package gameTut;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Boss extends GameObject{
	
	private Handler handler; 

	public Boss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		velX = 2;
		velY = 8;
		
		this.handler = handler; 
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if (y <= 0 || y>= Game.HEIGHT - 32) {
			velY *= -1;
		}
		
		if (x <= 0 || x >= Game.WIDTH - 32) {
			velX *= -1;
		}
		
		handler.addObject(new Trail(x,y, ID.Trail, handler, Color.CYAN, 0.08f, 16, 16));
	}

	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(x, y, 16, 16);
		
	}

}
