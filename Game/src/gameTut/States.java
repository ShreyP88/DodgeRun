package gameTut;
import gameTut.Game.STATE;

public class States {
	public enum STATE {
		menu, 
		game;
	};
	
	public STATE gameState = STATE.menu;
}
