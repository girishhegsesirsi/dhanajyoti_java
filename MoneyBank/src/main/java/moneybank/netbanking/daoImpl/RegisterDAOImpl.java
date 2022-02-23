package moneybank.netbanking.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import moneybank.netbanking.beans.Account;
import moneybank.netbanking.beans.User;
import moneybank.netbanking.controller.SRController;
import moneybank.netbanking.dao.RegisterDAO;
@Repository
public class RegisterDAOImpl implements RegisterDAO{
	private static final Logger logger = Logger.getLogger(RegisterDAOImpl.class);
	@Autowired
private SessionFactory sessionFactory;
	@Transactional
	@Override
	public int save(User user) {
		 sessionFactory.getCurrentSession().save(user);
			return user.getUser_id();
	}
	@Transactional
	@Override
	public List<User> getAll() {
		List<User> list = sessionFactory.getCurrentSession().createQuery("from User").list();
		return list;
	}
	@Transactional
	@Override
	public User getUser(int acct_id) {
	return (User) sessionFactory.getCurrentSession().get(User.class, acct_id);
	
	}
	
	
	@Transactional
	@Override
	public List<User> getUser(String userName) {
		Query query=sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username");
		query.setParameter("username", userName);
		List<User> user= query.list();
		return user;

	}
	
	@Transactional
	@Override
	public List<User> getNewUsers() {
		Query query=sessionFactory.getCurrentSession().createQuery("from User u where u.role=:user_role and u.user_status=:status");
		query.setParameter("user_role", 'C');
		query.setParameter("status", 'N');
		return query.list();
	}
	
	@Transactional
	@Override
	public String approveOrReject(int acct_id, char status) {
		Session session = sessionFactory.getCurrentSession();
		User user= (User)session.byId(User.class).load(acct_id);
		user.setUser_status(status);
		session.update(user);
		session.flush();
		return "success";
	
	}

}
