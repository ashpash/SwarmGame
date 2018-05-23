package com.miniGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random() ; 
	Handler handler; 
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler; 
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}

	public void tick() {
		x+= velX; 
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		
		collision(); 
	}
	

	private void collision() { 
		for (int x = 0; x<handler.object.size() ; x ++){ 
			GameObject temp = handler.object.get(x); 
			
			if(temp.getID() == ID.Gremlin) {
				if(getBounds().intersects(temp.getBounds())){
					//collision'
					HUDp1.HEALTH --; 
				}
			}
		}
	}
	
	public void render(Graphics g) {
		if (id == ID.Player) {
			g.setColor(Color.BLUE);}
		else{
			g.setColor(Color.MAGENTA);
		}
		g.fillRect((int)x, (int)y, 32, 32);
	}

}
