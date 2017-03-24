package pkgLibrary;

public class BookException extends Throwable{
	private Book book;
	private String id;
	
	public BookException(Book b)
	{
		this.book = b;
	}
	public BookException(String ID)
	{
		this.id = ID; 
	}
	public Book getBook() {
		return book;
	}
	public String getID(){
		return id;
	}
}
