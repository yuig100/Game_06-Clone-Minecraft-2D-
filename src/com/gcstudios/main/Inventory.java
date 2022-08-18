package com.gcstudios.main;

import java.awt.Color;
import java.awt.Graphics;

import com.gcstudios.world.Camera;
import com.gcstudios.world.FloorTile;
import com.gcstudios.world.Tile;
import com.gcstudios.world.WallTile;
import com.gcstudios.world.World;

public class Inventory {
	
	public int selected = 0;
	
	public boolean isPressed = false;
	public boolean isPlaceItem = false;
	
	public int mx,my;
	
	public static int inventoryBoxSize = 45;
	
	public String[] items = {"terra","madeira","pedra","areia","folha","ceu"};
	
	public int initialPosition = (Game.WIDTH * Game.SCALE) / 2 - (items.length * inventoryBoxSize) / 2;
	
	public void tick() {
		
		if(isPressed) {
			isPressed = false;
			if(mx >=initialPosition && mx < initialPosition + (inventoryBoxSize * items.length)) {
				
				if(my >= Game.HEIGHT * Game.SCALE - inventoryBoxSize && my <  Game.HEIGHT * Game.SCALE) {
					
					selected = (int)(mx - initialPosition) / inventoryBoxSize;
					
				}
				
			}
			
		}
		
		if(isPlaceItem) {
			
			isPlaceItem =false;
			
			mx = (int) mx / Game.SCALE + Camera.x;
			my = (int) my / Game.SCALE + Camera.y;
			
			int tilex = mx / World.TILE_SIZE;
			int tiley = my / World.TILE_SIZE;
			
			if(World.tiles[tilex + tiley * World.WIDTH].solid == false) {
	
				if(items[selected] == "terra") {
					
					World.tiles[tilex + tiley * World.WIDTH] =new WallTile(tilex*16,tiley*16,Tile.TILE_TERRA);
					
				} else if(items[selected] == "madeira") {
					
					World.tiles[tilex + tiley * World.WIDTH] =new WallTile(tilex*16,tiley*16,Tile.TILE_MADEIRA);
					
				} else if(items[selected] == "pedra") {
					
					World.tiles[tilex + tiley * World.WIDTH] =new WallTile(tilex*16,tiley*16,Tile.TILE_PEDRA);
					
				} else if(items[selected] == "areia") {
					
					World.tiles[tilex + tiley * World.WIDTH] =new WallTile(tilex*16,tiley*16,Tile.TILE_AREIA);
					
				} else if(items[selected] == "ceu") {
					
					World.tiles[tilex + tiley * World.WIDTH] =new FloorTile(tilex*16,tiley*16,Tile.TILE_CEU);
					
				} else if(items[selected] == "folha") {
					
					World.tiles[tilex + tiley * World.WIDTH] =new WallTile(tilex*16,tiley*16,Tile.TILE_FOLHA);
					
				} else if(items[selected] == "") {
					
					
					
				}
				
				if(World.isFree(Game.player.getX(), Game.player.getY()) == false) {
					
					World.tiles[tilex + tiley * World.WIDTH] =new FloorTile(tilex*16,tiley*16,Tile.TILE_CEU);
					
				}
				
			}
			
		}
		
	}
	
	public void render(Graphics g) {
		
		for(int i =0;i < items.length;i++) {
			
			g.setColor(Color.gray);
			g.fillRect(initialPosition + (i * inventoryBoxSize)+1, Game.HEIGHT * Game.SCALE - inventoryBoxSize+1, inventoryBoxSize, inventoryBoxSize);
			
			g.setColor(Color.black);
			g.drawRect(initialPosition + (i * inventoryBoxSize), Game.HEIGHT * Game.SCALE - inventoryBoxSize, inventoryBoxSize, inventoryBoxSize);
			
			if(items[i] == "terra") {
				
				g.drawImage(Tile.TILE_TERRA,initialPosition + (i * inventoryBoxSize) + 7, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32,32,null);
				
			} else if(items[i] == "areia") {
				
				g.drawImage(Tile.TILE_AREIA,initialPosition + (i * inventoryBoxSize) + 7, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32,32,null);
				
			} else if(items[i] == "carvao") {
				
				g.drawImage(Tile.TILE_CARVAO,initialPosition + (i * inventoryBoxSize) + 7, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32,32,null);
				
			} else if(items[i] == "folha") {
				
				g.drawImage(Tile.TILE_FOLHA,initialPosition + (i * inventoryBoxSize) + 7, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32,32,null);
				
			} else if(items[i] == "madeira") {
				
				g.drawImage(Tile.TILE_MADEIRA,initialPosition + (i * inventoryBoxSize) + 7, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32,32,null);
				
			} else if(items[i] == "pedra") {
				
				g.drawImage(Tile.TILE_PEDRA,initialPosition + (i * inventoryBoxSize) + 7, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32,32,null);
				
			}else if(items[i] == "ceu") {
				
				g.drawImage(Tile.TILE_CEU,initialPosition + (i * inventoryBoxSize) + 7, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32,32,null);
				
			}
			
			if(selected == i) {
				
				g.setColor(Color.red);
				g.drawRect(initialPosition + (i * inventoryBoxSize), Game.HEIGHT * Game.SCALE - inventoryBoxSize, inventoryBoxSize-1, inventoryBoxSize-1);
				
			}
		}
		
	}
	
}
