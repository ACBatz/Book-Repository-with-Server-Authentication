/*
 * Test case for adding book object into sql database
 */
package library.services;

import java.util.Arrays;
import library.domain.Book;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Andrew
 * @version 1
 * Created 08/08/2015
 */
public class BookSvcJDBImplTest {
    
    public BookSvcJDBImplTest() {
    }

    /**
     * Test of add method, of class BookSvcJDBImpl.
     * @throws java.lang.Exception
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Book book = new Book(Arrays.asList("Andrew Batzel", "Preston Batzel"), "0123456789");
        Factory factory = new Factory();
        IBookSvc bookSvc = (IBookSvc)factory.getService("IBookSvc");
        Book result = bookSvc.add(book);
        Book expResult = book;
        assertEquals(expResult, result);
    }   
}