package gameTut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BossTime extends GameObject{
	

		public BossTime(int x, int y, ID id) {
			super(x, y, id);
			
			velX = 0;
			velY = 0;
		}
		
		public Rectangle getBounds() {
			return new Rectangle(x,y,64,64);
		}
		

		public void tick() {
			x += velX;
			y += velY;
			
		
			
		}

		public void render(Graphics g) {
			g.setColor(Color.CYAN);
			g.fillRect(x, y, 100, 100);
			
		}

	}


