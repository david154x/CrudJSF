package beans.dao;

import java.sql.SQLException;
import java.util.List;

import beans.model.Book;

public interface IBookDAO {
    public List<Book> select() throws SQLException;
    public Book selectForID(Book book) throws SQLException;
    public Book insert(Book book) throws SQLException;
    public void update(Book book)throws SQLException;
    public void delete(Book book)throws SQLException;
}
