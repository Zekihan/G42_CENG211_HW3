package business;

public enum Customer {
	REGULAR(0),
	SILVER(10),
	GOLD(15),
	PREMIUM(20);
	
	private final int discount;
	
	Customer(int discount) {
		this.discount = discount;
	}
}
