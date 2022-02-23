package moneybank.netbanking.beans;

public class FundTransfer {
	
	private Account fromAccount;
	private Beneficiary ben;
	private double amount;
	
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Beneficiary getBen() {
		return ben;
	}
	public void setBen(Beneficiary ben) {
		this.ben = ben;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "FundTransfer [fromAccount=" + fromAccount + ", ben=" + ben + ", amount=" + amount + "]";
	}


}
