package main.projects.boxBug;

import info.gridworld.actor.Bug;

public class SpiralBug extends Bug {

	//int for radius
	private int side;
	private int steps;
	private int outer;
	
	public SpiralBug(int radius) {
		this.side = radius;
		steps = 0;
	}
	
	public void act() {
		if (steps < side && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            if(outer %2 == 0) {
            	side++;
            }
            outer++;
            steps = 0;
        }
	}
}
