package com.gcstudios.graficos;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.gcstudios.entities.Player;
import com.gcstudios.main.Game;
import com.gcstudios.world.World;

public class UI {
	
	
	public int seconds=0,minutes=0,frames=0;

	
	public void render(Graphics g) {
		
		for(int i =0;i < Game.player.life;i++) {
			
			
			g.drawImage(Game.spritesheet.getSprite(20, 20, 8, 8),20 + (i * 40), 20, 35, 35,null);
			
		}
		
		String formatTime ="";
		if(minutes < 10) {
			
			formatTime += "0" + minutes + ":";
			
		} else {
			
			formatTime += minutes + ":";
			
		}
		
		if(seconds < 10) {
			
			formatTime += "0" + seconds + ":";
			
		} else {
			
			formatTime += seconds + ":";
			
		}
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.BOLD,23));
		g.drawString(formatTime, 650, 20);
	}
	
	public void tick() {
		
		frames++;
		if(frames == 60) {
			
			frames = 0;
			seconds++;
			
			if(seconds == 60) {
				
				seconds=0;
				minutes++;
				
				if(minutes % 5 == 0) {
					
					World.CICLO++;
					
					if(World.CICLO > World.noite) {
						
						World.CICLO=0;
						
					}
				}
				
			}
						
		}
						
	}
	
}
