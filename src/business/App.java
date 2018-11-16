package business;
import dataaccess.BookSaver;

public class App {

	public static void main(String[] args) {
		
		Book book = new Book("Moby Dick", 101, "Herman Melville", "Cambridge");
		BookSaver booksvjson = new BookSaver();
		booksvjson.saverJson(book);
		
		BookSaver bookSvXml = new BookSaver();
		bookSvXml.saverXml(book);

	}
	

}
