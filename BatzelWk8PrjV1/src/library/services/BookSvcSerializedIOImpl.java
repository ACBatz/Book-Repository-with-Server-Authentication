/*
 * Class Name:  BookSvcSerializedIOImpl
 * Description: This class serializes a book object into a file
 */
package library.services;
import java.io.*;
import library.domain.Book;

/**
 * @author Andrew
 * @version 1
 * Created 08/01/2015
 */
public class BookSvcSerializedIOImpl implements IBookSvc {
    public Book add(Book book) throws Exception {
        FileOutputStream fos = new FileOutputStream("Batzel_Book_File");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(book);
        oos.flush();
        oos.close();
        return book;
    }
}