package moneybank.netbanking.beans;

import java.sql.Blob;

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
@Table(name="KYC_DOCUMENT")
public class Kyc {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int kyc_id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name="KYC_TYPE")
	private String kyc_type;
	
	@Column(name="DOCUMENT_DESC")
	private String document_desc;
	
    @Column(name="DOCUMENT_FILE")  
	public String document_file;  
	 
	public int getKyc_id() {
		return kyc_id;
	}

	public void setKyc_id(int kyc_id) {
		this.kyc_id = kyc_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getKyc_type() {
		return kyc_type;
	}

	public void setKyc_type(String kyc_type) {
		this.kyc_type = kyc_type;
	}

	public String getDocument_desc() {
		return document_desc;
	}

	public void setDocument_desc(String document_desc) {
		this.document_desc = document_desc;
	}

	public String getDocument_file() {
		return document_file;
	}

	public void setDocument_file(String document_file) {
		this.document_file = document_file;
	}

	@Override
	public String toString() {
		return "Kyc [kyc_id=" + kyc_id + ", user=" + user + ", kyc_type=" + kyc_type + ", document_desc="
				+ document_desc + "]";
	}


}
