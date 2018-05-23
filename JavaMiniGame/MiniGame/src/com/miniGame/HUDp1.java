package com.miniGame;

import java.awt.Color;
import java.awt.Graphics;

public class HUDp1 {
	
	public static float HEALTH = 100; 
	private int green = 255; 
	private float max = HEALTH; 
	private int score; 
	private int level; 
	
	public void tick() { 
		
		
		HEALTH = Game.clamp(HEALTH, 0, 100);
		if (HEALTH > max/4 && HEALTH < max/2) green = 100; 
		if (HEALTH < max/4) green = 0; 
		
		score++; 
	}
	
	public void render(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(10, 15, 200, 32);
		g.setColor(new Color(75, green, 0));
		g.fillRect(10, 15, (int)HEALTH * 2, 32);
		g.setColor(Color.WHITE);
		g.drawRect(10, 15, 200, 32);
		
		g.drawString("Score: "+score, 10,  64);
		g.drawString("Level: "+level, 10, 78);
	}
	
	public void setscore(int score){
		this.score = score; 
	}
	
	public int getscore(){
		return score; 
	}
	
	public void setlevel (int level){
		this.level = level; 
	}
	
	public int getlevel() {
		return level; 
	}

}
