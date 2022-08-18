package com.gcstudios.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Tile {
	
	public static BufferedImage TILE_TERRA = Game.spritesheet.getSprite(0,0,16,16);
	public static BufferedImage TILE_TERRA2 = Game.spritesheet.getSprite(0,16,16,16);
	public static BufferedImage TILE_CEU = Game.spritesheet.getSprite(0,96,16,16);
	public static BufferedImage TILE_TARDE = Game.spritesheet.getSprite(16,96,16,16);
	public static BufferedImage TILE_NOITE = Game.spritesheet.getSprite(32,96,16,16);
	public static BufferedImage TILE_AGUA = Game.spritesheet.getSprite(0,32,16,16);
	public static BufferedImage TILE_CARVAO = Game.spritesheet.getSprite(0,48,16,16);
	public static BufferedImage TILE_FOLHA = Game.spritesheet.getSprite(0,64,16,16);
	public static BufferedImage TILE_MADEIRA = Game.spritesheet.getSprite(0,80,16,16);
	public static BufferedImage TILE_AREIA = Game.spritesheet.getSprite(0,112,16,16);
	public static BufferedImage TILE_PEDRA = Game.spritesheet.getSprite(0,128,16,16);
	public static BufferedImage TILE_TERRA_NEVE = Game.spritesheet.getSprite(0,144,16,16);
	
	
	private BufferedImage sprite;
	protected int x,y;
	
	public boolean solid = false;
	
	public Tile(int x,int y,BufferedImage sprite){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void render(Graphics g){
		g.drawImage(sprite, x - Camera.x, y - Camera.y, null);
	}

}
