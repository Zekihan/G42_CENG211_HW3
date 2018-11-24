package dataaccess;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BookReader {

	
	public void readerJson(int itemNo) {
		JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("src/Files/"+itemNo+".json"));

            JSONObject jsonObject = (JSONObject) obj;

            long id = (long) jsonObject.get("id");

            String name = (String) jsonObject.get("name");
            
            String author = (String) jsonObject.get("author");

            String publisher = (String) jsonObject.get("publisher");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

	public JSONArray readerManyJson() {
		
		JSONParser parser = new JSONParser();

        try {

        	FileReader newFile = new FileReader("src/Files/books.json");
        	if(newFile.ready()) {
        		Object obj = parser.parse(newFile);

                JSONObject jsonObject = (JSONObject) obj;

                JSONArray books = (JSONArray) jsonObject.get("books");
                
                return books;
        	}
        	newFile.close();
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
			e.printStackTrace();
		}
        return null;	
	}
}
