package com.gcstudios.main;

import com.gcstudios.entities.Enemy;
import com.gcstudios.entities.Entity;

public class EnemySpawn {
	
	public int interval = 60 * 10;
	public int curTime =0;
	
	public void tick() {
		
		curTime++;
		if(curTime == interval) {
			 curTime = 0;
			
			 Enemy enemy = new Enemy(16,16,16,16,1,Entity.ENEMY_SPRITE[0],Entity.ENEMY_SPRITE[1]);
			 Game.entities.add(enemy);
			
		}
		
	}
	
}
