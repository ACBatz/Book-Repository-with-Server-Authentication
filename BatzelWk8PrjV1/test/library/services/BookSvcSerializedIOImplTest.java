/*
 * Test case for serializing a book object
 */
package library.services;

import java.util.Arrays;
import library.domain.Book;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Andrew
 * @version 1
 * Created 08/01/2015
 */
public class BookSvcSerializedIOImplTest {
    
    public BookSvcSerializedIOImplTest() {
    }
    /**
     * Test of add method, of class BookSvcSerializedIOImpl.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        //Book book = null;
        Book book = new Book(Arrays.asList("Andrew", "Matthew", "Kelsie"), "0123456789");
        Factory factory = new Factory();
        IBookSvc bookSvc = (IBookSvc)factory.getService("IBookSvc");
        Book result = bookSvc.add(book);
        //BookSvcSerializedIOImpl instance = new BookSvcSerializedIOImpl();
        Book expResult = new Book(Arrays.asList("Andrew", "Matthew", "Kelsie"), "0123456789");
        //Test for true
        assertEquals(expResult, result);
    }   
}