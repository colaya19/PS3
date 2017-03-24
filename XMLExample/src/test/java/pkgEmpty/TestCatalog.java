package pkgEmpty;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.BookException;
import pkgLibrary.Catalog;

public class TestCatalog {

	@Test(expected = BookException.class)
	public void testFailGetBook() throws BookException
	{
		Catalog cat = ReadXMLFile();
		cat.GetBook("bk001");
		
	}
	
	@Test
	public void passGetBook() throws BookException
	{
		Catalog cat = ReadXMLFile();
		assertTrue(cat.GetBook("bk101").getId().equals("bk101"));
		assertTrue(cat.GetBook("bk102").getId().equals("bk102"));
		
	}
	
	@Test
	public void passAddBook() throws BookException
	{
		Catalog cat = ReadXMLFile();
		Book b = new Book("Tester","Connor Olaya","My Test Book","Nonfiction",10.0,new Date(5000L),"This is book about mac and cheese",30.0);
		assertTrue(b.getId() == "Tester");
	}
	private static void WriteXMLFile(Catalog cat) {
		try {

			String basePath = new File("").getAbsolutePath();
			basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
			File file = new File(basePath);

			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(cat, file);
			jaxbMarshaller.marshal(cat, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static Catalog ReadXMLFile() {

		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;

	}
}
