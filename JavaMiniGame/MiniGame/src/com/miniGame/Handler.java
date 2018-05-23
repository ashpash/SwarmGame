package com.miniGame;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler { // updates and renders all objects 
	
	LinkedList<GameObject> object = new LinkedList<GameObject>(); 
	
	public void tick() { 
		for(int i =0; i < object.size(); i++){
			GameObject tempObject = object.get(i); // id of object 
			tempObject.tick(); 
		}
	}
	
	public void render(Graphics g) { 
		for(int i = 0; i< object.size(); i++){ 
			GameObject tempObject = object.get(i); 
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){ 
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){ 
		this.object.remove(object);
	}

}
