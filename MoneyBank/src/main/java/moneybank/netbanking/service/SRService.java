package moneybank.netbanking.service;

import java.util.List;

import moneybank.netbanking.beans.ServiceRequest;

public interface SRService {

	String save(ServiceRequest sr);

	List<ServiceRequest> getAll(int user_id);

}
