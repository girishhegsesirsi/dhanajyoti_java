package moneybank.netbanking.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moneybank.netbanking.beans.Customer;
import moneybank.netbanking.dao.CustomerDAO;
import moneybank.netbanking.daoImpl.AccountDAOImpl;
import moneybank.netbanking.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	private static final Logger logger = Logger.getLogger(CustomerServiceImpl.class);
	@Autowired
private CustomerDAO customerDao;
	
	@Override
	public int save(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Customer get(int id) {
		return customerDao.get(id);
	}

	@Override
	public List<Customer> getAll() {
		return	customerDao.getAll();
		 
	}

	@Override
	public void update(int id, Customer customer) {
	customerDao.update(id, customer);
		
	}

	@Override
	public void delete(int id) {
		customerDao.delete(id);
		
	}

}
