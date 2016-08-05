/*
 * Class Name:  IBookSvc
 * Description: This is an interface to that captures what this service does without how the action is performed
 */
package library.services;

import library.domain.Book;

/**
 * @author Andrew
 * @version 1
 * Created 08/01/2015
 */
public interface IBookSvc extends IService {
    
    public Book add(Book book) throws Exception;
    
    /* the following methods are place holders for future implementation
    public Book find(String isbn) throws Exception;
    public Book update(Book book) throws Exception;
    public Book remove(Book book) throws Exception;
    */
}