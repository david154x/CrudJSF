package beans.model;

public class Book{
	
	private String isbn;
    private String author;
    private String title;
    private String category;
    private short year;

    public Book() {
    }
    
    public Book(String isbn) {
		super();
		this.isbn = isbn;
	}

	public Book(String isbn, String author, String title, String category, short year) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.category = category;
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
        return  "isbn: " + isbn +
                ", author: '" + author + '\'' +
                ", title: '" + title + '\'' +
                ", category: '" + category + '\'' +
                ", year: " + year;
    }
}