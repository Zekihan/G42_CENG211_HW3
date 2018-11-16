package dataaccess;

import org.json.simple.JSONObject;

import business.Book;

import java.io.FileWriter;
import java.io.IOException;

public class BookSaver {

	@SuppressWarnings("unchecked")
	public void saver(Book book) {
		
		JSONObject books = new JSONObject();
		books.put("itemno", book.getItemNo());
		books.put("name", book.getName());
		books.put("author", book.getAuthor());
		books.put("publisher", book.getPublisher());
		
		try {

			FileWriter file = new FileWriter(book.getItemNo()+".json");
			file.write(books.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(books.toJSONString());
	}
}
