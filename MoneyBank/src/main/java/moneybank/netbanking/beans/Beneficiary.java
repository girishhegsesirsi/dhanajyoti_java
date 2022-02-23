package moneybank.netbanking.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="BENEFICIARY")
public class Beneficiary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ben_id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@Column(name="BEN_TYPE")
	private String ben_type;
	
	@Column(name="BEN_NICK_NAME")
	private String ben_nick_name;

	@Column(name="BEN_ACCT_NUM")
	private int ben_account_num;
	
	@Column(name="BEN_BANK_IFSC")
	private String ben_bank_ifsc;
	public User getUser() {
		return user;
	}
 
	public void setUser(User user) {
		this.user = user;
	}



	public int getBen_id() {
		return ben_id;
	}

	public void setBen_id(int ben_id) {
		this.ben_id = ben_id;
	}


	public String getBen_type() {
		return ben_type;
	}

	public void setBen_type(String ben_type) {
		this.ben_type = ben_type;
	}

	public String getBen_nick_name() {
		return ben_nick_name;
	}

	public void setBen_nick_name(String ben_nick_name) {
		this.ben_nick_name = ben_nick_name;
	}

	public int getBen_account_num() {
		return ben_account_num;
	}

	public void setBen_account_num(int ben_account_num) {
		this.ben_account_num = ben_account_num;
	}

	public String getBen_bank_ifsc() {
		return ben_bank_ifsc;
	}

	public void setBen_bank_ifsc(String ben_bank_ifsc) {
		this.ben_bank_ifsc = ben_bank_ifsc;
	}

	@Override
	public String toString() {
		return "Beneficiary [ben_id=" + ben_id + ", user=" + user + ", ben_type=" + ben_type + ", ben_nick_name="
				+ ben_nick_name + ", ben_account_num=" + ben_account_num + ", ben_bank_ifsc=" + ben_bank_ifsc + "]";
	}

}
