package moneybank.netbanking.dao;

import java.util.List;

import moneybank.netbanking.beans.Kyc;

public interface FileDAO {
	public int fileUpload(Kyc kyc);
	public List<Kyc> viewAll(int user_id);
	public String downloadFile();
}
 