package com.miniGame;

public class Spawn {
	
	private Handler handler ; 
	private HUDp1 hud; 
	
	private int scoreKeeper; 
	
	public Spawn(Handler handler, HUDp1 hud){
		this.handler = handler; 
		this.hud = hud; 
	}
	
	public void tick() {
		scoreKeeper ++;
		
		if(scoreKeeper >= 100) {
			scoreKeeper = 0; 
			hud.setlevel(hud.getlevel() + 1);
		}
		
		if(hud.getlevel() == 2){
			handler.addObject(new Sprite(Game.HEIGHT/2,Game.WIDTH/2,ID.Sprite,handler));
		}
	}

}
