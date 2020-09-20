package gameTut;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import gameTut.Game.STATE;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	private boolean[] keyDown = new boolean [4];
	
	Game game;

	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;
		
		// Could've used a for loop but this is just faster
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getID() == ID.Wizard) {
				if (key == KeyEvent.VK_W) {
					tempObject.setvelY(-handler.speed);
					keyDown[0] = true; 
				}
				if (key == KeyEvent.VK_A) {
					tempObject.setvelX(-handler.speed);
					keyDown[1] = true; 
				}
				if (key == KeyEvent.VK_S) {
					tempObject.setvelY(handler.speed);
					keyDown[2] = true; 
				}
				if (key == KeyEvent.VK_D) {
					tempObject.setvelX(handler.speed);
					keyDown[3] = true; 
				}
			}

			if (tempObject.getID() == ID.Knight) {
				if (key == KeyEvent.VK_W) {
					tempObject.setvelY(-3);
					keyDown[0] = true; 
				}
				if (key == KeyEvent.VK_A) {
					tempObject.setvelX(-3);
					keyDown[1] = true; 
				}
				if (key == KeyEvent.VK_S) {
					tempObject.setvelY(3);
					keyDown[2] = true; 
				}
				if (key == KeyEvent.VK_D) {
					tempObject.setvelX(3);
					keyDown[3] = true; 
				}
			}
		}
		
		if (key == KeyEvent.VK_P) {
			
			
			if (game.gameState == STATE.game) {
				
			}
			
			Game.pause = !Game.pause;
		}
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		} 
		if (key == KeyEvent.VK_SPACE) {
			if (game.gameState == STATE.game) {
				game.gameState = STATE.buy;
			} else if (game.gameState == STATE.buy) {
				game.gameState = STATE.game;
			}
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getID() == ID.Wizard) {
				if (key == KeyEvent.VK_W) {
					//tempObject.setvelY(0);
					keyDown[0] = false; 
				}
				if (key == KeyEvent.VK_A) {
					//tempObject.setvelX(0);
					keyDown[1] = false; 
				}
				if (key == KeyEvent.VK_S) {
					//tempObject.setvelY(0);
					keyDown[2] = false; 
				}
				if (key == KeyEvent.VK_D) {
					//tempObject.setvelX(0);
					keyDown[3] = false; 
				}
			
			if (tempObject.getID() == ID.Knight) {
				if (key == KeyEvent.VK_W) {
					tempObject.setvelY(0);
					keyDown[0] = false; 
				}
				if (key == KeyEvent.VK_A) {
					tempObject.setvelX(0);
					keyDown[1] = false; 
				}
				if (key == KeyEvent.VK_S) {
					tempObject.setvelY(0);
					keyDown[2] = false; 
				}
				if (key == KeyEvent.VK_D) {
					tempObject.setvelX(0);
					keyDown[3] = false; 
				}
			}
			
			// vertical movement 
			if (!keyDown[0] && !keyDown[2]) {
				tempObject.setvelY(0);
			}
			
			// horizontal movement
			if (!keyDown[1] && !keyDown[3]) {
				tempObject.setvelX(0);
			}

		}
	}
}
}
