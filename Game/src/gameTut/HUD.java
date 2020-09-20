package gameTut;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public int bounds = 0;
	public static int baseHEALTH = 100;
	
	private int greenValue = 255; 
	
	private int score = 0;
	private static int level = 1;
	
	public void tick() {
		baseHEALTH = Game.clamp(baseHEALTH, 0, 100 + (bounds/2));
		greenValue = baseHEALTH * 2;
		greenValue = Game.clamp(greenValue, 0, 255);
		
	
		score++;
	}
	


	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200 + bounds, 32);
		g.setColor(new Color(75,greenValue,0));
		g.fillRect(15, 15, baseHEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15,15, 200 + bounds, 32);
		
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
		g.drawString("SPACE to BUY", 15, 94);
		g.drawString("P to PAUSE", 15, 110);
	}
	
	public void score(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score; 
	}
	
	public static int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level; 
	}
}
