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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "USERNAME")
	private String username; 
	
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USER_ROLE")
	private char role;
	
	@Column(name = "USER_STATUS")
	private char user_status;

	@Column(name = "FIRST_NAME")
	private String fname;
	@Column(name = "LAST_NAME")
	private String lname;
	

	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "REG_DATE")
	private String reg_date;
	
	
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addr_id")
	Address address;
	
	//@NotEmpty
	@Column(name = "EMAIL")
	private String email;
	
	//@NotNull
	@Column(name = "MOBILE_NUMBER")
	private long mobile;
	
	//@NotNull
	@Column(name = "AADHAR")
	private long adhaar;
	
	//@NotEmpty
	@Column(name = "PAN")
	private String pan;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getRole() {
		return role;
	}
	public void setRole(char role) {
		this.role = role;
	}
	public char getUser_status() {
		return user_status;
	}
	public void setUser_status(char user_status) {
		this.user_status = user_status;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", user_status=" + user_status + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob
				+ ", reg_date=" + reg_date + ", address=" + address + ", email=" + email + ", mobile=" + mobile
				+ ", adhaar=" + adhaar + ", pan=" + pan + "]";
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

}
