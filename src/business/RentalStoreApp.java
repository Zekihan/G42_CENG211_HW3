package business;

import java.util.Scanner;

public class RentalStoreApp {
	private RentalStoreManager mngr;
	private Scanner keyboard;
	
	public RentalStoreApp() {
		mngr = new RentalStoreManager();
		keyboard = new Scanner(System.in);
	}

	public void start() {

		System.out.println("Welcome to the Book & Movie Rent Application" + System.lineSeparator());
		
		System.out.println("Menu:" + System.lineSeparator() + 
				"1) Rent Operation" + System.lineSeparator() +
				"2) Return Operation" + System.lineSeparator() + 
				"3) Search Item " + System.lineSeparator() + 
				"4) Change Rent Policy of an Item" + System.lineSeparator() + 
				"5) Change a Customers type " + System.lineSeparator() + 
				"6) Invoice amount for a day" + System.lineSeparator() + 	
				"7) Add item to the stock"+ System.lineSeparator() + 
				"8) Remove item from stock"+ System.lineSeparator() + 
				"9) Exit " + System.lineSeparator());
		
		int a = keyboard.nextInt();
		switch(a){
			case 1: rentOp();
					break;
			case 2: returnOp();
					break;
			case 3: searchOp();
					break;
			case 4: changePolicy();
					break;
			case 5: changeCustType();
					break;
			case 6: invoiceAmount();
					break;
			case 7: addItem();
					break;
			case 8: removeItem();
					break;
			case 9: System.exit(0);
					break;
			default: 
					break;
		}	
		
	}

	private void removeItem() {
		// TODO Auto-generated method stub
		
	}

	private void addItem() {
		// TODO Auto-generated method stub
		
	}

	private void invoiceAmount() {
		// TODO Auto-generated method stub
		
	}

	private void changeCustType() {
		// TODO Auto-generated method stub
		
	}

	private void changePolicy() {
		System.out.println("Enter item type: " + System.lineSeparator()+
				"1) Book" + System.lineSeparator() +
				"2) Movie");
		RentableItem item = null;
		int a = keyboard.nextInt();
		System.out.println("Enter item no: ");
		int itemNo = keyboard.nextInt();
		switch(a) {
			case 1: item = mngr.findItemById("book", itemNo);
					break;
			case 2: item = mngr.findItemById("movie", itemNo);
					break;
			default:
					break;
		}
		System.out.println("Choose policy: " + System.lineSeparator()+ 
				"1) New Release Policy"+ System.lineSeparator()+
				"2) OldRelease Policy" + System.lineSeparator()+
				"3) Bargain Policy" + System.lineSeparator());
		int b = keyboard.nextInt();
		switch(b) {
			case 1: item.setPolicy(Policy.NewReleasePolicy);
					break;
			case 2: item.setPolicy(Policy.OldReleasePolicy);
					break;
			case 3: item.setPolicy(Policy.BargainPolicy);
					break;
			default:
					break;
		}
	}

	private void searchOp() {
		System.out.println("1) One Attribute Book Search" + System.lineSeparator() +
				"2) One Attribute Movie Search" + System.lineSeparator() +
				"3) Two Attribute Book Search" + System.lineSeparator() +
				"4) Two Attribute Movie Search");
		int a = keyboard.nextInt();
		switch(a) {
			case 1: System.out.println("Enter attribute (author, name or publisher): ");
					String bookAtt = keyboard.next();
					System.out.println("Enter search text: ");
					String bookSearchText = keyboard.next();
					mngr.searchBooks(bookSearchText, bookAtt);
					break;
			case 2: System.out.println("Enter attribute (genre, name, producer or actor): ");
					String movieAtt = keyboard.next();
					System.out.println("Enter search text: ");
					String movieSearchText = keyboard.next();
					mngr.searchMovies(movieSearchText, movieAtt);
					break;
			case 3: System.out.println("Enter 2 attributes (author, name or publisher) (with space between): ");
					String bookAtt1 = keyboard.next();
					String bookAtt2 = keyboard.next();
					System.out.println("Enter search text(with space between and respectively): ");
					String bookSearchText1 = keyboard.next();
					String bookSearchText2 = keyboard.next();
					mngr.searchBooksVanced(bookSearchText1, bookSearchText2, bookAtt1, bookAtt2);
					break;	
			case 4: System.out.println("Enter 2 attributes (genre, name, producer, actor) (with space between): ");
					String movieAtt1 = keyboard.next();
					String movieAtt2 = keyboard.next();
					System.out.println("Enter search text(with space between and respectively): ");
					String movieSearchText1 = keyboard.next();
					String movieSearchText2 = keyboard.next();
					mngr.searchMoviesVanced(movieSearchText1, movieSearchText2, movieAtt1, movieAtt2);
					break;
		}	
	}

	private void returnOp() {
		System.out.println("Enter customer no: ");
		int custNo = keyboard.nextInt();
		System.out.println("Enter item type: ");
		String itemType = keyboard.next();
		System.out.println("Enter item no: ");
		int itemNo = keyboard.nextInt();
		System.out.println("Enter operation date in format dd-MM-yyyy: ");
		String date = keyboard.next();
		
		mngr.returnItem(custNo, itemType, itemNo, date);
	}

	private void rentOp() {
		System.out.println("Enter customer no: ");
		int custNo = keyboard.nextInt();
		System.out.println("Enter item type: ");
		String itemType = keyboard.next();
		System.out.println("Enter item no: ");
		int itemNo = keyboard.nextInt();
		System.out.println("Enter operation date in format dd-MM-yyyy: ");
		String date = keyboard.next();
		
		mngr.rentItem(custNo, itemType, itemNo, date);
	}
}
