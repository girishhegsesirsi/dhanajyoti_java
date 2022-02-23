package moneybank.netbanking.service;

import java.util.List;

import moneybank.netbanking.beans.Address;
import moneybank.netbanking.beans.Customer;

public interface AddressService {

	//create a record
		int save(Address address);
		Address get(int id);
		List<Address> getAll();
		void update(int id, Address address);
		void delete(int id);
		
}
