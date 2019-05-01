package Critter_Life;

import java.awt.Color;

import info.gridworld.actor.Critter;

public class Crit extends Critter{

	private int Life;

	public Crit() {
		super();
		Life = 20;
	}
	public void breed(Crit oParent) {
		Color nC = new Color((this.getColor().getRGB() + oParent.getColor().getRGB())/2);
		
		
	}
}
