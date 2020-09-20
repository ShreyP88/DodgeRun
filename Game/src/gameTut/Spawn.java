package gameTut;
import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random r = new Random();
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scoreKeep++;
		
		if (scoreKeep >= 500) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if (hud.getLevel() % 2 == 0 && hud.getLevel() > 1) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			} 
			
			if (hud.getLevel() % 2 != 0 && hud.getLevel() > 2) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
				
			}
			
			if (hud.getLevel() > 2 && hud.getLevel() % 3 == 0) {
				handler.addObject(new Boss(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.Boss, handler));
			}
			
			if (hud.getLevel() == 5) {
				handler.addObject(new SmartBoss(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartBoss, handler));
			}
			
			if (hud.getLevel() == 10) {
				handler.clear();
				handler.addObject(new RealBoss((Game.WIDTH / 2) - 48, -60, ID.RealBoss, handler));
				
			}
			
		}
	}

}
