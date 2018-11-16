package business;
import dataaccess.BookSaverJson;

public class App {

	public static void main(String[] args) {
		
		Book book = new Book("Moby Dick", 101, "Herman Melville", "Cambridge");
		BookSaverJson booksv = new BookSaverJson();
		booksv.saverJson(book);

	}

}
