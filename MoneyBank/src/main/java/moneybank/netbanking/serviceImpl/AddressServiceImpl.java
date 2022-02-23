package moneybank.netbanking.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moneybank.netbanking.beans.Address;
import moneybank.netbanking.beans.Customer;
import moneybank.netbanking.dao.AddressDAO;
import moneybank.netbanking.dao.CustomerDAO;
import moneybank.netbanking.daoImpl.AccountDAOImpl;
import moneybank.netbanking.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService{
	private static final Logger logger = Logger.getLogger(AddressServiceImpl.class);
	@Autowired
private AddressDAO addressDao;

		
		@Override
		public int save(Address address) {
			return addressDao.save(address);
		}

		@Override
		public Address get(int id) {
			return addressDao.get(id);
		}

		@Override
		@Transactional
		public List<Address> getAll() {
			return	addressDao.getAll();
			 
		}

		@Override
		public void update(int id, Address address) {
			addressDao.update(id, address);
			
		}

		@Override
		public void delete(int id) {
			addressDao.delete(id);
			
		}

}
