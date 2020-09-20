package gameTut;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class menuEffects extends GameObject{
	
	private Handler handler; 
	Random r = new Random(); 
	
	private int red = r.nextInt(255);
	private int green = r.nextInt(255);
	private int blue = r.nextInt(255);

	private Color color;
;
	
	public menuEffects(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		
		velX = (r.nextInt(10 - - 10) + -10);
		velY = (r.nextInt(10 - - 10) + -10);
	
		
		this.handler = handler; 
		color = new Color (red, green, blue); 

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
		
		handler.addObject(new Trail(x,y, ID.Trail, handler, color, 0.08f, 16, 16));
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 16, 16);
		
	}

}
