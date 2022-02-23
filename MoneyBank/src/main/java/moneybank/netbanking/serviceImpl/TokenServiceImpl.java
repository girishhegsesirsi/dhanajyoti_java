package moneybank.netbanking.serviceImpl;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moneybank.netbanking.dao.TokenDAO;
import moneybank.netbanking.daoImpl.AccountDAOImpl;
import moneybank.netbanking.service.TokenService;  
  
@Service("tokenService")  
public class TokenServiceImpl implements TokenService {  
	private static final Logger logger = Logger.getLogger(TokenServiceImpl.class);
  
    @Autowired  
    private TokenDAO tokenDAO;  
      
    @Transactional  
    public void saveLoginId(String userLoginId, int adminId) {  
        tokenDAO.saveUserEmail(userLoginId, adminId);  
    }  
  
    @Transactional  
    public boolean updateToken(String userLoginId, String authenticationToken, String secretKey) {  
        return tokenDAO.updateToken(userLoginId, authenticationToken, secretKey);  
    }  
  
    @Transactional  
    public int getTokenDetail(String userLoginId) {  
        return tokenDAO.getTokenDetail(userLoginId);  
    }  
  
    @Transactional  
    public int tokenAuthentication(String token, int loginId) {  
        return tokenDAO.tokenAuthentication(token, loginId);  
    }  
  
}  