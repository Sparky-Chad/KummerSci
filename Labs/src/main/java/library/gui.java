package library;

//set up gui with multiple windows for each of the different 
//things the class needs to do
import java.awt.*;  //for color and other
import javax.swing.*; //swing gui


public class gui {
    //main methods
    public static void main(String agrs[]) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Library Window");
        window.setSize(600, 600);
    }
}