package business;

public abstract class RentableItem implements IRentable,IStorable,ISearchable {

	private String name;
	private int itemNo;
	
	public RentableItem(String name, int itemNo) {
		setName(name);
		setItemNo(itemNo);
	}
	
	@Override
	public void rent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnIn() {
		// TODO Auto-generated method stub
		
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
	
	
}
