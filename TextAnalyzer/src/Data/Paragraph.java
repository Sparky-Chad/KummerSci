package Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//will handle all higher level tasks for the program such as getting the scores for all of the things
public class Paragraph {

	private ArrayList<Sentance> inner;
	
	public Paragraph() {
		inner = new ArrayList<Sentance>();
	}
	
	//fill constructor will work with either a string or with File
	public Paragraph(String in) {
		inner = new ArrayList<Sentance>();
		input(in);
		//uses the inputed string to create everything
	}
	
	//fill constructor for files
	public Paragraph(File in) {
		inner = new ArrayList<Sentance>();
		input(iFile(in));
	}
	//#TODO add in the code to count the words, syllables and prepare all of the stuff to be able to be input and output
	
	//#TODO add methods for input
	public void input(String in) {
		String sub = "";
		//a sub string that will be able to input into the sentance structure
		in = formatter(in);
		if(dataMap.debug) System.out.print("Begin Paragraph input\n");
		for(char modi: in.toCharArray()) {
			//for each character of the array continue this
			
			if(Util.isEndSen(modi)) {
				if(dataMap.debug) System.out.print("Sentance output: " + sub + "\n\n");
				//checks for an extra sentance
				inner.add(new Sentance(sub));
				sub = "";
				//reset the sub string

			}
			else {
				//add character to the array
				sub += Character.toString(modi);
				if(dataMap.debug) System.out.print("sub: " + modi + "\n");
			}
		}
	}
	
	//File input system
	public String iFile(File in) {
		String out = "";
		if(dataMap.debug) System.out.println("iFile Start");
		try {
			Scanner ifile = new Scanner(in);
			while(ifile.hasNextLine()) {
				if(dataMap.debug) System.out.println("iFile: in line");
				out += ifile.nextLine();
			}
			ifile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(dataMap.debug) System.out.println("iFile End");
		return out;
	}
	
	//formats the string for use with the paragraph
	public String formatter(String in) {
		return in.replaceAll("//r|//n|/n|/r", " ");
	}
	
	//Returns the syllable count for all variables inside of the paragraph
	public int getSyllable() {
		int out = 0;
		for(Sentance dat: inner) {
			out += dat.getSylCount();
		}
		return out;
	}
	
	public int totalSyl() {
		int out = 0;
		for(Sentance deci: inner) {
			out += deci.getSylCount();
		}
		return out;
	}
	public int totalWords() {
		int out = 0;
		for(Sentance deci: inner) {
			out += deci.getWordSize();
		}
		return out;
	}
	
	public double FleuschScore() {
		double out = 0;
		
		double WC = (double)totalWords();
		double SC = (double)totalSyl();
		double SenC = (double)inner.size();
		//functionality for the scoring system
		//put out the correct score for a given text
		out = 206.853-(84.6*(SC/WC) + 1.015*(WC/SenC));
		return out;
	}
	//Create file system
	/*
	 * TODO
	 * add in fleusch scoring system
	 * enable that system to output in numeral and string format
	 * ensure all methods work properly
	 */
}
