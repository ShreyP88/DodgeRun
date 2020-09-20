package gameTut;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Buy extends MouseAdapter {
	
	Handler handler;
	HUD hud;
	
	private int hpCost = 1000;
	private int speedCost = 750;
	private int refillCost = 500;
	
	public Buy(Handler handler, HUD hud) {
		this.handler = handler; 
		this.hud = hud;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 0, 48));
		g.drawString("Welcome to the Shop", Game.WIDTH/2 - 225, 50);
		
		// HP
		g.setFont(new Font("Arial", 0, 12));
		g.drawString("Upgrade HP", 110, 120);
		g.drawString("Cost: " + hpCost, 110, 140);
		g.drawRect(100, 100, 100, 80);
		
		// Speed
		g.drawString("Upgrade Speed", 260, 120);
		g.drawString("Cost: " + speedCost, 260, 140);
		g.drawRect(250, 100, 100, 80);
		
		// Refill HP
		g.drawString("Refill HP", 410, 120);
		g.drawString("Cost: " + refillCost, 410, 140);
		g.drawRect(400, 100, 100, 80);
		
		g.drawString("Score: " + hud.getScore(), Game.WIDTH/2 - 50, 300);
		g.drawString("Space to GAME:", Game.WIDTH/2 - 60, 350);
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		// MORE HP
		if (mx >= 100 && mx <= 200) {
			if (my >= 100 && my <= 180) {
				if(hud.getScore() >= hpCost) {
					hud.score(hud.getScore() - hpCost);
					hpCost += 1000;
					hud.bounds += 20;
					hud.baseHEALTH = (100 + (hud.bounds/2));
				}
			}
		}
		// MORE SPEED
		if (mx >= 250 && mx <= 300) {
			if (my >= 100 && my <= 180) {
				hud.score(hud.getScore() - speedCost);
				speedCost += 750;
				handler.speed += 2;
			}
		}
		// REFILL
		if (mx >= 400 && mx <= 500) {
			if (my >= 100 && my <= 180) {
				hud.score(hud.getScore() - refillCost);
				hud.baseHEALTH = (100 + (hud.bounds/2));
				
			}
		}
	}
}
