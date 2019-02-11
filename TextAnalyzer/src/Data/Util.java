package Data;

public class Util {

	//generalized class for general methods many of the functions may have a need for
	
	//ifVowel will check whether or not the selected character will have a vowel inside
	public static boolean ifVowel(char in) {
		
		//convert in to lower case
		switch(Character.toLowerCase(in)) {
		//cases for each vowel
		case 'a': case 'e': case 'i': case 'o': case 'u': case 'y':
				return true;
		default:
				//if not a vowel
				return false;
		}
	}
	
	
	public static boolean ifDipthong(String in) {
		String[] dip = new String[] {"ea", "ay", "ou", "ie", "oi", "ee", "ai", "ue"};
		//list of dipthongs that can be used for the one syllable vowels
		in.toLowerCase();
		//set to lowercase for the later
		for(String test: dip) {
			//for each of them
			//check if the two vowells match up with it
			if(test.equals(in)) return true;
		}
//if the syllables don't work then return false
		return false;
	}
	
	public static boolean isEndSen(char in) {
		
		switch(in) {
		case '.': case '?': case '!': 
			return true;
		default:
			return false;
		}
	}
	
	public static boolean isChar(char in) {
		return Character.isLetter(in);
	}
	
	//Will convert a raw flesch score to a grade level
	protected static String ftoGrade(double fleschScore) {
		String gradeLevel = "";
		
		if(fleschScore >= 90 && fleschScore <= 100) {
			//5th grade level
			gradeLevel = "5th Grade";
		} else if(fleschScore >= 80 && fleschScore < 90) {
			//6th grade score level
			gradeLevel = "6th Grade";
		}
		else if(fleschScore >= 70 && fleschScore < 80) {
			//7th grade
			gradeLevel = "7th Grade";
		}
		else if(fleschScore >= 60 && fleschScore < 70) {
			//8th and 9ths
			gradeLevel = "8th/9th Grade";
		}
		else if(fleschScore >= 50 && fleschScore < 60) {
			//10th - 12th
			gradeLevel = "10th/11th/12th Grade";
		}
		else if(fleschScore >= 30 && fleschScore < 50) {
			//college
			gradeLevel = "College"; 
		}
		else if(fleschScore > 0 && fleschScore < 30) {
			gradeLevel = "College Graduate";
		}
		else {
			//some error somewhere and output such
			gradeLevel = "insane";
			if(dataMap.debug) System.out.println("Error in FleschScore");
		}
		return gradeLevel;
	}
}

