package Util;

import java.util.Scanner;

import data.*;
public class gui {
	
	private Company com;
	
	public gui() {
		init();
	}
	
	public void init() {
		com = new Company();
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		boolean keep = true;
		while(keep) {
			System.out.println("Total employees: " + com.size() + "\n1 - Search Employee\n2 - Search By Number\n3 - Ouput all employees\n4 - End program");
			int choice = input.nextInt();
			
			if(choice == 1) {
				System.out.print("Enter name to search for: ");
				
				System.out.println(com.search(input.next()));
			}
			else if(choice == 2) {
				System.out.print("Enter employee number: ");
				int tchoice = input.nextInt();
				System.out.println(com.get(tchoice));
			}
			else if(choice == 3) {
				System.out.println(com.toString());
			}
			else if(choice == 4) {
				keep = false;
			}
		}
		input.close();
	}
	public static void main(String args[]) {
		gui g = new gui();
		g.run();
	}

}
