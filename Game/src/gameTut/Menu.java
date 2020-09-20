package gameTut;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JOptionPane;

import gameTut.Game.STATE;

public class Menu extends MouseAdapter {
	

	private Game game;
	private Handler handler;
	private Random r = new Random();
	private HUD hud;
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		boolean answer = false;
		
		if (game.gameState == STATE.menu) {
			// play 
			if (mouseHover(mx,my, 210, 150, 200, 64)) {
				game.gameState = STATE.game;
				
				handler.clear();
				
				do {
				 	String choice = JOptionPane.showInputDialog("Wizard or Knight?");
				 	if (choice.equals("Wizard")) {
				 		handler.addObject(new Player(100,100, ID.Wizard, handler));
				 		answer = true;
				 	} else if (choice.equals("Knight")) {
				 		handler.addObject(new Player(100,100, ID.Knight, handler));
				 		answer = true;
				 	} else {
				 		System.out.println("Invalid Selection please enter a valid character!");
				 	}
				 } while (!answer);
				 handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			}
			
			// exit 
			if (game.gameState == STATE.menu && mouseHover(mx,my,210,350,200,64)) {
				System.exit(0);
			}
			
			// help
			
			if (mouseHover(mx,my,210,250,200,64)) {
				game.gameState = STATE.help;
			}
		}

		
		// back 
		if (game.gameState == STATE.help) {
			if (mouseHover(mx,my,190,350,200,64)) {
				game.gameState = STATE.menu;
				return;
			}
		}
		
		if (game.gameState == STATE.gameOver) {
			if (mouseHover(mx,my,190,350,200,64)) {
				handler.clear();
				game.gameState = STATE.menu;

				hud.setLevel(1);
				hud.score(0);
			}
		}
		
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseHover(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else {
				return false;
			} 
		} else {
			return false; 
		}
	}
	
	public void render(Graphics g) {
		if (game.gameState == STATE.menu) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt1 = new Font("arial", 1, 30);
			
		
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Dodge Run", 190, 70);
			g.setColor(Color.white);
			g.drawRect(210, 150, 200, 64);
			
			g.setFont(fnt1);
			g.drawString("Play", 280, 190);
			
			g.drawString("Help", 280, 290);
			g.drawString("Quit", 280, 390);
			

			
			g.setColor(Color.white);
			g.drawRect(210, 250, 200, 64);
			
			g.setColor(Color.white);
			g.drawRect(210, 350, 200, 64);
		} else if (game.gameState == STATE.help) {
			
			Font fnt = new Font("arial", 1, 50);
			Font fnt1 = new Font("arial", 1, 30);
			Font fnt2 = new Font("arial", 1, 25);
			
		
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 260, 70);
			
			g.setFont(fnt2);
			g.drawString("Use WASD and try your best to dodge enemies ;)", 30, 200);
			g.drawString("GOOD LUCK!", 240, 275);
			
			g.setFont(fnt1);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 280, 390);
			
		} else if (game.gameState == STATE.gameOver) {
			
			Font fnt = new Font("arial", 1, 50);
			Font fnt1 = new Font("arial", 1, 30);
			Font fnt2 = new Font("arial", 1, 25);
			
		
			g.setFont(fnt);
			g.setColor(Color.red);
			g.drawString("Game Over", 180, 70);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Final Score: " + hud.getScore(), 220, 200);
			g.drawString("Level: " + hud.getLevel(), 270, 240);
			g.drawString("Better luck next time!", 200, 275);
			
			g.setFont(fnt1);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again", 240, 390);

		}
		
		
	}
	
	public void tick() { 
		
	}

}
