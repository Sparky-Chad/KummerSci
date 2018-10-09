package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//library panel
//Creates a table that will display book data and can add elements to it
public class LTable extends JPanel implements ActionListener {
    private Color Background;
    //background color of the panel
    private Library dat;
    //library data this table will use for calculations
    private Patreon per;
    private JTable table;
    //table for the class
    private JButton addBook, reBook,  borrowBook;
    //buttons to help control whether to add a book, return a book, or borrow a book

    public LTable(Color in) {
        Background = in;
        setBackground(Background);
        dat = new Library();
        per = new Patreon();
        //makeing the table
        //instantiate dat object
        Object tableDat[][] = new Object[dat.books.size()][3];
        //object array to hold many types
        int i = 0;
        //array iterator for for loop
        for(Book it : dat.books) {
            //iterator each book object
            try {
                JCheckBox availout = new JCheckBox("", it.getAv());
                availout.setEnabled(false);
                tableDat[i][0] = it.getName();
                tableDat[i][1] = it.getAuthor();
                tableDat[i][2] = availout;
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

        //Initialization of data
        addBook = new JButton("Add a Book");
        addBook.setToolTipText("Add a book to the table");
        addBook.setActionCommand("Add");
        addBook.addActionListener(this);
        //add a book initialization 
        reBook = new JButton("Return Book");
        reBook.setToolTipText("Return book to library");
        reBook.setActionCommand("Return");
        reBook.addActionListener(this);
        //return book initialization
        borrowBook = new JButton("Borrow Book");
        borrowBook.setToolTipText("Borrow Book from library");
        borrowBook.setActionCommand("Return");       
        borrowBook.addActionListener(this);
        //create a scrollpanel
        JScrollPane pane = new JScrollPane(table);
        setLayout(new FlowLayout());
        add(addBook);
        add(reBook);
        add(borrowBook);
        add(pane);
    }

    public void actionPerformed(ActionEvent e) {
        if("Add".equals(e.getActionCommand())) {
            String name = JOptionPane.showInputDialog("Name of book", "Some nerdy book");
            String author = JOptionPane.showInputDialog("Author of book", "some author");
            dat.books.add(new Book(name, author, true));
        } else if("Borrow".equals(e.getActionCommand())) {
            String name = JOptionPane.showInputDialog("Name of book to borrow");
            int go = dat.findEqual(name);
            if((go != -1) && (per.findEqual(name) == -1)) {
                per.name.add(name);
                Book temp = dat.books.get(go);
                temp.setAv(false);
                dat.books.set(go, temp);
            }
        } else if("Return".equals(e.getActionCommand())) {
            String name = JOptionPane.showInputDialog("Book to return");
            int go = per.findEqual(name);
            int no = dat.findEqual(name);
            if((go != -1) && (no == -1)){
                per.name.remove(go);
            }
        }
        //makeing the table
        //instantiate dat object
        Object tableDat[][] = new Object[dat.books.size()][3];
        //object array to hold many types
        int i = 0;
        //array iterator for for loop
        for(Book it : dat.books) {
            //iterator each book object
            try {
                JCheckBox availout = new JCheckBox("", it.getAv());
                availout.setEnabled(false);
                tableDat[i][0] = it.getName();
                tableDat[i][1] = it.getAuthor();
                tableDat[i][2] = availout;
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
        repaint();
    }

}
