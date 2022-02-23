package moneybank.netbanking.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import moneybank.netbanking.beans.ServiceRequest;
import moneybank.netbanking.controller.SRController;
import moneybank.netbanking.dao.SRDAO;

@Repository
public class SRDAOImpl implements SRDAO {
	private static final Logger logger = Logger.getLogger(SRDAOImpl.class);
	
	@Autowired
private SessionFactory sessionFactory;

	@Override
	@Transactional
public int save(ServiceRequest sr) {
	Serializable srnum=	sessionFactory.getCurrentSession().save(sr);
	return (int)srnum;
	}

@Override
@Transactional
public List<ServiceRequest> getAll(int user_id){
	Query query=sessionFactory.getCurrentSession().createQuery("from ServiceRequest s where s.user.user_id=:user_id");
	
	query.setParameter("user_id", user_id);
	List<ServiceRequest> list = query.list();
	return list;
}
}
