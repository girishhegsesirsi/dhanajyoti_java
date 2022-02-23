package moneybank.netbanking.service;

public interface TokenService {  
    
    public void saveLoginId(String userLoginId , int adminId);  
      
    public boolean updateToken(String userLoginId , String authenticationToken , String secretKey);  
      
    public int getTokenDetail(String userLoginId );  
  
    public int tokenAuthentication(String token , int loginId);  
  
} 