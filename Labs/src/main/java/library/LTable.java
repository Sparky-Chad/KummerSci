package library;

import javax.swing.*;
import java.awt.*;
//library panel
//Creates a table that will display book data and can add elements to it
public class LTable extends JPanel {
    private Color Background;
    //background color of the panel
    private Library dat;
    //library data this table will use for calculations
    private JTable table;
    //table for the class

    public LTable(Color in) {
        Background = in;
        setBackground(Background);
        dat = new Library();
        //makeing the table
        //instantiate dat object
        Object tableDat[][] = new Object[dat.books.size()][3];
        //object array to hold many types
        int i = 0;
        //array iterator for for loop
        for(Book it : dat.books) {
            //iterator each book object
            try {
                tableDat[i][0] = it.getName();
                tableDat[i][1] = it.getAuthor();
                tableDat[i][2] = it.getAv();
                //set table object data
                i++;
            } catch(ArrayIndexOutOfBoundsException exception) {
                System.out.print("table data array out of bounds*******");
                //catch array index exception to better debuging
            }
        }   //end array fill
        String labels[] = new String[] {"Book Name", "Author Name", "Is Available"};
        //headers for the table

        table = new JTable(tableDat, labels);
        //creation of table
        table.setPreferredScrollableViewportSize(new Dimension(500, 500) );
        table.setFillsViewportHeight(true);
        
        //create a scrollpanel
        JScrollPane pane = new JScrollPane(table);
        add(pane);
    }
}
