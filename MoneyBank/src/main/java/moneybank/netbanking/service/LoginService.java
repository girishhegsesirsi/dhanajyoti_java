package moneybank.netbanking.service;

import moneybank.netbanking.beans.User;
import moneybank.netbanking.beans.UserLoginData;

public interface LoginService {
	
	public User Auth(UserLoginData loginData);
	//public boolean Auth(UserLoginData loginData);
	public String save(UserLoginData user);
	public String authorize(UserLoginData user);

}
