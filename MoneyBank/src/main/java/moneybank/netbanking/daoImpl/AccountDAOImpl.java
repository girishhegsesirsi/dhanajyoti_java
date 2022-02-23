package moneybank.netbanking.daoImpl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import moneybank.netbanking.beans.Account;
import moneybank.netbanking.beans.Beneficiary;
import moneybank.netbanking.beans.FundTransfer;
import moneybank.netbanking.beans.SavingAccount;
import moneybank.netbanking.beans.TermDepAccount;
import moneybank.netbanking.beans.Transaction;
import moneybank.netbanking.beans.User;
import moneybank.netbanking.controller.SRController;
import moneybank.netbanking.dao.AccountDAO;

@Repository
public class AccountDAOImpl implements AccountDAO{
	
	private static final Logger logger = Logger.getLogger(AccountDAOImpl.class);
	@Autowired
private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Account getAccountDetails(int act_id) { 
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public int createTermDepAccount(TermDepAccount account) {
		 Serializable  acct_id=sessionFactory.getCurrentSession().save(account);
		 int account_number= (int)acct_id;
		 return account_number;
	}

	@Override
	@Transactional
	public boolean createSBAccount(SavingAccount account) {
		List list= new ArrayList();
		try {
		 list=getAllAccounts(account.getUser().getUser_id());
		}
		catch(Exception e) {
			logger.error("exception occured while getting the users :"+e.getMessage());
			return false;
		}
		if(list.size()==0) {
			 sessionFactory.getCurrentSession().save(account);
			 logger.info("Saving Account created successfully");
			 return true;
			 
		}
		else
			logger.info("Saving account already exists");
		return false;
			
	}

	@Override
	@Transactional
	public void updateTermAccount(Account account) {
		
		sessionFactory.getCurrentSession().save(account);
	}

	@Override
	@Transactional
	public void updateSBAccount(Account account) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	@Transactional
	public double getSBAcctBalance(int acct_id) {
		double balance=-1;
		SavingAccount account = (SavingAccount) sessionFactory.getCurrentSession().get(Account.class, acct_id);
		logger.info("incomming account number: "+acct_id+" account data: "+account);
		if (account!=null)
			balance=account.getAcct_banance();
		return balance;
	}

	@Override
	@Transactional
	public String getTenure(int acct_id) {
		String tenure="";
		TermDepAccount account = (TermDepAccount) sessionFactory.getCurrentSession().get(TermDepAccount.class, acct_id);
		
		if (account!=null)
			tenure=account.getDeposit_tenure();
		return tenure;

	}

	@Override
	@Transactional
	public Beneficiary saveBeneficiary(Beneficiary ben) {
		int ben_id=-1;
		Serializable key=null;
		int acct_id=ben.getBen_account_num();
		int owner_id=ben.getUser().getUser_id();
		logger.info("incomming ben account number and userid "+acct_id+","+owner_id);
		List<Beneficiary> exisitingBen=loadBeneficiary(acct_id,owner_id);
		System.out.println("exisitingBen"+exisitingBen);
		if(exisitingBen==null ||exisitingBen.isEmpty() ) {
			logger.info("it is new Ben accont number");
		key	= sessionFactory.getCurrentSession().save(ben);	
		}
		else{
			logger.info("Beneficiary account already exists");
		}
		if(key!=null)
			return loadBeneficiary((int)key);
	return null;
		
	}
	@Override
	@Transactional
	public Beneficiary loadBeneficiary(int acct_id) {
		Beneficiary ben = (Beneficiary) sessionFactory.getCurrentSession().get(Beneficiary.class, acct_id);
		return ben;
		
	}
	@Override
	@Transactional
	public List<Beneficiary> loadBeneficiary(int acct_id,int owner_id) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Beneficiary b where b.user.user_id=:user_id and b.ben_account_num=:acct_id");
		query.setParameter("user_id", owner_id);
		query.setParameter("acct_id", acct_id);
		return query.list();
	}
	
	@Override
	@Transactional
	public List<Beneficiary> loadAllBeneficiary(int owner_id) {
Query query=sessionFactory.getCurrentSession().createQuery("from Beneficiary b where b.user.user_id=:user_id");
		
		query.setParameter("user_id", owner_id);
		List<Beneficiary> list = query.list();
		return list;
		
	}

	@Override
	@Transactional
	public List<Transaction> loadTransactions(int user_id) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Transaction t where t.user.user_id=:user_id");
		query.setParameter("user_id", user_id);
		List<Transaction> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public Account getAccount(int acct_id) {
		Account account = (Account) sessionFactory.getCurrentSession().get(Account.class, acct_id);
		return account;
	}
	
	@Override
	@Transactional
	public SavingAccount getSavingAccount(int user_id) {
Query query=sessionFactory.getCurrentSession().createQuery("from Account a where a.user.user_id=:user_id and a.acct_type=:type");
		
		query.setParameter("user_id", user_id);
		query.setParameter("type", 'S');
		List<SavingAccount> list = query.list();
		if(list!=null && !list.isEmpty())
		return list.get(0);
		else return null;
	}
	@Override
	@Transactional
	public List<Account> getAccountsByType(int acct_holder_id, char acct_type) {
	Query query=sessionFactory.getCurrentSession().createQuery("from Account a where a.user.user_id=:user_id and a.acct_type=:type");
		
		query.setParameter("user_id", acct_holder_id);
		query.setParameter("type", acct_type);
		List<Account> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public List<Account> getAllAccounts(int acct_holder_id) {
Query query=sessionFactory.getCurrentSession().createQuery("from Account a where a.user.user_id=:user_id");
		
		query.setParameter("user_id", acct_holder_id);
		List<Account> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public boolean isAccountExists(int acct_id) {
		Account acct = (Account) sessionFactory.getCurrentSession().get(Account.class, acct_id);
		if(acct!=null)
			return true;
		return false;
	}
	
	@Override
	@Transactional
	public String fundTransfer(FundTransfer ft) {
		
		StringBuffer transactionDescription= new StringBuffer();
		double amountToBeTransffred= ft.getAmount();
		int fromAcctId=ft.getFromAccount().getAcct_id();
		User fromAcctHolder=ft.getFromAccount().getUser();
		int targetAccount=ft.getBen().getBen_account_num();
		double currentFromAcctBal = getSBAcctBalance(fromAcctId);
		double currentTocctBal = getSBAcctBalance(targetAccount);
		User beneficiaryUser= getAccount(targetAccount).getUser();
		if(currentFromAcctBal==0 || (currentFromAcctBal<amountToBeTransffred))
			return "insufficient Balance";
		
		updateSBAccount( fromAcctId,  (currentFromAcctBal-amountToBeTransffred));
		updateSBAccount(targetAccount,  (currentTocctBal+amountToBeTransffred));
		transactionDescription.append("Amount "+amountToBeTransffred+" transferred " + " from "+ " account "+
				fromAcctId+ " to "+" Account "+ targetAccount);
		insertTransaction(fromAcctHolder, "debit",transactionDescription.toString(),amountToBeTransffred) ;
		insertTransaction(beneficiaryUser, "credit",transactionDescription.toString(),amountToBeTransffred) ;
		return"success";
	}

	@Override
	@Transactional
	public void updateSBAccount(int acct_id, double amount) {
		Session session = sessionFactory.getCurrentSession();
		Account account= (Account)session.byId(Account.class).load(acct_id);
	   account.setAcct_banance(amount);
	   account.setAccount_updated_date(new Date());
	   session.update(account);
	   session.flush();
		
	}
	
	@Override
	@Transactional
	public boolean insertTransaction(User user, String tran_type, String tran_desc, double tran_amt) {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();  
		Transaction tran=new Transaction();
		tran.setUser(user);
		tran.setTrn_type(tran_type);
		tran.setTrn_desc(tran_desc);
		tran.setTrn_amt(tran_amt);
		tran.setTrn_dt_time(formatter.format(date));
sessionFactory.getCurrentSession().saveOrUpdate(tran);
		return true;
	}

	@Override
	@Transactional
	public List<TermDepAccount> getTermDepAccounts(int user_id) {
Query query=sessionFactory.getCurrentSession().createQuery("from Account a where a.user.user_id=:user_id and a.acct_type=:type");
		
		query.setParameter("user_id", user_id);
		query.setParameter("type", 'T');
		return query.list();
		
	}
	
	
	@Override
	@Transactional
	public List<Transaction> getTransactions(int user_id) {
Query query=sessionFactory.getCurrentSession().createQuery("from Transaction t where t.user.user_id=:user_id ");
		query.setParameter("user_id", user_id);
		return query.list();
		
	}



}
