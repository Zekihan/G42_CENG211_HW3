package business;
import java.util.ArrayList;

import dataaccess.BookSaver;
import dataaccess.MovieSaver;

public class App {

	public static void main(String[] args) {
		
		Book book = new Book("Moby Dick", 101, "Herman Melville", "Cambridge");
		BookSaver bookSaver = new BookSaver();
		bookSaver.saverXml(book);
		
		bookSaver.saverManyJson(book);
		
		
		ArrayList<String> actors = new ArrayList<>();
		actors.add("Actor1");
		actors.add("Actor2");
		actors.add("Actor3");
		actors.add("Actor4");
		Movie movie = new Movie("Name",100,"Action","Producer",actors);
		MovieSaver movieSaver = new MovieSaver();

		movieSaver.saverXml(movie);

		movieSaver.saverManyJson(movie);
	}
	

}
