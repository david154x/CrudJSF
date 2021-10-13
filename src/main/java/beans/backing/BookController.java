package beans.backing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import beans.dao.BookDaoImpl;
import beans.dao.IBookDAO;
import beans.model.Book;

@Named
@ApplicationScoped
public class BookController{

	IBookDAO bookJDBC;
	
	@Inject
	private Book book;
	
	private List<Book> listBooks = new ArrayList<Book>();;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Book> getListBooks() {
		return listBooks;
	}

	public void setListBooks(List<Book> listBooks) {
		this.listBooks = listBooks;
	}
	
	/*
	@PostConstruct
	public void init() {
		listBooks = new ArrayList<Book>();
		bookJDBC = new BookDaoImpl();
		try {
			listBooks = bookJDBC.select();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
	}
	*/
	
	public void registrar() {
		IBookDAO bookJDBC = new BookDaoImpl();
		try {
			bookJDBC.insert(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void imprimirLista() {
		bookJDBC = new BookDaoImpl();
		try {
			listBooks = bookJDBC.select();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void leerId(Book book) {
		bookJDBC = new BookDaoImpl();
		Book bookTemp;
		try {
			bookTemp = bookJDBC.selectForID(book);
			if(bookTemp != null) {
				this.book = bookTemp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificar() {
		IBookDAO bookJDBC = new BookDaoImpl();
		try {
			bookJDBC.update(book);
			this.imprimirLista();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminar(Book book) {
		IBookDAO bookJDBC = new BookDaoImpl();
		try {
			bookJDBC.delete(book);
			this.imprimirLista();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
