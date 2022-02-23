package moneybank.netbanking.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ACCOUNT")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ACCT_TYPE")
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int acct_id;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "user_id")
private User user;

@Column(name = "acct_type", insertable = false, updatable = false)
private char acct_type;

@Column(name="INT_RATE")
private float int_rate;

@Column(name="ACCT_BALANCE")
private double acct_banance;

@Temporal(TemporalType.DATE)
@Column(name="ACCOUNT_CREATED_DATE")
private Date account_created_date;

@Temporal(TemporalType.DATE)
@Column(name="ACCOUNT_UPDATED_DATE")
private Date account_updated_date;

@Column(name="ACCT_STATUS")
private char acct_status;

public char getAcct_status() {
	return acct_status;
}

public void setAcct_status(char acct_status) {
	this.acct_status = acct_status;
}

public int getAcct_id() {
	return acct_id;
}

public void setAcct_id(int acct_id) {
	this.acct_id = acct_id;
}



public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public char getAcct_type() {
	return acct_type;
}

public void setAcct_type(char acct_type) {
	this.acct_type = acct_type;
}

public float getInt_rate() {
	return int_rate;
}

public void setInt_rate(float int_rate) {
	this.int_rate = int_rate;
}

public double getAcct_banance() {
	return acct_banance;
}

public void setAcct_banance(double acct_banance) {
	this.acct_banance = acct_banance;
}

public Date getAccount_created_date() {
	return account_created_date;
}

public void setAccount_created_date(Date account_created_date) {
	this.account_created_date = account_created_date;
}

public Date getAccount_updated_date() {
	return account_updated_date;
}

public void setAccount_updated_date(Date account_updated_date) {
	this.account_updated_date = account_updated_date;
}

@Override
public String toString() {
	return "Account [acct_id=" + acct_id + ", user=" + user + ", acct_type=" + acct_type + ", int_rate=" + int_rate
			+ ", acct_banance=" + acct_banance + ", account_created_date=" + account_created_date
			+ ", account_updated_date=" + account_updated_date + "]";
}


}
