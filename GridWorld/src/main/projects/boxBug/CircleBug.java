package main.projects.boxBug;

import info.gridworld.actor.Bug;

public class CircleBug extends Bug {

	//int for radius
	private int side;
	private int steps;
	
	public CircleBug(int radius) {
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

            steps = 0;
        }
	}
}
