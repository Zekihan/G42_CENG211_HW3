package business;

import java.util.ArrayList;

public class RentalStore {

	private ArrayList<Invoice> invoices;
	
	
	public RentalStore() {
		setInvoices(invoices);
	}


	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}


	private void setInvoices(ArrayList<Invoice> invoices) {
		this.invoices = invoices;
	}
}
