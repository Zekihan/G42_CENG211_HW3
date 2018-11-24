package business;

public abstract class RentableItem implements IRentable,IStorable,ISearchable {

	private String name;
	private int itemNo;
	private boolean isRented;
	
	public RentableItem(String name, int itemNo) {
		setName(name);
		setItemNo(itemNo);
		setRented(true);
	}
	
	@Override
	public void rent() {
		setRented(true);
	}

	@Override
	public void turnIn() {
		setRented(false);
	}
	
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getItemNo() {
		return itemNo;
	}

	private void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public boolean isRented() {
		return isRented;
	}

	private void setRented(boolean isRented) {
		this.isRented = isRented;
	}
	
	
}
