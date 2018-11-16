package business;
import dataaccess.BookSaverJson;
import dataaccess.BookSaverXml;

public class App {

	public static void main(String[] args) {
		
		Book book = new Book("Moby Dick", 101, "Herman Melville", "Cambridge");
		BookSaverJson booksvjson = new BookSaverJson();
		booksvjson.saverJson(book);
		
		BookSaverXml bookSvXml = new BookSaverXml();
		bookSvXml.save(book);

	}

}
