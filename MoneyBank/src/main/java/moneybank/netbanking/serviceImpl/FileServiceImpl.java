package moneybank.netbanking.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moneybank.netbanking.beans.Kyc;
import moneybank.netbanking.beans.User;
import moneybank.netbanking.dao.FileDAO;
import moneybank.netbanking.service.FileService;

@Service
public class FileServiceImpl implements FileService{
	private static final Logger logger = Logger.getLogger(FileServiceImpl.class);
	@Autowired
FileDAO fileDao;
	@Override
	public int fileUpload(Kyc kyc) {
		return fileDao.fileUpload(kyc);
		
	}

	@Override
	public List<Kyc> viewAll(User user) {
		return fileDao.viewAll(user.getUser_id());
		
	}

	@Override
	public String downloadFile() {
		// TODO Auto-generated method stub
		return null;
	}
}
