package moneybank.netbanking.dao;

import java.util.List;

import moneybank.netbanking.beans.Account;
import moneybank.netbanking.beans.Beneficiary;
import moneybank.netbanking.beans.FundTransfer;
import moneybank.netbanking.beans.SavingAccount;
import moneybank.netbanking.beans.TermDepAccount;
import moneybank.netbanking.beans.Transaction;
import moneybank.netbanking.beans.User;

public interface AccountDAO {
	public Account getAccountDetails(int act_id);
	
	public int createTermDepAccount(TermDepAccount account);
	public boolean createSBAccount(SavingAccount account) ;
	public void updateTermAccount(Account account);
	public void updateSBAccount(Account account) ;
	public double getSBAcctBalance(int acct_id);
	public String getTenure(int acct_id);
	public Beneficiary saveBeneficiary(Beneficiary ben);
	public List<Transaction>loadTransactions(int user_id);
	public Account getAccount(int acct_id);
	List<Account> getAccountsByType(int acct_holder_id, char acct_type);
	List<Account> getAllAccounts(int acct_holder_id);
	public boolean isAccountExists(int Acct_id);

	List<Beneficiary> loadAllBeneficiary(int owner_id);

	Beneficiary loadBeneficiary(int acct_id);

	List<Beneficiary> loadBeneficiary(int acct_id, int owner_id);
 
	String fundTransfer(FundTransfer ft);

	void updateSBAccount(int acct_id, double amount);

	boolean insertTransaction(User user, String Tran_type, String tran_desc, double tran_amt);

	SavingAccount getSavingAccount(int user_id);
	List<TermDepAccount> getTermDepAccounts(int user_id);

	List<Transaction> getTransactions(int user_id);
}
