package pkgLibrary;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog extends Exception{

	@XmlAttribute
	int id;	
	
	@XmlElement(name="book")
	ArrayList<Book> books;
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) throws BookException {
		this.books = books;
	}
	
	public Book GetBook(String id) throws BookException
	{
		Book temp = null;
		try{
			for (Book b: books)
			{
				if(b.getId().equals(id))
				{
					temp = b;
				}
			}
			if (temp == null)
			{
				temp = new Book(id);
				throw new BookException(id);
			}
		}
		catch (Exception BookException){
			
			System.out.println("blah");
		}
		
		return temp;
	}
	public void AddBook(Book book) throws BookException
	{
		boolean in = false;
		
		for(Book b: books)
		{
			if(b.getId().equals(book.getId()))
			{
				in = true;
				throw new BookException(book);
				
			}
		}
		if(in == false)
		{
			books.add(book);
		}
	}
	
	
}
