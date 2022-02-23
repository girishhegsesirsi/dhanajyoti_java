package moneybank.netbanking.service;

import java.util.List;

import moneybank.netbanking.beans.NewUser;
import moneybank.netbanking.beans.User;

public interface RegisterService {

	//create a record
	String register(User user);
		
	//get all the customers
	List<User> getAll();

	List<NewUser> getNewUsers();

	String approveOrReject(NewUser user);



}
