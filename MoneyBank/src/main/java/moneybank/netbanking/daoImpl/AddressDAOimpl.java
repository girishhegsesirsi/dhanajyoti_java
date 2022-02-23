package moneybank.netbanking.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import moneybank.netbanking.beans.Address;
import moneybank.netbanking.beans.Customer;
import moneybank.netbanking.controller.SRController;
import moneybank.netbanking.dao.AddressDAO;
@Repository
public class AddressDAOimpl implements AddressDAO{
	private static final Logger logger = Logger.getLogger(AddressDAOimpl.class);
	@Autowired
	private SessionFactory sessionFactory;
		
		@Override
		@Transactional
		public int save(Address address) {
		 sessionFactory.getCurrentSession().save(address);
			return address.getAddr_id();
		}

		@Override
		@Transactional
		public Address get(int id) {
			Address adr = (Address) sessionFactory.getCurrentSession().get(Address.class, id);
			return adr;
		}

		@Override
		@Transactional
		public List<Address> getAll() {
			List<Address> list = sessionFactory.getCurrentSession().createQuery("from Address").list();
			return list;
		}

		@Override
		@Transactional
		public void update(int id, Address address) {
			   Session session = sessionFactory.getCurrentSession();
			   Address oldAdr= (Address)session.byId(Address.class).load(id);
			   oldAdr.setAdrl1(address.getAdrl1());
			   oldAdr.setAdrl2(address.getAdrl2());
			   oldAdr.setCity(address.getCity());
			   oldAdr.setPin(address.getPin());
			   oldAdr.setState(address.getState());
			   session.flush();
			
		}

		@Override
		@Transactional
		public void delete(int id) {
			Session session = sessionFactory.getCurrentSession();
			Address adr= (Address)session.byId(Address.class).load(id);
		    session.delete(adr);
			
		}
}
