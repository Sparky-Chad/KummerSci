package Data;

public abstract class recursive {
	
	/*
	 * recursive method
	 * private data 
	 * beg - where the method will start counting from
	 * rep - the number of times it repeats 
	 */
	public static int recFibonacci(int n) {
		if(n == 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		else {
			return recFibonacci(n-1) + recFibonacci(n-2);
		}
	}
	
	public static int iterFib(int n) {
		//use these vars to get it all to work
		int past = 0;
		int out = 1;
		for(int i = 1; i < n; i++) {
			//sum holds the next value
			int sum = past + out;
			
			//replace them
			past = out;
			out = sum;
		}
		return out;
	}
	
	public static int recSummation(int n) {
		if(n==0) {
			return 0;
		} else {
			return n + recSummation(n-1);
		}
	}
	
	public static int iterSum(int n) {
		int out = 0;
		for(int i = 0; i <= n; i++) {
			out += i;
		}
		return out;
	}
	
	public static int recExponent(int num, int power) {
		if(power > 0) {
			//num * num^power - 1
			return num * recExponent(num, power - 1);
		} else if(power == 1) {
			//num^1
			return num;
		}
		else {
			//num^0
			return 1;
		}
	}
	public static int iterExponent(int num, int power) {
		int out = num;
		if(power == 0) {
			return 0;
		} else if(power == 1) {
			return num;
		}
		else {
			for(int i = 1; i < power; i++) {
				out *= num;
			}
		}
		return out;
	}
	
}
