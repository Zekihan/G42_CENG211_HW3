package business;
import java.util.Date;

public class Invoice {
	private Date rentDate;
	private Date dueDate;
	private RentableItem item;
	private double cost;
	
	public Invoice(int dayNum, RentableItem item, double cost) {
		setRentDate(new Date());
		setCost(cost);
		setDueDate(dayNum);
		setItem(item);
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
	
	
}


