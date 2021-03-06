package com.miniGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	
	private static final long serialVersionUID = 6403554345718387066L;

	public static final int WIDTH = 640;
	public static final int HEIGHT = (WIDTH/12 * 9);
	
	private Thread thread; // making game single threaded 
	private boolean running = false; 
	private Random r; 
	private Handler handler; 
	private HUDp1 hud;
	private HUDp2 hud2; 
	private Spawn spawn;

	public Game () { 
		
		handler = new Handler(); 
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "ASHLEY'S MINI GAME", this);	
		
		hud = new HUDp1(); 
		hud2 = new HUDp2();
		spawn = new Spawn(handler, hud);
		handler.addObject(new Player(WIDTH/2 + WIDTH/10,HEIGHT/2,ID.Player, handler));
		handler.addObject(new Player(WIDTH/2 - WIDTH/10,HEIGHT/2,ID.Player2, handler));
		r =  new Random(); 
		//populate Gremlins 		
		for (int x =0; x<1; x++) { 
			handler.addObject(new Gremlin(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.Gremlin, handler));
		}
	}
	
	public synchronized void start() { 
		thread = new Thread(this);
		thread.start();
		running = true; 
	}
	
	public synchronized void stop() { 
		try{ 
			thread.join(); 
			running = false; 			
		}catch(Exception e) { 
			e.printStackTrace(); 
		}
	}
	
	public void run() {   /// popular game loop 
		long lastTime = System.nanoTime(); 
		double amountOfTicks = 60.0; 
		double ns = 1000000000/ amountOfTicks; 
		double delta = 0; 
		long timer = System.currentTimeMillis(); 
		int frames = 0; 
		while(running) {
			long now = System.nanoTime(); 
			delta += (now - lastTime)/ns; 
			lastTime = now; 
			while(delta >= 1) {
				tick(); 
				delta --; 
			}
			if(running)
				render(); 
			frames++; 
			
			if(System.currentTimeMillis() - timer>1000){
				timer += 1000; 
				System.out.println("FPS: "+ frames);
				frames = 0; 
			}
		}
		stop(); 
	}
			
	private void tick () {
		handler.tick();
		hud.tick(); 
		hud2.tick();
		spawn.tick(); 
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) { 
			this.createBufferStrategy(3); // creates 3 buffers within game 
			return; 
		}
		
				
		Graphics g = bs.getDrawGraphics(); 
		
		g.setColor(Color.PINK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		
		hud.render(g);
		hud2.render(g);
		
		g.dispose();
		bs.show();
		
	}
	
	public static float clamp(float var, float min, float max) { 
		
		if ( var >=max ) 
			return var = max; 
		else if (var <= min)
			return var = min; 
		else 
			return var;
	}
	
	public static void main(String args []) {
		new Game(); 
	}

}
