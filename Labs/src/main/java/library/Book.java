package library;

//book class for overall library class

public class Book {
    private String name;
    //store value of the name
    private String author;
    //author name storage
    private boolean avail;

    public Book() {
        name = "";
        author = "";
        avail = false;
    }   //default constructor
    public Book(String inName, String inAuthor, boolean inAv) {
        name = inName;
        author = inAuthor;
        avail = inAv;
    }   //fill constructor

    //Sets and gets
    
    public void setName(String in) {
        name = in;
    }
    public String getName() {
        return name;
    }
    public void setAuthor(String in) {
        author = in;
    }
    public String getAuthor() {
        return author;
    }
    public void setAv(boolean in) {
        avail = in;
    }
    public boolean getAv() {
        return avail;
    }

    //to string
    public String toString() {
        return String.format("%s\n%s\n%b", getName(), getAuthor(), getAv());
    }
}