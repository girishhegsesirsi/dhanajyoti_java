package moneybank.netbanking.beans;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("T")
public class TermDepAccount extends Account {
	@Column(name="DEPOSIT_TENURE")
	private String deposit_tenure;
	
	@Column(name="MATURITY_AMT")
	private double maturity_amt;

	public String getDeposit_tenure() {
		return deposit_tenure;
	}

	public void setDeposit_tenure(String deposit_tenure) {
		this.deposit_tenure = deposit_tenure;
	}

	public double getMaturity_amt() {
		return maturity_amt;
	}

	public void setMaturity_amt(double maturity_amt) {
		this.maturity_amt = maturity_amt;
	}

	@Override
	public String toString() {
		return "TermDepAccount [deposit_tenure=" + deposit_tenure + ", maturity_amt=" + maturity_amt + "]";
	}
	
	

}
