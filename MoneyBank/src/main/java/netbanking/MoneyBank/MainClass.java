package netbanking.MoneyBank;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import moneybank.netbanking.beans.Address;
import moneybank.netbanking.beans.Customer;
import netbanking.MoneyBank.utils.HibernateUtil;

public class MainClass {

	public static void main(String[] args) {
Address ad = new Address();
ad.setAdrl1("Huskur Gate");
ad.setAdrl2("Electronic city");
ad.setCity("Blr");
ad.setPin(123456);
ad.setState("Karnataka");
		Customer cust = new Customer();
	cust.setFname("Girish");
	cust.setLname("Hegde");
	cust.setGender("M");
	cust.setDob(new Date("30/07/1988"));
	cust.setAddress(ad);
	cust.setAdhaar(123456788);
	cust.setMobile(1234567890);
	cust.setPan("123pgfg");
	cust.setEmail("ghegde@gmail.com");
  
	


		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//please note I am not saving studentDetail object but still it will be saved in database
		//that's the magic of one to one mapping 
		session.save(cust);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
}