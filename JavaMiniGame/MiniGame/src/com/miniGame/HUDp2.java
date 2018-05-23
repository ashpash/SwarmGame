package com.miniGame;

import java.awt.Color;
import java.awt.Graphics;

public class HUDp2 {
	
public static float HEALTH = 100; 
	
	public void tick() { 
		
		HEALTH -- ; 
		HEALTH = Game.clamp(HEALTH, 0, 100);
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(Game.WIDTH - 215, 15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(Game.WIDTH - 215, 15, (int)HEALTH * 2, 32);
		g.setColor(Color.WHITE);
		g.drawRect(Game.WIDTH - 215, 15, 200, 32);
	}

}