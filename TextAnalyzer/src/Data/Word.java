package Data;

public class Word {
	
	//Private word data of a string
	private String data;
	//TODO Make sure the scoring system accounts correctly for words like queue others
	public Word() {
		data = "";
	}
	public Word(String data) {
		this.data = data;
	}

	//sets and gets
	public void setWord(String in) {
		data = in;
	}
	public String getWord() {
		return data;
	}
	
	//count syllables inside of the word and return that number
	/*
	 * Converts the said word into an array of shorts which will then index the word
	 * 
	 * This index will allow for an easy check for whether or not the various vowels
	 * or constanants are there and will be very versatile
	 * 
	 * so: 0,0,1,1,0,0,2
	 * will be 1 syllable
	 * 
	 * 1: is a vowel
	 * 2: is an e
	 */
	
	public int getSyllable() {		
		//create an array of shorts which will help to keep data
		int[] count = new int[data.length()];
		
		if(dataMap.debug) System.out.println("DEBUG: word: " + data + " ***getSyllable begin");
		
		//for loop repeats through the string
		for(int i = 0; i < data.length(); i++) {
			
			if(dataMap.debug) System.out.println("***letter is: " + data.charAt(i));
			//if the index is a vowel then keep moving
			if(Util.ifVowel(data.charAt(i))) {
				//if for special circumstances
				//special case: dipthongs, two or more vowels
				if(dataMap.debug) System.out.println("letter is a vowel****");
				if(i > 0) {
					count[i] = 1;
					if(count[i-1] == 1) {
						if(dataMap.debug)System.out.println("a");
						if(Util.ifDipthong(data.substring(i-1, i+1))) {
							count[i-1] = 0;
							//set vowel before as not a countable one
						}
					}
				} //special case: e at end
				else if(i == data.length() - 1) {
					if(dataMap.debug)System.out.println("b");
					if(dataMap.debug) System.out.println("E at " + i + " length - 1: " + (data.length()-1));
					if(data.charAt(i) == 'e') {
						count[i] = 0;
						//e does not count
					}
				} //a vowel is one
			}
			//else then is a constant
			else {
				count[i] = 0;
			}
			
		}//for loop
		int out = 0;
		for(int i = 0; i < data.length(); i++) {
			//adds up out
			if(count[i] != 0) out++;
		}
		//debug output
		if(dataMap.debug) {
			System.out.print("Count: ["+count[0]);
			for(int i = 1; i < count.length; i++) {
				System.out.print("," + count[i]);
			}
			System.out.println("]******");
		}
		//return the syllable count
		if(dataMap.debug) System.out.println("***getSyllable end");
		if(out == 0) out = 1;
		return out;
	}
	

	
}
