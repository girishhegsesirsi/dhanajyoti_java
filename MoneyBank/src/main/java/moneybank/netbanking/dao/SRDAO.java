package moneybank.netbanking.dao;

import java.util.List;

import moneybank.netbanking.beans.ServiceRequest;

public interface SRDAO {

	List<ServiceRequest> getAll(int user_id);

	int save(ServiceRequest sr);

}
