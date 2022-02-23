package moneybank.netbanking.service;

import java.util.List;

import moneybank.netbanking.beans.Customer;

public interface CustomerService {

	//create a record
	int save(Customer customer);
	
	//get single customer
	Customer get(int id);
	
	//get all the customers
	List<Customer> getAll();
	//update the existing customer
	void update(int id, Customer customer);
	
	//delete the customer
	void delete(int id);
}
