package com.miniGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Sprite extends GameObject {
	
	private Handler handler;
	private GameObject player; 
	
	public Sprite(float x, float y, ID id, Handler handler) { 
		super(x,y,id);
		
		this.handler = handler; 
		
		for(int i =0; i<handler.object.size(); i++){
			if (handler.object.get(i).getID() == ID.Player) player = handler.object.get(i); 
		}
		
		
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}

	public void tick() {
		x += velX; 
		y += velY; 
		
		float diffX = x - player.getX() - 16; 
		float diffY = y - player.getY() - 16; 
		float dist = (float) Math.sqrt( ((x-player.getX())*(x-player.getX())) + ((y-player.getY())*(y-player.getY())) ); 
		
		velX = (int) ((-1/dist) * diffX); 
		velY = (int) ((-1/dist) * diffY);
		
		
		
		
	}


	public void render(Graphics g) {
		g.setColor(Color.CYAN); 
		g.fillRect((int)x, (int)y, 16, 16);
		
	}
	
}