package com.miniGame;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window  extends Canvas{

	private static final long serialVersionUID = 7130764501209713150L;

	public Window(int width, int height, String title, Game game) {
		
		JFrame frame = new JFrame(title);  // window frame 
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // how to exit game 
		frame.setResizable(false); // doesnt let you resize window 
		frame.setLocationRelativeTo(null); // start window in center of screen 
		frame.add(game); // add game class into frame 
		frame.setVisible(true); // let frame be visible 
		game.start(); // running start method 
	}	

}
