package beans.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Book{
	
	private String id;
    private String author;
    private String title;
    private String category;
    private short year;

    public Book() {
    }

    public Book(String id) {
        this.id = id;
    }

    public Book(String id, String author, String title, String category, short year) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.category = category;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  "isbn: " + id +
                ", author: '" + author + '\'' +
                ", title: '" + title + '\'' +
                ", category: '" + category + '\'' +
                ", year: " + year;
    }
}