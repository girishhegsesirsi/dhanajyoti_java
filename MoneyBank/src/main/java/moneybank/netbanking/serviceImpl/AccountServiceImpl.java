package moneybank.netbanking.serviceImpl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moneybank.netbanking.beans.Account;
import moneybank.netbanking.beans.Beneficiary;
import moneybank.netbanking.beans.FundTransfer;
import moneybank.netbanking.beans.SavingAccount;
import moneybank.netbanking.beans.TermDepAccount;
import moneybank.netbanking.beans.Transaction;
import moneybank.netbanking.beans.User;
import moneybank.netbanking.dao.AccountDAO;
import moneybank.netbanking.daoImpl.AccountDAOImpl;
import moneybank.netbanking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	private static final Logger logger = Logger.getLogger(AccountServiceImpl.class);
	@Autowired
private AccountDAO accountDao;
	@Override
	public Account getAccount(int acct_id) {
		Account acc=accountDao.getAccount(acct_id);
		return acc;
	}
	@Override
	public SavingAccount getSBAccount(User user) {
		SavingAccount acc=accountDao.getSavingAccount(user.getUser_id());
		return acc;
	}
	@Override
	public List<Account> getAccountsByType(int acct_holder_id, char acct_type) {
		List<Account> list=accountDao.getAccountsByType(acct_holder_id, acct_type);
		return list;
	}

	@Override
	public List<Account> getAllAccounts(int acct_holder_id) {
		List<Account> list=accountDao.getAllAccounts(acct_holder_id);
		return list;
	}

	@Override
	public Account getAccountDetails(int act_id) {
		Account acct=accountDao.getAccountDetails(act_id);
		return acct;
	}

	@Override
	public double getSBAccount(int acct_id) {
		//accountDao.ge
		return 0;
	}

	@Override
	public double getSBAcctBalance(int acct_id) {
		return accountDao.getSBAcctBalance(acct_id);
		
	}


	
	
	@Override
	public boolean createAccount(SavingAccount account) {
			
	return	accountDao.createSBAccount((SavingAccount)account);
	}
	
	@Override
	public SavingAccount createAccount(User user) {
			SavingAccount account=new SavingAccount();
			account.setUser(user);
			account.setAcct_banance(10000);
			account.setAccount_created_date(new Date());
			account.setAccount_updated_date(new Date());
			account.setAcct_status('A');
			account.setAcct_type('S');
			account.setInt_rate(5.5f);
		accountDao.createSBAccount(account);
		return getSBAccount(user);
	}
	
	
	
	@Override
	public List<TermDepAccount> createAccount(TermDepAccount account) {
		SavingAccount sacct=accountDao.getSavingAccount(account.getUser().getUser_id());
		double savingBalance=sacct.getAcct_banance();
		double termbal=account.getAcct_banance();
		if(termbal>0) {
		double termAmt=termbal+(termbal*5*5.5)/100;
		account.setMaturity_amt(termAmt);
	}
		account.setAcct_status('A');
		if(savingBalance>termbal) {
			accountDao.updateSBAccount(sacct.getAcct_id(),(savingBalance-termbal));
			int acct_id=accountDao.createTermDepAccount(account);
			String tran_desc="Term Account opened with the balance" +termbal;
			accountDao.insertTransaction(account.getUser(), "Term", tran_desc, termbal);
			return accountDao.getTermDepAccounts(account.getUser().getUser_id());
		}
		return null;

	}
		
	

	@Override
	public void updateAccount(Account account) {
		if(account.getAcct_type()=='S') {
			
			accountDao.updateSBAccount(account);
		}
		else
		{
			accountDao.updateTermAccount(account);
		}
		
	}

	@Override
	public boolean isAccountExists(int Acct_id) {
    return accountDao.isAccountExists(Acct_id);
	}

	@Override
	public int getTenure(int acct_id) {
		accountDao.getTenure(acct_id);
		return 0;
	}

	@Override
	public boolean insertTransaction(User user, String Tran_type, String tran_desc, double tran_amt) {
		return accountDao.insertTransaction(user, Tran_type, tran_desc, tran_amt);
		 
	}

	@Override
	public List<Transaction> loadTransactions(int user_id) {
		return accountDao.loadTransactions(user_id);
		 
	}

	@Override
	public Beneficiary saveBeneficiary(Beneficiary ben) {
		Beneficiary addedben=  accountDao.saveBeneficiary(ben);
		System.out.println("newly added beneficiary "+addedben);
		return addedben;
		
	}
	
	@Override
	public List<Beneficiary> loadAllBeneficiaries(User user) {
		// TODO Auto-generated method stub
	 return accountDao.loadAllBeneficiary(user.getUser_id());
	}

	
	@Override
	public String fundTransfer(FundTransfer ft) {
		return accountDao.fundTransfer(ft);
		
	}
	@Override
	public boolean createAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<TermDepAccount> getTermAccount(TermDepAccount account) {
		// TODO Auto-generated method stub
	 return accountDao.getTermDepAccounts(account.getUser().getUser_id());
	}

	@Override
	public List<TermDepAccount> getTermAccount(User user) {
		// TODO Auto-generated method stub
	 return accountDao.getTermDepAccounts(user.getUser_id());
	}
	
	@Override
	public List<Transaction> getTransactions(User user) {
		// TODO Auto-generated method stub
	 return accountDao.getTransactions(user.getUser_id());
	}



}
