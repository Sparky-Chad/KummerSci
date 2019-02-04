package Tester;

import java.util.Scanner;

import Data.*;

public class Tester {
	public static void main(String args[]) {
		Sentance words;
		boolean out = true;
		Scanner input = new Scanner(System.in);

		do {
			
			System.out.println("Enter 5 words with a . ending:");
			words = new Sentance(input.nextLine());
			
			System.out.println("Syllables: " + words.getSylCount() + "\nWords: " + words.getSize());
			
			
		} while(out);
		input.close();
	}
}
