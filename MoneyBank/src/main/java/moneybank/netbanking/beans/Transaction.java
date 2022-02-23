package moneybank.netbanking.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TRANSACTION")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trn_id;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name="TRN_TYPE")
	private String trn_type;
	@Column(name="TRN_DESC")
	private String trn_desc;

	@Column(name="TRN_AMT")
	private double trn_amt;

	@Column(name="TRN_DT_TIME")
	private String trn_dt_time;

	public String getTrn_dt_time() {
		return trn_dt_time;
	}

	public void setTrn_dt_time(String trn_dt_time) {
		this.trn_dt_time = trn_dt_time;
	}


	public int getTrn_id() {
		return trn_id;
	}

	public void setTrn_id(int trn_id) {
		this.trn_id = trn_id;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTrn_type() {
		return trn_type;
	}

	public void setTrn_type(String trn_type) {
		this.trn_type = trn_type;
	}

	public String getTrn_desc() {
		return trn_desc;
	}

	public void setTrn_desc(String trn_desc) {
		this.trn_desc = trn_desc;
	}

	public double getTrn_amt() {
		return trn_amt;
	}

	public void setTrn_amt(double trn_amt) {
		this.trn_amt = trn_amt;
		}
	
	
	@Override
	public String toString() {
		return "Transaction [trn_id=" + trn_id + ", user=" + user + ", trn_type=" + trn_type + ", trn_desc=" + trn_desc
				+ ", trn_amt=" + trn_amt + ", trn_dt_time=" + trn_dt_time + "]";
	}
}
