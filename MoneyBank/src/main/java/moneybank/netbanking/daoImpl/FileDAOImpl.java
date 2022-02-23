package moneybank.netbanking.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import moneybank.netbanking.beans.Account;
import moneybank.netbanking.beans.Kyc;
import moneybank.netbanking.dao.FileDAO;

@Repository
public class FileDAOImpl implements FileDAO {
	@Autowired
private SessionFactory sessionFactory;
	@Override
	@Transactional
	public int fileUpload(Kyc kyc) {
		 Serializable  kyc_no=sessionFactory.getCurrentSession().save(kyc);
		 int kyc_id= (int)kyc_no;
		 return kyc_id;
		
	}

	@Override
	@Transactional
	public List<Kyc> viewAll(int user_id) {
	Query query=sessionFactory.getCurrentSession().createQuery("from Kyc k where k.user.user_id=:user_id");
	query.setParameter("user_id", user_id);
	return query.list();
	
		}
		
	

	@Override
	public String downloadFile() {
		
		return null;
	}

}
