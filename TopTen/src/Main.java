import java.io.*;


public class Main {
	public static void main(String args[]) {
		String path = "/home/cjlonghorn/workspace/TopTen/src/dat.txt";
		TopTen cool = new TopTen();
		try {
		cool.iFile(path);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(cool.toString());
		Player temp = new Player(9, "bb");
		cool.add(temp);
		System.out.println("\nNew Player: \n" + temp.toString());
		System.out.println("Next: \n" + cool.toString());
		
	}
}
