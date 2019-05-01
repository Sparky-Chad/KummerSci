package main.projects.boxBug;

import info.gridworld.actor.Bug;

public class DancerBug extends Bug {

	//int for radius
	private int[] turner;
	int index;
	int step;
	
	public DancerBug(int[] turn) {
		this.turner = turn;
		index = 0;
		step = 0;
	}
	
	public void act() {
		
		if(index == turner.length) {
			index = 0;
		}
		else if(step < turner[index] && index % 2 == 0) {
			 turn();
			 step++;
		}
		else if(step < turner[index] && canMove()) {
			move();
			step++;
		}
		else if(!canMove()) {
			turn();
		}
		else {
			index++;
			step = 0;
		}
	}
}
