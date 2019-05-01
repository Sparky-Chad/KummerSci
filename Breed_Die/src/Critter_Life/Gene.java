package Critter_Life;

import java.awt.Color;
import java.util.ArrayList;

public class Gene {

	private static int TOTAL_GENE_POINTS = 20;
	
	/*
	 * Combat Factors
	 * These will create the factors for the dice rolls of combat.
	 * 
	 * attack - controls the ability to get hits on a critter
	 * 			the strength of which is determined by the number rolled
	 * health - controls the base number of hit-points a critter will have
	 * dodge - controls the ability for the critter to get out of the way of any attack
	 * defense - controls how able a critter is able to block an attack
	 */
	private int attack;
	private int health;
	private int dodge;
	private int defense;
	private int eat_pref;
	
	/*
	 * Physical Features
	 * Controlling physical factors which will decide critters ability to like other critters
	 * 
	 * majority will be based upon previous factors
	 * helps to decide how critters will mate and mating preference
	 */
	private Color color;
	private String species;
	private String hair;
	
	/*
	 * Genetic Code
	 * 
	 * Used for reproduction
	 * In reproduction, bugs will need simular genetic code to be able to reproduce
	 * will be repulsed due to physical differences
	 */
	private ArrayList<String> genecode;
	
	//Create new unique genepool
	public Gene() {
		rangen();
	}
	
	public Gene(Gene p1, Gene p2) {
		for(int i = 0; i < p1.getgenecode().length(); i++) {
			
		}
	}
	
}
