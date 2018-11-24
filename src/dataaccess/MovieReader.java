package dataaccess;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MovieReader {

	public void readerJson(int itemNo) {
		JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("Files/"+itemNo+".json"));

            JSONObject jsonObject = (JSONObject) obj;

            long id = (long) jsonObject.get("id");

            String name = (String) jsonObject.get("name");
            
            String author = (String) jsonObject.get("genre");

            String publisher = (String) jsonObject.get("producer");
            
            JSONArray actors = (JSONArray) jsonObject.get("actors");
            
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

        	FileReader newFile = new FileReader("Files/movies.json");
        	if(newFile.ready()) {
        		Object obj = parser.parse(newFile);

                JSONObject jsonObject = (JSONObject) obj;

                JSONArray books = (JSONArray) jsonObject.get("movies");
                
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
