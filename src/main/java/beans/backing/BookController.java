package beans.backing;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import beans.dao.BookDaoImpl;
import beans.dao.IBookDAO;
import beans.model.Book;

@Named
@RequestScoped
public class BookController{

	IBookDAO bookJDBC;
	
	@Inject
	private Book book;
	
	private List<Book> listBooks;

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
	
	public void imprimirLista() {
		bookJDBC = new BookDaoImpl();
		try {
			listBooks = bookJDBC.select();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registrar() {
		IBookDAO bookJDBC = new BookDaoImpl();
		try {
			bookJDBC.insert(book);
			String msg = "Se ha insertado el nuevo libro correctamente";
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String componentId = null;//este es un mensaje global
            facesContext.addMessage(componentId, facesMessage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
