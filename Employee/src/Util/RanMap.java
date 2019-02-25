package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RanMap {
	public static String FILE_HOME = "C:\\Users\\lapec\\OneDrive\\Desktop\\workspace\\KummerSci\\Employee\\bin\\fulldat\\";
	
	private ArrayList<String> names;
	public RanMap() {
		names = new ArrayList<String>();
		inputFile();
	}
	
	public void inputFile() {
		File ifile = new File(RanMap.FILE_HOME + "LastNames.txt");
		
		if(ifile.exists()) {
			try {
				Scanner input = new Scanner(ifile);
				while(input.hasNext()) {
					String temp = input.nextLine();
					names.add(temp);
				}
				input.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String getName() {
		return getName((int)(Math.random() * names.size()));
	}
	
	public String getName(int i) {
		return names.get(i);
	}
}
