package moneybank.netbanking.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import moneybank.netbanking.beans.Token;
import moneybank.netbanking.controller.SRController;
import moneybank.netbanking.dao.TokenDAO;  
  
@Repository("tokenDAO")  
public class TokenDAOImpl implements TokenDAO  {  
	private static final Logger logger = Logger.getLogger(TokenDAOImpl.class);
    @Autowired  
    SessionFactory sessionFactory;  
  
    public void saveUserEmail(String email, int adminId) {  
        Session session = null;   
        try  
        {  
            session = sessionFactory.getCurrentSession();  
            Token t = new Token();  
            t.setUserID(adminId);  
            t.setEmailId(email);  
            session.save(t);   
        }  
        catch(Exception exception)  
        {  
            System.out.println("Exception in saving UserEmail In Token Table :: " + exception.getMessage());  
        }  
        finally  
        {  
            session.flush();  
        }  
          
    }  
  
    public boolean updateToken(String email, String authenticationToken, String secretKey) {  
        Session session = null;  
        try   
        {  
            session = sessionFactory.getCurrentSession();  
            Query theQuery = null;        
              
            theQuery = session.createQuery("Update Token set authenticationToken = :authenticationToken , secretKey = :secretKey where emailId =:userEmail ");  
                  
            theQuery.setParameter("authenticationToken", authenticationToken);  
            theQuery.setParameter("userEmail", email);  
            theQuery.setParameter("secretKey", secretKey);  
  
            int result = theQuery.executeUpdate();  
                      
            if(result == 1)  
            {  
                return true;  
            }  
            else  
            {  
                return false;  
            }  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Error while updating token :: " + exception.getMessage());  
            return false;  
        }  
        finally  
        {  
            session.flush();  
        }             
    }  
  
    public int getTokenDetail(String email) {  
        Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
            Query query = session.createQuery("from Token where emailId =:userEmail");  
            query.setParameter("userEmail", email);  
              
            List<Token> tokenDetails = query.list();  
              
            if(tokenDetails.size() > 0)  
            {  
                return tokenDetails.get(0).getTokenID();  
            }  
            else  
            {  
                return 0;  
            }  
              
        }  
        catch(Exception exception)  
        {  
            System.out.println("Exception while getting token ID :: " + exception.getMessage());          
        }  
        finally  
        {  
            session.flush();  
        }  
          
        return 0;  
    }  
  
    public int tokenAuthentication(String token, int emailId) {  
        Session session = null;  
          
        try   
        {  
            session = sessionFactory.getCurrentSession();  
              
            Query query = session.createQuery("from Token where userID =:userID and authenticationToken = :token");  
            query.setParameter("userID", emailId);  
            query.setParameter("token", token);  
            List<Token> tokenDetails = query.list();  
              
            if(tokenDetails.size() > 0)  
            {  
                return tokenDetails.get(0).getTokenID();  
            }  
            else  
            {  
                return 0;  
            }  
  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Exception while Authenticating token :: "+ exception);  
            return 0;  
        }  
        finally  
        {  
            session.flush();  
        }  
          
          
    }  
  
}  