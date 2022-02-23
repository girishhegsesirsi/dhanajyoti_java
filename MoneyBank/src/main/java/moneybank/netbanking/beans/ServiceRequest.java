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
@Table(name="SERVICE_REQUEST")
public class ServiceRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int req_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	
	@Column(name="REQ_DESC")
	private String req_desc;

	public int getReq_id() {
		return req_id;
	}

	public void setREQ_id(int reqid) {
		req_id = reqid;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getReq_desc() {
		return req_desc;
	}

	public void setReq_desc(String req_desc) {
		this.req_desc = req_desc;
	}

	@Override
	public String toString() {
		return "ServiceRequest [REQ_id=" + req_id + ", user=" + user + ", req_desc=" + req_desc + "]";
	}
	



}
