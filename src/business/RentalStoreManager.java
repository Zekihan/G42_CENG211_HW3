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
	
	private ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	private void rent(int customerNo, RentableItem item, String operationDate) {
		int discountPercentage = findCustById(getCustomers(), customerNo).getDiscountPercentge();
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
	
	
	
	private RentableItem findItemById(String itemType, int itemNo) {
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
	private Customer findCustById(ArrayList<Customer> customers, int id) {
		for (Customer cust: customers) {
			if (cust.getId() == id) {
				return cust;
			}
		}
		return null;
	}
	
	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}

	private int createItemId() {
		return 0;
	}
	
	private Date dateParser(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	

}
