/*
 * Class Name:  Book
 * Description: This class contains attributes normally found in a book such as authors and an isbn. The methods contain setters/getters, an override for the object's equals() method, and a validate method.
 */
package library.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrew
 * @version 4
 * Created  07/11/2015
 * Modified 07/18/2015 -> private variable authors to collection from string type
 * Modified 07/28/2015 -> added toString() override method
 * Modified 08/07/2015 -> added getAuthorsAsString() method to support multiple actors being added into a sql table
 */
public class Book implements Serializable {
    private List<String> authors = new ArrayList<String>();
    private String isbn;
    
    /**
     * Instance of Book with no parameters will initialize attributes to null.
     */
    public Book() {
        authors = null;
        isbn = null;
    }
    
    /**
     * Instance of Book with parameters will assign parameters to attributes.
     * @param authors List of Strings of the name of the authors.
     * @param isbn String of the isbn assigned to the book.
     */
    public Book(List<String> authors, String isbn) {
        this.authors = authors;
        this.isbn = isbn;
    }
    
    /**
     * Getter method for authors attribute.
     * @return List of Strings containing authors's name.
     */
    public List<String> getAuthors() {
        return authors;
    }
    
    public String getAuthorsAsString() {
        String authorsAsString = null;
        for (String str : authors)
        {
            if (authorsAsString ==  null)
            {
                authorsAsString = str;
            }
            else
            {
                authorsAsString += ", " + str;
            }
        }   
        return authorsAsString;
    }
    
    /**
     * Setter method for authors attribute.
     * @param authors 
     */
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    
    /**
     * Getter method for the isbn attribute.
     * @return String isbn number.
     */
    public String getIsbn() {
        return isbn;
    }
    
    /**
     * Setter method for the isbn attribute.
     * @param isbn String of the isbn number.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
     * Equals method tests the valid instance of a class
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if ( !(obj instanceof Book)) return false;
        Book b = (Book) obj;
        if ((! this.getAuthors().containsAll(b.getAuthors())) || (this.getAuthors().size() != b.getAuthors().size())) return false;  // can test for authors in unsorted list
        //if (! this.getAuthor().equals(b.getAuthor())) return false; // tests for single authors attribute
        if (! this.getIsbn().equals(b.getIsbn())) return false;
        return true;
    }
    
    /**
     * Validate method tests that valid Book attribute values.
     * @return 
     */
    public boolean validate() {
        if (authors == null) return false;
        else
        {
            for (String str : authors)
            {
                if (str == null || str.equals("") || str.equals(" ")) return false;
            }
        }
        if (isbn == null || isbn.equals("")) return false;
        return true;
    }
    
    /**
     * toString method override to display the state of the book
     * @return 
     */
    @Override
    public String toString() {
        return String.format("ISBN:" + isbn + " AUTHORS:" + authors);
    }
}