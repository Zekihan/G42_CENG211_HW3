package business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RentalStoreManager {

	private ArrayList<Invoice> invoices;
	private ArrayList<RentableItem> bookStock;
	private ArrayList<RentableItem> movieStock;
	private ArrayList<Customer> customers;
	
	
	public RentalStoreManager() {
		invoices = new ArrayList<>();
		bookStock = new ArrayList<>();
		movieStock = new ArrayList<>();
		customers = new ArrayList<>();
	}
	
	public void addMovieItem(String name, String genre, String producer, ArrayList<String> actors) {
		RentableItem movieItem = new Movie(name, createItemId(), genre, producer, actors);
		movieStock.add(movieItem);
	}
	
	public void addBookItem(String name, String author, String publisher) {
		RentableItem bookItem = new Book(name, createItemId(), author, publisher);
		bookStock.add(bookItem);
	}
	
	public void rentItem(int customerNo, String itemType, int itemNo, String operationDay) {
		RentableItem item = findItemById(itemType, itemNo);
		if (item.isRented()) {
			System.out.println("Item already rented");
		}else {
			rent(customerNo, item, operationDay);
		}
	}
	
	public void returnItem(int customerNo, String itemType, int itemNo, String operationDay) {
		RentableItem item = findItemById(itemType, itemNo);
		if (!item.isRented()) {
			System.out.println("Item is not rented");
		}else {
			turnIn(customerNo, item, operationDay);
		}
	}
	
	public ArrayList<RentableItem> searchBooks(String searchText, String searchAtt){
		return search(bookStock, searchText, searchAtt);
	}
	public ArrayList<RentableItem> searchMovies(String searchText, String searchAtt){
		return search(movieStock, searchText, searchAtt);
	}
	public ArrayList<RentableItem> searchBooksVanced(String searchText1, String searchText2, String searchAtt1, String searchAtt2){
		return searchVanced(bookStock, searchText1, searchText2, searchAtt1, searchAtt2);
	}
	public ArrayList<RentableItem> searchMoviesVanced(String searchText1, String searchText2, String searchAtt1, String searchAtt2){
		return searchVanced(bookStock, searchText1, searchText2, searchAtt1, searchAtt2);
	}
	
	private ArrayList<RentableItem> search(ArrayList<RentableItem> items, String searchText, String searchAtt){
		ArrayList<RentableItem> result = new ArrayList<RentableItem>();
		for (RentableItem item: items) {
			if (item.getTextToSearchOn(searchAtt).equals(searchText)){
				result.add(item);
			}
		}		
		return result;
	}
	
	private ArrayList<RentableItem> searchVanced(ArrayList<RentableItem> items, String searchText1,
			String searchText2, String searchAtt1, String searchAtt2){
		ArrayList<RentableItem> result = new ArrayList<RentableItem>();
		for (RentableItem item: items) {
			if (item.getTextToSearchOn(searchAtt1).equals(searchText1) && item.getTextToSearchOn(searchAtt2).equals(searchText2)){
				result.add(item);
			}
		}		
		return result;
	}
	
	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}
	
	private ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	private void rent(int customerNo, RentableItem item, String operationDate) {
		int discountPercentage = findCustById( customerNo).getDiscountPercentge();
		Date date = dateParser(operationDate);
		double price = item.getPolicy().getPrice()*((100-discountPercentage)/100);
		Invoice invoice = new Invoice(date, item, price);
		invoices.add(invoice);
		item.rent();
	}
	
	private void turnIn(int customerNo, RentableItem item, String operationDate) {
		Date date = dateParser(operationDate);
		item.turnIn();
	}	
	
	public RentableItem findItemById(String itemType, int itemNo) {
		ArrayList<RentableItem> items;
		if(itemType.equals("book")) {
			items = bookStock;
		}else if(itemType.equals("movie")){
			items = movieStock;
		}else {
			throw new IllegalArgumentException("Invalid item type");
		}
		for (RentableItem item: items) {
			if (item.getItemNo() == itemNo) {
				return item;
			}		
		}
		return null;
	}
	
	public Customer findCustById(int id) {
		for (Customer cust: customers) {
			if (cust.getId() == id) {
				return cust;
			}
		}
		return null;
	}

	private int createItemId() {
		return 0;
	}
	
	private Date dateParser(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
