package Data;

import java.util.Scanner;

public class tester extends recursive {

	public void run() {
		Scanner input = new Scanner(System.in);
		boolean keep = true;
		while(keep) {
			System.out.println("\n1 - Fibbinacci\n2 - Summation\n3 - Power\n4 - End program");
			int choice = input.nextInt();
			
			if(choice == 1) {
				System.out.println("Intervals: ");
				int out = input.nextInt();
				System.out.println("Recursively: " + this.recFibonacci(out));
				System.out.println("Iteratively: " + this.iterFib(out));	
			}
			else if(choice == 2) {
				System.out.println("Intervals: ");
				int out = input.nextInt();
				System.out.println("Recursively: " + this.recSummation(out));
				System.out.println("Iteratively: " + this.iterSum(out));
			}
			else if(choice == 3) {
				System.out.println("number: ");
				int out = input.nextInt();
				System.out.println("power: ");
				int pow = input.nextInt();
				System.out.println("Recursively: " + this.recExponent(out, pow));
				System.out.println("Iteratively: " + this.iterExponent(out, pow));
			}
			else if(choice == 4) {
				keep = false;
			}
		}
		input.close();
	}
	public static void main(String args[]) {
		tester test = new tester();
		test.run();
	}
}
