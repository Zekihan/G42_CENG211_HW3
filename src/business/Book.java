package business;


public class Book extends RentableItem {

	private String author;
	private String publisher;
	
	public Book() {
		this("no name", -1, "no author", "no publisher");
	}
	
	public Book(String name, int itemNo, String author, String publisher) {
		super(name,itemNo);
		setAuthor(author);
		setPublisher(publisher);
	}

	@Override
	public void store(String format) {
		
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	private void setAuthor(String author) {
		this.author = author;
	}

	private void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
