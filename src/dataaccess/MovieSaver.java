package dataaccess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import business.Book;
import business.Movie;

public class MovieSaver {

	@SuppressWarnings("unchecked")
	public void saverJson(Movie movie) {
		
		JSONObject movies = new JSONObject();
		
		movies.put("id", movie.getItemNo());
		movies.put("name", movie.getName());
		movies.put("genre", movie.getGenre());
		movies.put("producer", movie.getProducer());
		
		JSONArray actors = new JSONArray();
		
		for (String actor : movie.getActors()) {
			actors.add(actor);
		}
		
		movies.put("actors", actors);
		
		try {

			FileWriter file = new FileWriter("src/Files/"+movie.getItemNo()+".json");
			file.write(movies.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public void saverManyJson(Movie movie) {
		
		MovieReader reader = new MovieReader();
		JSONArray movies = reader.readerManyJson();
		if (movies == null) {
			movies = new JSONArray();
		}
		JSONObject movieJ = new JSONObject();
		
		movieJ.put("id", movie.getItemNo());
		movieJ.put("name", movie.getName());
		movieJ.put("genre", movie.getGenre());
		movieJ.put("producer", movie.getProducer());
		
		JSONArray actors = new JSONArray();
		
		for (String actor : movie.getActors()) {
			actors.add(actor);
		}
		movieJ.put("actors", actors);
		
		if(movies.size()!=0) {
			boolean flag = false;
			for (Object object : movies) {
				JSONObject obj = (JSONObject) object;
				if(!(obj.toJSONString().equals(movieJ.toJSONString()))) {
					flag = true;
					System.out.println("bb");
				}
			}
			if(flag) {
				movies.add(movieJ);
			}
		}else {
			movies.add(movieJ);
		}
		
		JSONObject filer = new JSONObject();
		filer.put("movies",movies);
		try {

			FileWriter file = new FileWriter("src/Files/movies.json");
			file.write(filer.toJSONString());;
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void saverXml(Movie movie) {
		try {
			
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

			Document document = documentBuilder.newDocument();

			Element root = document.createElement("item");
			document.appendChild(root);

			Element movieItem = document.createElement("movie");

			root.appendChild(movieItem);

			Attr attr = document.createAttribute("id");
			attr.setValue(movie.getItemNo() + "");
			movieItem.setAttributeNode(attr);

			Element name = document.createElement("name");
			name.appendChild(document.createTextNode(movie.getName()));
			movieItem.appendChild(name);

			Element genre = document.createElement("genre");
			genre.appendChild(document.createTextNode(movie.getGenre()));
			movieItem.appendChild(genre);

			Element producer = document.createElement("producer");
			producer.appendChild(document.createTextNode(movie.getProducer()));
			movieItem.appendChild(producer);
			
			Element actors = document.createElement("actors");
			actors.appendChild(document.createTextNode(movie.getActors().toString()));
			movieItem.appendChild(actors);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File("src/Files/"+movie.getItemNo() + ".xml"));

			transformer.transform(domSource, streamResult);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}
