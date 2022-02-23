package moneybank.netbanking.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import moneybank.netbanking.beans.User;
import moneybank.netbanking.beans.UserLoginData;
import moneybank.netbanking.service.LoginService;

@CrossOrigin(origins="*")
@RestController
public class LoginController {
	@Autowired
	LoginService loginservice;
	private static final Logger logger = Logger.getLogger(LoginController.class);
	//@RequestMapping("/welcome")
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/authLogin")
	public ResponseEntity<?> AuthenticateLogin(@RequestBody UserLoginData logindata) {
		
		logger.info("inside the Logincontroller AuthenticateLogin()");
		logger.info("incomming values: "+logindata);
		boolean auth = false;
		User currentUser;
		 HttpHeaders httpHeader;
		
		// Create the Header Object  
        httpHeader = new HttpHeaders();  
        currentUser=loginservice.Auth(logindata);
		if(currentUser!=null) {
			auth=true;
		}
     
		if (auth) {
			httpHeader.add("Authorization", "success");
			httpHeader.add("Role", ""+currentUser.getRole());
			logger.info("Role: "+currentUser.getRole());
		//return ResponseEntity.ok().body("Authenticated Successfully");
			 return new ResponseEntity<User>(currentUser, httpHeader, HttpStatus.OK);
		}else {
			httpHeader.add("Authorization", "failed");
			return  new ResponseEntity<UserLoginData>(null, httpHeader, HttpStatus.OK);
		}
	}
	

/*	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/registerUser")
	public ResponseEntity<?> registerUser(@RequestBody UserLoginData user) {
		
		System.out.println("inside the Logincontroller AuthenticateLogin()");
		System.out.println("incomming values: "+user);
		String flag = "";
		flag=loginservice.save(user);
		if (flag.equals(user.getUsername()))
		return ResponseEntity.ok().body("Registered Successfully");
		else
			return ResponseEntity.ok().body("Registration Failed");
	}
	*/
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/authorize")
	public ResponseEntity<?> authorize(@RequestBody UserLoginData user) {
		
		logger.info("inside the Logincontroller AuthenticateLogin()");
		logger.info("incomming values: "+user);
		String flag = "";
		flag=loginservice.authorize(user);
		if (flag.equals("success"))
		return ResponseEntity.ok().body("Authorised Successfully");
		else
			return ResponseEntity.ok().body("Registration Failed");
	}
}
