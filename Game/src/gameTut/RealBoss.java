package gameTut;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class RealBoss extends GameObject{
	
	private Handler handler; 
	private int timer = 80;
	private int timerJr = 50;
	Random r = new Random();

	public RealBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		velX = 0;
		velY = 2;
		
		this.handler = handler; 
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,96,96);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if (timer <= 0) {
			velY = 0;
		} else {
			timer--;
		}
		
		if (timer <= 0) {
			timerJr--;
		} 
		
		if (timerJr <= 0) {
			int spawn = r.nextInt(10);
			if (spawn == 0) {
				handler.addObject(new BossBullet(x + 48 ,y + 48,ID.BasicEnemy, handler));
			}
		}
		
		
		/*if (y <= 0 || y>= Game.HEIGHT - 32) {
			velY *= -1;
		} 
		
		if (x <= 10 || x >= Game.WIDTH - -96) {
			velX *= -1;
		} */
		
		handler.addObject(new Trail(x,y, ID.Trail, handler, Color.pink, 0.2f, 96, 96));
	}

	public void render(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect(x, y, 96, 96);
		
	}

}
