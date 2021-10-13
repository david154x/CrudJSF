package beans.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.model.Book;
import beans.util.Conexion;;

public class BookDaoImpl implements IBookDAO {
	
	private static final String SQL_SELECT = "SELECT isbn, author, title, category, year FROM classics";
	private static final String SQL_SELECTID = "SELECT isbn, author, title, category, year FROM classics WHERE isbn= ?";
    private static final String SQL_INSERT = "INSERT INTO classics (isbn, author, title, category, year) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE classics SET isbn= ?, author= ?, title= ?, category= ?, year= ? WHERE isbn= ?";
    private static final String SQL_DELETE = "DELETE FROM classics WHERE isbn= ?";
	
    @Override
    public List<Book> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Book> books = new ArrayList<>();
        Book book;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                String isbn = rs.getString("isbn");
                String author = rs.getString("author");
                String title = rs.getString("title");
                String category = rs.getString("category");
                Short year = rs.getShort("year");
                book = new Book(isbn, author, title, category, year);
                books.add(book);
            }
        }catch(SQLException Ex){
            Ex.printStackTrace(System.out);
        }finally{
            try{
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            }catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return books;
    }
    
    @Override
    public Book selectForID(Book book) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Book bookForId = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTID);
            stmt.setString(1, book.getIsbn());
            rs = stmt.executeQuery();
            while(rs.next()){
                String isbn = rs.getString("isbn");
                String author = rs.getString("author");
                String title = rs.getString("title");
                String category = rs.getString("category");
                Short year = rs.getShort("year");
                bookForId = new Book(isbn, author, title, category, year);
            }
        }catch(SQLException Ex){
            Ex.printStackTrace(System.out);
        }finally{
            try{
            	Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            }catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return bookForId;
    }

    @Override
    public Book insert(Book book) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int counter = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, book.getIsbn());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getTitle());
            stmt.setString(4, book.getCategory());
            stmt.setShort(5, book.getYear());
            counter = stmt.executeUpdate();
            System.out.println("You have inserted: "+book.getIsbn()+" "+book.getAuthor()+" "+book.getTitle());
            System.out.println("Rows affected: "+counter);
        }catch(SQLException Ex){
            Ex.printStackTrace(System.out);
        }finally{
            try{
                Conexion.close(stmt);
                Conexion.close(conn);
            }catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return book;
    }
    
    @Override
    public void update(Book book) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, book.getIsbn());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getTitle());
            stmt.setString(4, book.getCategory());
            stmt.setShort(5, book.getYear());
            stmt.setString(6, book.getIsbn());
            stmt.executeUpdate();
        }catch(SQLException Ex){
            Ex.printStackTrace(System.out);
        }finally{
            try{
                Conexion.close(stmt);
                Conexion.close(conn);
            }catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void delete(Book book) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, book.getIsbn());
            stmt.executeUpdate();
        }catch(SQLException Ex){
            Ex.printStackTrace(System.out);
        }finally{
            try{
                Conexion.close(stmt);
                Conexion.close(conn);
            }catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
    }
}
