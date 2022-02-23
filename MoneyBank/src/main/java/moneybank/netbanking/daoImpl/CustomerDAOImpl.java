package moneybank.netbanking.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import moneybank.netbanking.beans.Customer;
import moneybank.netbanking.controller.SRController;
import moneybank.netbanking.dao.CustomerDAO;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	private static final Logger logger = Logger.getLogger(CustomerDAOImpl.class);
	@Autowired
private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public int save(Customer customer) {
	 sessionFactory.getCurrentSession().save(customer);
		return customer.getCust_id();
	}

	@Override
	@Transactional
	public Customer get(int id) {
		Customer cust = (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
		return cust;
	}

	@Override
	@Transactional
	public List<Customer> getAll() {
		List<Customer> list = sessionFactory.getCurrentSession().createQuery("from Customer").list();
		return list;
	}

	@Override
	@Transactional
	public void update(int id, Customer customer) {
    Session session = sessionFactory.getCurrentSession();
    Customer oldCust= (Customer)session.byId(Customer.class).load(id);
    oldCust.setFname(customer.getFname());
    oldCust.setLname(customer.getLname());
    oldCust.setGender(customer.getGender());
    oldCust.setAddress(customer.getAddress());
    oldCust.setAdhaar(customer.getAdhaar());
    oldCust.setMobile(customer.getMobile());
    oldCust.setDob(customer.getDob());
    oldCust.setEmail(customer.getEmail());
    oldCust.setPan(customer.getPan());
	session.flush();
	}

	@Override
	@Transactional
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
	    Customer cust= (Customer)session.byId(Customer.class).load(id);
	    session.delete(cust);
		
	}

}
