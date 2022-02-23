package moneybank.netbanking.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "CUST_INFO")
public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_id")
	private int cust_id;
	
	@NotEmpty
	//@Pattern(regexp="[^0-9]+")
	//@Size(min=6,max=20)
	@Column(name = "firstname")
	private String fname;
	
	//@NotEmpty
	//@Pattern(regexp="[^0-9]+")
	//@Size(min=6,max=20)
	private String lname;
	
	//@NotEmpty
	@Column(name = "gender")
	private String gender;
	

	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	private Date dob;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addr_id")
	Address address;
	
	//@NotEmpty
	@Column(name = "email")
	private String email;
	
	//@NotNull
	@Column(name = "contact_no")
	private long mobile;
	
	//@NotNull
	@Column(name = "adhaar")
	private long adhaar;
	
	//@NotEmpty
	@Column(name = "pan")
	private String pan;

	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dOB) {
		dob = dOB;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public long getAdhaar() {
		return adhaar;
	}
	public void setAdhaar(long adhaar) {
		this.adhaar = adhaar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender
				+ ", dob=" + dob + ", address=" + address + ", email=" + email + ", mobile=" + mobile + ", adhaar="
				+ adhaar + ", pan=" + pan + "]";
	}
	
	
	

}
