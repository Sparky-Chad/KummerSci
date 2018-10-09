package library;
//controls a lot of the data for who owns what books and that stuff
import java.util.ArrayList;

public class Patreon {
    public ArrayList<String> name; 
    //private data for the name of the book stored
    private String fileName;
    //private data to store name of patreons file
    public static final String path = "./library/data/";
    //path to where patreon data is stored
    public Patreon(String fileName) {
        //Constructor with fileName
    }

    public Patreon() {
        name = new ArrayList<String>();
    }

    public int findEqual(String in) {
        int out = -1;
        int o = 0;
        for(String i: name) {
            if(i.equals(in)) out = o;
        }
        return out;
    }
}