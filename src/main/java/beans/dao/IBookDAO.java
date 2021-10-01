package beans.dao;

import java.sql.SQLException;
import java.util.List;

import beans.model.Book;

public interface IBookDAO {
    public List<Book> select() throws SQLException;
    public int insert(Book book) throws SQLException;
    public int update(Book book)throws SQLException;
    public int delete(Book book)throws SQLException;
}
