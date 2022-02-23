package moneybank.netbanking.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ADDRESS")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDR_ID")
	private int addr_id;
	

	//@NotEmpty
	@Column(name = "ADRL1")
	private String adrl1;
	
	//@NotEmpty
	@Column(name = "ADRL2")
	private String adrl2;
	
	//@NotEmpty
	@Column(name = "CITY")
	private String city;
	
	//@NotEmpty
	@Column(name = "STATE")
	private String state;
	
	//@NotNull	
	@Column(name = "PINCODE")
	private long pin;
	
	public int getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(int id) {
		this.addr_id=id;
	}
	
	public String getAdrl1() {
		return adrl1;
	}
	public void setAdrl1(String adrl1) {
		this.adrl1 = adrl1;
	}
	public String getAdrl2() {
		return adrl2;
	}
	public void setAdrl2(String adrl2) {
		this.adrl2 = adrl2;
	}
	public long getPin() {
		return pin;
	}
	public void setPin(long pinCode) {
		this.pin = pinCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
/*	public Address(String street, String city, String state) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
	}*/
	

	@Override
	public String toString() {
		return "Address [addr_id=" + addr_id + ", adrl1=" + adrl1 + ", adrl2=" + adrl2 + ", city=" + city + ", state="
				+ state + ", pin=" + pin + "]";
	}
	

}
