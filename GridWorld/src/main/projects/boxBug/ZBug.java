package main.projects.boxBug;

import info.gridworld.actor.Bug;

public class ZBug extends Bug {

	//int for radius
	private int side;
	private int steps;
	private int runs;
	
	public ZBug(int radius) {
		this.side = radius;
		runs = 0;
		steps = 0;
		setDirection(90);
	}
	
	public void act() {
		if(runs < 3) {
			if (steps < side && canMove())
	        {
	            move();
	            steps++;
	        }
			else if(runs > 0) {
				setDirection(90);
				runs++;
				steps = 0;
			}
			else {
				turn();
				turn();
				turn();
				runs++;
				steps = 0;
			}
		}
	}
}
