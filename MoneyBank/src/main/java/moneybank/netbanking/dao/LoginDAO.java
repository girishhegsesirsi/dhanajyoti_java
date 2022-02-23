package moneybank.netbanking.dao;

import moneybank.netbanking.beans.User;
import moneybank.netbanking.beans.UserLoginData;

public interface LoginDAO {

	public User Auth(String username);
	public String save(UserLoginData user);
	public String authorize(UserLoginData user);
	User Auth(int user_id);
}
	