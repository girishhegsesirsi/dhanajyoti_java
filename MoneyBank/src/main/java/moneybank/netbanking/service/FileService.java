package moneybank.netbanking.service;

import java.util.List;

import moneybank.netbanking.beans.Kyc;
import moneybank.netbanking.beans.User;

public interface FileService {
	public int fileUpload(Kyc kyc);
	public List<Kyc> viewAll(User user);
	public String downloadFile();
}
