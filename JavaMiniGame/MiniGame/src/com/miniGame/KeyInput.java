package com.miniGame;

import java.awt.event.KeyAdapter ;
import java.awt.event.KeyEvent; 


public class KeyInput extends KeyAdapter{
	
	private Handler handler; 
	private boolean[] keys = new boolean[4]; 
	private boolean[] keys2 = new boolean[4];
	public KeyInput(Handler handler){
		this.handler = handler;
		
		keys[0] = false; keys[1] = false;keys[2]=false;keys[3]=false;
		keys2[0] = false; keys2[1] = false;keys2[2]=false;keys2[3]=false;
	}
	
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode(); // gets key code of key pressed 
		
		for(int i =0; i<handler.object.size(); i ++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){
				
				// Movements Player 1
				if(key == KeyEvent.VK_W) {tempObject.setVelY(-5); keys[0]=true;}
				if(key == KeyEvent.VK_A) {tempObject.setVelX(-5); keys[2]=true;}
				if(key == KeyEvent.VK_S) {tempObject.setVelY(5); keys[1]=true;}
				if(key == KeyEvent.VK_D) {tempObject.setVelX(5); keys[3]=true;}
			}
			
			if(tempObject.getID() == ID.Player2){
				
				// Movements Player 2
				if(key == KeyEvent.VK_UP) {tempObject.setVelY(-5); keys2[0]=true;}
				if(key == KeyEvent.VK_LEFT) {tempObject.setVelX(-5); keys2[2]=true;}
				if(key == KeyEvent.VK_DOWN) {tempObject.setVelY(5); keys2[1]=true;}
				if(key == KeyEvent.VK_RIGHT) {tempObject.setVelX(5); keys2[3]=true;}
			}
		}
		
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i =0; i<handler.object.size(); i ++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){
				if(key == KeyEvent.VK_W) keys[0]=false;
				if(key == KeyEvent.VK_A) keys[2]=false;
				if(key == KeyEvent.VK_S) keys[1]=false;
				if(key == KeyEvent.VK_D) keys[3]=false;
				
				if(!keys[0]&&!keys[1]) tempObject.setVelY(0);
				if(!keys[2]&&!keys[3]) tempObject.setVelX(0);
			}
			
			if(tempObject.getID() == ID.Player2){
				if(key == KeyEvent.VK_UP) keys2[0]=false;
				if(key == KeyEvent.VK_LEFT) keys2[2]=false;
				if(key == KeyEvent.VK_DOWN) keys2[1]=false;
				if(key == KeyEvent.VK_RIGHT) keys2[3]=false;
				
				if(!keys2[0]&&!keys2[1]) tempObject.setVelY(0);
				if(!keys2[2]&&!keys2[3]) tempObject.setVelX(0);
			}
		}
	}

}
