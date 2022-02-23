package moneybank.netbanking.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import moneybank.netbanking.beans.User;
import moneybank.netbanking.beans.UserLoginData;
import moneybank.netbanking.controller.SRController;
import moneybank.netbanking.dao.LoginDAO;

@Repository
public class LoginDAOImpl implements LoginDAO{
	private static final Logger logger = Logger.getLogger(SRController.class);
	@Autowired
private SessionFactory sessionFactory;
	@Transactional
	@Override
	public User Auth(int user_id) {
		User data = (User) sessionFactory.getCurrentSession().get(User.class, user_id);
		return data;
	}
	
	@Transactional
	@Override
	public User Auth(String username) {
	Query query=sessionFactory.getCurrentSession().createQuery("from User a where a.username=:username");
	query.setParameter("username", username);
	List list= query.list();
	if(list!=null && !list.isEmpty()) {
	User user=(User)list.get(0);
	return user;
	}
	return null;
	
	}
	@Override
	@Transactional
	public String save(UserLoginData user) {
	 sessionFactory.getCurrentSession().save(user);
	return user.getUsername();
	}
	
	@Override
	@Transactional
	public String authorize(UserLoginData user) {
		Session session = sessionFactory.getCurrentSession();
		UserLoginData oldLoginData= (UserLoginData)session.byId(UserLoginData.class).load(user.getUsername());
		oldLoginData.setActive(user.isActive());
		session.flush();
		return "success";
	}
}
