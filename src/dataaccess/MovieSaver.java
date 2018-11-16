package dataaccess;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import business.Movie;

public class MovieSaver {

	@SuppressWarnings("unchecked")
	public void saverJson(Movie movie) {
		
		JSONObject movies = new JSONObject();
		
		movies.put("itemno", movie.getItemNo());
		movies.put("name", movie.getName());
		movies.put("genre", movie.getGenre());
		movies.put("producer", movie.getProducer());
		
		JSONArray actors = new JSONArray();
		
		for (String actor : movie.getActors()) {
			actors.add(actor);
		}
		
		movies.put("actors", actors);
		
		try {

			FileWriter file = new FileWriter(movie.getItemNo()+".json");
			file.write(movies.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
