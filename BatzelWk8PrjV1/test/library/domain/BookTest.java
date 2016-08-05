/*
 * Test cases for the Book class
 */
package library.domain;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Andrew
 * @version 1
 * Created 07/11/2015
 */
public class BookTest {
    
    public BookTest() {
    }
    
    /**
     * Test of equals method, of class Book.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        //Object obj = null;
        Object obj = new Book(Arrays.asList("Andrew", "Matthew", "Kelsie") , "1234567890");
        //Book instance = new Book();
        // first test for true
        Book instance = new Book(Arrays.asList("Matthew", "Andrew", "Kelsie"), "1234567890");
        boolean result = instance.equals(obj);
        assertEquals("expected true", true, result);
        // second test for false
        instance.setAuthors(Arrays.asList("Andrew", "Matthew", null));
        result = instance.equals(obj);
        assertEquals("expected false", false, result);
    }

    /**
     * Test of validate method, of class Book.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Book instance = new Book();
        boolean result = instance.validate();
        assertEquals(false, result);
        // first test for true
        instance.setAuthors(Arrays.asList("Andrew", "Matthew", "Kelsie"));
        instance.setIsbn("1234567890");
        result = instance.validate();
        assertEquals("expected true", true, result);
        // second test for false
        instance.setAuthors(Arrays.asList("Andrew", "Matthew", null));
        //instance.setIsbn(null);
        result = instance.validate();
        assertEquals("expected false", false, result);
    }   
}