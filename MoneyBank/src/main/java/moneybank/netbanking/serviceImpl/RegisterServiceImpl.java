package moneybank.netbanking.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moneybank.netbanking.beans.Kyc;
import moneybank.netbanking.beans.NewUser;
import moneybank.netbanking.beans.User;
import moneybank.netbanking.dao.FileDAO;
import moneybank.netbanking.dao.RegisterDAO;
import moneybank.netbanking.service.RegisterService;
@Service
public class RegisterServiceImpl implements RegisterService {
	private static final Logger logger = Logger.getLogger(RegisterServiceImpl.class);
	@Autowired
	RegisterDAO registerDAO;
	
	@Autowired
FileDAO fileDao;

	@Override
	public String register(User user) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();  
		user.setReg_date(formatter.format(date));
		if(user.getRole()=='C') {
			user.setUser_status('N');
		}
		else {
			user.setUser_status('A');
		}
		List<User> users=registerDAO.getUser(user.getUsername());
		System.out.println(users);
		if(users!=null && !users.isEmpty() ) {
			
			return "Username already taken";
		}
		
		int acct_id= 	registerDAO.save(user);	
		return "success";
	}

	@Override
	public List<User> getAll() {
		return registerDAO.getAll();
	}
	
	@Override
	public List<NewUser> getNewUsers() {
		List<User> userlist= registerDAO.getNewUsers();
		List<NewUser> newUserList= new ArrayList<NewUser>();
		if (userlist!=null && !userlist.isEmpty()) {
			for(User user:userlist) {
				NewUser newuser= new NewUser();
				newuser.setUser_id(user.getUser_id());
				newuser.setFname(user.getFname());
				newuser.setLname(user.getLname());
				newuser.setReg_dt_time(user.getReg_date());	
				 List<Kyc> kyclist=fileDao.viewAll(user.getUser_id());
				 List<String> doclist = new ArrayList<String>();
				 if(kyclist!=null && !kyclist.isEmpty()) {
			for(Kyc kyc: kyclist) {
				doclist.add(kyc.getDocument_file());
			}}
				 newuser.setDoc_list(doclist);
				newUserList.add(newuser);
			} return newUserList;	
		}
		else
		return null;
	}
	@Override	
	public String approveOrReject(NewUser user){
		return registerDAO.approveOrReject(user.getUser_id(), user.getAction());
	}
}
