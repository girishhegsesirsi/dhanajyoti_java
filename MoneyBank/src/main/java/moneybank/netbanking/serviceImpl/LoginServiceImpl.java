package moneybank.netbanking.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moneybank.netbanking.beans.User;
import moneybank.netbanking.beans.UserLoginData;
import moneybank.netbanking.dao.LoginDAO;
import moneybank.netbanking.daoImpl.AccountDAOImpl;
import moneybank.netbanking.service.LoginService;
import moneybank.netbanking.utils.DecryptUtil;
@Service
public class LoginServiceImpl implements LoginService {
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);
	@Autowired
private LoginDAO loginDao;

/*	@Override
	public boolean Auth(UserLoginData loginData) {
		UserLoginData data=loginDao.Auth(loginData.getUsername());
		
		if(data!=null && data.getPassword().equals(loginData.getPassword())) {
			return true;
		}
		return false;
	}*/
	@Override
	public User Auth(UserLoginData loginData) { 
		String decrptdLoginPass = DecryptUtil.decode(loginData.getPassword());
		User userFrmDB = loginDao.Auth(loginData.getUsername());
		if (userFrmDB==null)
			return null;
		String decrptdStroedPass= DecryptUtil.decode(userFrmDB.getPassword());
		
		System.out.println("decrptdLoginPass "+decrptdLoginPass+" "+"decrptdStroedPass "+decrptdStroedPass);
		
		if (decrptdLoginPass.equals(decrptdStroedPass))
		return loginDao.Auth(loginData.getUsername());
		else return null;
		
	
	}
	
	@Override
	public String save(UserLoginData user) {
		return loginDao.save(user);
	}
	
	public String authorize(UserLoginData user) {
		return loginDao.authorize(user);
	}

}
