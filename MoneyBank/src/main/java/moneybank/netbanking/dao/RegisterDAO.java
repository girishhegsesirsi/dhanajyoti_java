package moneybank.netbanking.dao;

import java.util.List;

import moneybank.netbanking.beans.User;

public interface RegisterDAO {
	//create a record
		int save(User user);
		
		
		//get all the customers
		List<User> getAll();
		//update the existing customer


		User getUser(int acct_id);


		List<User> getNewUsers();


		String approveOrReject(int acct_id, char status);


		List<User> getUser(String userName);

}
