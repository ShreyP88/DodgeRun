package gameTut;

import javax.swing.*;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.Scanner;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	private boolean running = false;

	private Random r = new Random();
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Buy buy;
	
	public static boolean pause = false;


	public enum STATE {
		menu, game, help, gameOver, select, buy;
	}

	public static STATE gameState = STATE.menu;

	public Game() {
		handler = new Handler();
		hud = new HUD();
		buy = new Buy(handler, hud);
		menu = new Menu(this, handler, hud);

		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		this.addMouseListener(buy);

		// AudioPlayer.load();
		// AudioPlayer.getMusic("music").loop();


		new Window(WIDTH, HEIGHT, "DODGE RUN", this);
		spawner = new Spawn(handler, hud);

		if (gameState == STATE.game) {
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
		} else {
			for (int i = 0; i < 20; i++) {
				handler.addObject(
						new menuEffects(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.menuEffect, handler));
			}
		}


	}


	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
				frames++;
			}

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);


		if (pause) {
			g.setColor(Color.white);
			g.drawString("PAUSED", 290, 225);
		}

		if (gameState == STATE.game) {
			hud.render(g);
			handler.render(g);
		} else if (gameState == STATE.menu || gameState == STATE.help || gameState == STATE.gameOver || gameState == STATE.select) {
			menu.render(g);
			handler.render(g);
		} else if (gameState == STATE.buy) {
			buy.render(g);
		}

		g.dispose();
		bs.show();
	}

	private void tick() {

		if (gameState == STATE.game) {
			if (!pause) {
				handler.tick();
				hud.tick();
				spawner.tick();
				// Audio.playGameSound();
				if (HUD.baseHEALTH <= 0) {
					HUD.baseHEALTH = 100;
					gameState = STATE.gameOver;
					handler.clear();
					for (int i = 0; i < 20; i++) {
						handler.addObject(
								new menuEffects(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.menuEffect, handler));
					}
				}
			}
		} else if (gameState == STATE.menu || gameState == STATE.help || gameState == STATE.gameOver || gameState == STATE.select) {
			handler.tick();
			menu.tick();
			// Audio.playMenuSound();
		}

	}

	public static int clamp(int var, int min, int max) {
		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		}
		return var;
	}

	public static void main(String[] args) {
		new Game();

	}

	public void setGameState(STATE x) {
		this.gameState = x;

	}

	public void setGameState1(STATE menu2) {
		// TODO Auto-generated method stub

	}

}
