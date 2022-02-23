package moneybank.netbanking.dao;

import java.util.List;

import moneybank.netbanking.beans.Address;
import moneybank.netbanking.beans.Customer;

public interface AddressDAO {
	//create a record
	int save(Address address);
	Address get(int id);
	List<Address> getAll();
	void update(int id, Address address);
	void delete(int id);
	
}
