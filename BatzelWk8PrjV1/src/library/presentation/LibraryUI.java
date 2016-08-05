/*
 * Class Name:  LibraryUI
 * Description: This class is the user interface for the library application to add books
 */
package library.presentation;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import library.business.BookMgr;
import library.domain.Book;

/**
 * @author Andrew
 * @version 4
 * Created  07/25/2015
 * Modified 07/27/2015 -> add button returns the state of the book using the overridden toString() method
 * Modified 07/28/2015 -> add button only return the state of the book if valid
 * Modified 08/01/2015 -> add button functionality modified to display book valid and invalid entries
 */
public class LibraryUI extends JFrame {
    
    // Declaration of variables
    private JButton addBtn = new JButton("Add");
    private JButton resetBtn = new JButton("Reset");
    private JButton exitBtn = new JButton("Exit");
    private JTextField isbnField = new JTextField(15);
    private JLabel isbnLbl = new JLabel("ISBN: ");
    private JTextField authorField = new JTextField(20);
    private JLabel authorLbl= new JLabel("Authors: ");
    private JLabel authorLbl2 = new JLabel("Separate multiple authors with a comma");
    private List<String> authors = new ArrayList<String>();
    // End variable declaration
    
    public LibraryUI(String name) {
        // add main title to window
        super(name);
        // create main window
        Container container = getContentPane();
        GridBagLayout layout = new GridBagLayout();
        container.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        // setup window layout with buttons and text fields
        constraints.gridx = 1;
        constraints.gridy = 0;
        layout.setConstraints(isbnLbl, constraints);
        container.add(isbnLbl);
        constraints.gridx = 2;
        constraints.gridy = 0;
        layout.setConstraints(isbnField, constraints);
        container.add(isbnField);
        constraints.gridx = 1;
        constraints.gridy = 1;
        layout.setConstraints(authorLbl, constraints);
        container.add(authorLbl);
        constraints.gridx = 2;
        constraints.gridy = 1;
        layout.setConstraints(authorField, constraints);
        container.add(authorField);
        constraints.gridx = 3;
        constraints.gridy = 1;
        layout.setConstraints(authorLbl2, constraints);
        container.add(authorLbl2);
        constraints.gridx = 1;
        constraints.gridy = 2;
        layout.setConstraints(resetBtn, constraints);
        container.add(resetBtn);
        // event handler for reset button
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        constraints.gridx = 2;
        constraints.gridy = 2;
        layout.setConstraints(addBtn, constraints);
        container.add(addBtn);
        // event handler for add button
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { // added try catch
                try {
                    addBtnActionPerformed(evt);
                } catch (Exception ex) {
                    Logger.getLogger(LibraryUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        constraints.gridx = 3;
        constraints.gridy = 2;
        layout.setConstraints(exitBtn, constraints);
        container.add(exitBtn);
        // event handler for exit button
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    /**
     * Add button method takes string data from user and packages it into a Book object.
     * The string from the authors text field is split into an array an then a list.
     */ 
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        String str = authorField.getText();
        String[] parts = str.split(",");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        authors = Arrays.asList(parts);
        Book addBook = new Book(authors, isbnField.getText());
        if (addBook.validate()) {
            BookMgr bookMgr = new BookMgr();
            addBook = bookMgr.addBook(addBook);
            System.out.println(addBook.toString());
        }
        else
            System.out.println("Invalid book entry");
    }
     /**
     * Reset button method makes both text fields null.
     */
    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {
        isbnField.setText(null);
        authorField.setText(null);
    }
     /**
     * Exit button method performs a system call to close the window.
     */
    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    /**
     * Main opens a new interface.
     * @param args
     */
    public static void main(String args[]) {
        new LibraryUI("Add Book").setVisible(true);
    }    
}