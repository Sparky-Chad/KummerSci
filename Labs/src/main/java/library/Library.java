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
        input();
        //input available books
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
            String str[] = new String[3];
            //temp save each var
            while(ifile.hasNext()) {
                //check internal index for what should occur
                if(j == 0) {
                    str[j] = ifile.nextLine();  //first iteration store name
                    j++;
                } else if (j == 1) {
                    str[j] = ifile.nextLine();  //second iterator get image name
                    j++;
                } else if(j == 2) {
                    str[j] = ifile.nextLine();
                    j = 0;
                    boolean out = Boolean.parseBoolean(str[2]);
                    books.add(new Book(str[0], str[1], out));
                    //add the new book to the list
                    System.out.println(str[0] + " " + str[1] + " " + str[2]);
                } else {
                    System.out.println("Warning Input Loop passed bounds****");
                }

             }
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

    
}//end library class