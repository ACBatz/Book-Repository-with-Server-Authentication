/*
 * Class Name:  BookMgr
 * Description: This class manages the data sent from the presentation layer and utilizes the service layer to add a book object
 */
package library.business;

import library.domain.Book;
import library.services.*;


/**
 * @author Andrew
 * @version 3
 * Created  07/25/2015
 * Modified 07/27/2015 -> storeBook method stubbed out
 * Modified 08/07/2015 -> adhered to decoupled factory
 */
public class BookMgr {
     
    public Book addBook(Book book) throws Exception {
        Factory factory = new Factory();
        IBookSvc bookSvc = (IBookSvc)factory.getService("IBookSvc");
        return bookSvc.add(book);
    }
}