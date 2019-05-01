package main.projects.boxBug;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

public class CircleBugRunner{

	public static void main(String args[]) {
		ActorWorld world = new ActorWorld();
		world.setGrid(new UnboundedGrid<Actor>());
		CircleBug jane = new CircleBug(2);
		CircleBug art = new CircleBug(1);
		world.add(new Location(6,3), jane);
		world.add(new Location(6,4), art);
		world.show();
	}

}
