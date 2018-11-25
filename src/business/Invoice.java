package business;
import java.util.Date;

public class Invoice implements IStorable {
	private Date rentDate;
	private Date dueDate;
	private RentableItem item;
	private double cost;
	
	public Invoice(Date opDate, RentableItem item, double cost) {
		setRentDate(opDate);
		setCost(cost);
		setItem(item);
		setDueDate(findDueDay(item));
	}
	
	public Date getRentDate() {
		return rentDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public RentableItem getItem() {
		return item;
	}
	public double getCost() {
		return cost;
	}
	private void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
	private void setDueDate(int dayNum) {
		long date = rentDate.getTime();
		this.dueDate = new Date(date + (dayNum * 86400000));
	}
	
	private void setItem(RentableItem item) {
		this.item = item;
	}
	private void setCost(double cost) {
		this.cost = cost;
	}
	private int findDueDay(RentableItem item) {
		if (item.getClass() == Book.class) {
			return 7;
		}else if(item.getClass() == Movie.class) {
			return 2;
		}else {
			throw new IllegalArgumentException("Invalid item type");
		}
	}

	@Override
	public void store(String format) {
		// TODO Auto-generated method stub
		
	}
	
}


