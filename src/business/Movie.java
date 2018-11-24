package business;
import java.util.ArrayList;

public class Movie extends RentableItem {

	private String genre;
	private String producer;
	private ArrayList<String> actors;
	
	public Movie(String name, int itemNo, String genre, String producer, ArrayList<String> actors) {
		super(name, itemNo);
		setGenre(genre);
		setProducer(producer);
		setActors(actors);
	}
	
	@Override
	public void store(String format) {
		// TODO Auto-generated method stub
		
	}
	

	public String getGenre() {
		return genre;
	}

	public String getProducer() {
		return producer;
	}

	public ArrayList<String> getActors() {
		return actors;
	}

	private void setGenre(String genre) {
		this.genre = genre;
	}

	private void setProducer(String producer) {
		this.producer = producer;
	}

	private void setActors(ArrayList<String> actors) {
		this.actors = actors;
	}

	@Override
	public String getTextToSearchOn(String attribute) {
		String text = "";
		switch(attribute) {
			case "genre":
				text = getGenre();
				break;
			case "producer":
				text =  getProducer();
				break;
			case "name":
				text = getName();
				break;
			case "actor":
				for (String actor: getActors()) {
					text += actor + " ";
				}
				break;
			default:
				text = null;
				break;
		}
		return text;
	}
	
	

}
