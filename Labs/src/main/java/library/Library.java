package library;
//library database for storing all the needed books
//interface for library system

import java.util.ArrayList; 
//dynamic storage
import java.io.*;
//for file input and output
import java.util.Scanner;

public class Library {
    public ArrayList<Book> books;
    //store dynamically all books in the library
    public static final String path = "./library/data/index.txt";
    //path to book file storage
    public static final String ImageString = "./library/data/Image/";
    //constant path to images

    //constructor
    public Library() {
        books = new ArrayList<Book>();
        //input();
        //input available books
        books.add(new Book("Hunger Games", "Katniss", true));
        books.add(new Book("Harry Potter", "JK Rolling", false));
    }

    //file input
    public void input() {
        Scanner ifile;
        //try creating a path to the file and in the event of an exception display path not found
        try {
            ifile = new Scanner(new File(path));
            //search file
            int j = 0;
            //var for an internal index
            String str[] = new String[50];
            //temp save each var
            int o = 0;
            for(int i = 0; ifile.hasNext() && i < 50; i++) {
                str[i] = ifile.next();
                o = i;
            }
            for (int i = 0; i < o - 3; i += 3) {
                books.add(new Book(str[i], str[i+1], Boolean.parseBoolean(str[i+2])));
            }
            ifile.close();

        }  catch (IOException exception) {
            //some other exception
            System.out.println("Issue with input file");
        } 

    }   //end input loops
    //file output
    public void output() {
        try {   //try to open file
            FileWriter file = new FileWriter(path);
            PrintWriter ofile = new PrintWriter(file);
            for(int i = 0; i < books.size(); i++) {
                Book out = books.get(i);
                ofile.println(out.toString());
                //creating a temporary book and outputting its string
            }
            ofile.close();
        }  catch(IOException exception) {    //any other reason, helps to find any issue
            System.out.println("Issue with file writer****");
        } 
        
    }//end output
    public int findEqual(String in) {
        int out = -1;
        int o = 0;
        for(Book i: books) {
            if(in.equals(i.getName())&&i.getAv()) out = o;
        }
        return out;
    }
    
}//end library class