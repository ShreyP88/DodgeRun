package gameTut;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class BossBullet extends GameObject{
	
	private Handler handler; 
	Random r = new Random();

	public BossBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		velX = r.nextInt(5 - - 5) + -5;
		velY = 4;
		
		this.handler = handler; 
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		/*if (y <= 0 || y>= Game.HEIGHT - 32) {
			velY *= -1;
		}
		
		if (x <= 0 || x >= Game.WIDTH - 32) {
			velX *= -1;
		} */
		
		if(y >= Game.HEIGHT) {
			handler.removeObject(this);
		}
		
		handler.addObject(new Trail(x,y, ID.Trail, handler, Color.white, 0.2f, 16, 16));
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 20, 20);
		
	}
}
