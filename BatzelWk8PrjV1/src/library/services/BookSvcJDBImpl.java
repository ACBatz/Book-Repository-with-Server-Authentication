/*
 * Class Name:  BookSvcJDBImpl
 * Description: This class sets up a connection with a preset sql library and stores a book object into it's table
 */
package library.services;
import java.sql.*;
import library.domain.Book;

/**
 * @author Andrew
 * @version 1
 * Created 08/07/2015
 */
public class BookSvcJDBImpl implements IBookSvc {
    
    private String connString = "jdbc:mysql://localhost/batzellibrary?user=root&password=admin";
    
    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(connString);
    }
    
    /**
     * add method will create a connection and add a book object into a sql library
     * @param book
     * @return
     * @throws Exception
     */
    public Book add(Book book) throws Exception {
        Connection conn = getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO book (authors, isbn) VALUES ('" + book.getAuthorsAsString()+ "', '" + book.getIsbn() + "' )";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) conn.close();
        }
        return book;
    }
    
    /* Functions that may be implemented in furture assignments
    public Book find(String isbn) throws Exception {...}
    public Book update(Book book) throws Exception {...}
    public Book remove(Book book) throws Exception {...}
    */
}