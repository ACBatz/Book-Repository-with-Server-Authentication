/*
 * Test case for business layer manager utilizing the services layer to serialize a book
 */
package library.business;

import java.util.Arrays;
import library.domain.Book;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Andrew
 * @version 1
 * Created 08/01/2015
 */
public class BookMgrTest {
    
    public BookMgrTest() {
    }
    
    /**
     * Test of addBook method, of class BookMgr.
     */
    @Test
    public void testAddBook() throws Exception {
        System.out.println("addBook");
        //Book book = null;
        Book book = new Book(Arrays.asList("Andrew", "Matthew", "Kelsie"), "0123456789");
        BookMgr instance = new BookMgr();
        Book result = instance.addBook(book);
        Book expResult = new Book(Arrays.asList("Andrew", "Matthew", "Kelsie"), "0123456789");
        // Test for true
        assertEquals(expResult, result);
    }
    
}