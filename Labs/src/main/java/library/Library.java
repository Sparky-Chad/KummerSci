package library;
//library database for storing all the needed books
//interface for library system

import java.util.ArrayList; 
//dynamic storage
import java.io.*;
//for file input and output
import java.util.Scanner;
import javax.swing.*;
//for possible use of creating small Jpanels for input

public class Library {
    public ArrayList<Book> books;
    //store dynamically all books in the library
    public static final String path = "./data/index.txt";
    //path to book file storage
    public static final String ImageString = "./data/Image/";
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
                    str[j] = ifile.nextLine();  //get number checked out
                    j = 0;
                    books.add(new Book(str[0], str[1], Boolean.getBoolean(str[2])));
                    //add the new book to the list
                } else {
                    System.out.println("Warning Input Loop passed bounds****");
                }

             }
        } catch (FileNotFoundException exception) {
            //file not found
            System.out.println("Warning Input File not Found*****");
        }   //end try and catch

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
        } catch(FileNotFoundException exception) {  //if the file isn't found
            System.out.println("outputfile not found****");
        } catch(IOException exception) {    //any other reason, helps to find any issue
            System.out.println("Issue with file writer****");
        } 
        
    }//end output

    
}//end library class