package dataaccess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import business.Customer;

public class CustomerSaver {
	
	@SuppressWarnings("unchecked")
	public void saverManyJson(Customer customer) {
		
		CustomerReader reader = new CustomerReader();
		ArrayList<Customer> customers = reader.readerManyJson();
		if (customers == null) {
			customers = new ArrayList<Customer>();
		}
		JSONObject customerJ = CustomerToJson(customer);

		if(customers.size()!=0) {
			boolean flag = false;
			for (Customer object : customers) {
				JSONObject obj = CustomerToJson((Customer) object);
				if(!(obj.toJSONString().equals(customerJ.toJSONString()))) {
					flag = true;
				}
			}
			if(flag) {
				customers.add(customer);
			}
		}else {
			customers.add(customer);
		}
		
		JSONArray customersArray = new JSONArray();
		for (Customer object : customers) {
			JSONObject customerJson = CustomerToJson((Customer) object);
			customersArray.add(customerJson);
		}
		JSONObject filer = new JSONObject();
		filer.put("customers",customersArray);
		try {

			FileWriter file = new FileWriter("Files/customers.json");
			file.write(filer.toJSONString());;
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void saverManyJson(ArrayList<Customer> customers) {
		 File file = new File("Files/customers.json");
		 file.delete();
		 for (Customer customer : customers) {
			saverManyJson(customer);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	private JSONObject CustomerToJson(Customer customer) {
		
		JSONObject customerJ = new JSONObject();
		
		customerJ.put("name",customer.getName());
		customerJ.put("id",customer.getId());
		customerJ.put("type",customer.getType());
		
		return customerJ;
	}
}
