package moneybank.netbanking.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moneybank.netbanking.beans.SavingAccount;
import moneybank.netbanking.beans.ServiceRequest;
import moneybank.netbanking.dao.AccountDAO;
import moneybank.netbanking.dao.SRDAO;
import moneybank.netbanking.daoImpl.AccountDAOImpl;
import moneybank.netbanking.service.SRService;
@Service
public class SRServiceImpl implements SRService {
	private static final Logger logger = Logger.getLogger(SRServiceImpl.class);
	@Autowired
SRDAO srDao;
	@Autowired
AccountDAO acctDao;
	

	@Override

public String save(ServiceRequest sr) {
		SavingAccount sbacct=acctDao.getSavingAccount(sr.getUser().getUser_id());
				double bal=sbacct.getAcct_banance();
		String desc=sr.getReq_desc();
		int charge=0;
	switch(desc) {
	case "20": charge=100;
				break;
	case"50": charge=200;
				break;
	case "100" :charge=300;
				break;
	default: charge=0;
				break;
	}
if(bal>charge) {
	acctDao.updateSBAccount(sbacct.getAcct_id(), (bal-charge));
	 srDao.save(sr);
	 String trandesc="charge"+charge+" is debited for checkbook";
	 acctDao.insertTransaction(sr.getUser(), "service_charge", trandesc, charge);
	 return "success";
}
	return "insufficient Balance";
	}

@Override
public List<ServiceRequest> getAll(int user_id){
return srDao.getAll(user_id);
}
}
