package moneybank.netbanking.service;

import java.util.List;

import moneybank.netbanking.beans.Account;
import moneybank.netbanking.beans.Beneficiary;
import moneybank.netbanking.beans.FundTransfer;
import moneybank.netbanking.beans.SavingAccount;
import moneybank.netbanking.beans.TermDepAccount;
import moneybank.netbanking.beans.Transaction;
import moneybank.netbanking.beans.User;

public interface AccountService {

    public Account getAccount(int acct_id);
	List<Account> getAccountsByType(int acct_holder_id, char acct_type);
	List<Account> getAllAccounts(int acct_holder_id);
	public Account getAccountDetails(int act_id);
	
	public double getSBAccount(int acct_id);
	public double getSBAcctBalance(int acct_id);	
	
	public boolean createAccount(Account account);
	public boolean createAccount(SavingAccount account);
	public List<TermDepAccount> createAccount(TermDepAccount account);
	public List<TermDepAccount> getTermAccount(TermDepAccount account);
	public void updateAccount(Account account);

	public boolean isAccountExists(int Acct_id);

	public int getTenure(int acct_id);
	public List<Transaction>loadTransactions(int user_id);
	public Beneficiary saveBeneficiary(Beneficiary ben);
	String fundTransfer(FundTransfer ft);
	boolean insertTransaction(User user, String Tran_type, String tran_desc, double tran_amt);
	SavingAccount getSBAccount(User user);
	SavingAccount createAccount(User user);
	List<TermDepAccount> getTermAccount(User user);
	List<Transaction> getTransactions(User user);
	List<Beneficiary> loadAllBeneficiaries(User user);


}
