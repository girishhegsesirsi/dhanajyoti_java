package moneybank.netbanking.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import moneybank.netbanking.beans.NewUser;
import moneybank.netbanking.beans.Result;
import moneybank.netbanking.beans.User;
import moneybank.netbanking.service.RegisterService;

@CrossOrigin(origins="http://localhost:4200")
    @RestController
	public class RegisterController {
	@Autowired
	private RegisterService registerService;
	private static final Logger logger = Logger.getLogger(RegisterController.class);
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/registerUser")
	public ResponseEntity<?> registerUser(@RequestBody User user){
		HttpHeaders httpHeader = new HttpHeaders();
		logger.info(" inside registerUser(), incomming Customer :"+user);
		Result res=new Result();
		String ret = registerService.register(user);
		if(ret.equals("success")) {
			res.setResult("success");
		return new ResponseEntity<Result>(res, httpHeader, HttpStatus.OK);
		}
		else {
			res.setResult(ret);
			return new ResponseEntity<Result>(res, httpHeader, HttpStatus.OK);
		}
		}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/getAllUsers")
	public ResponseEntity<?> getAll(){
		logger.info("inside registerController getAll()");
		HttpHeaders httpHeader= new HttpHeaders();
		List<User> list = registerService.getAll();
		logger.info("all users list: "+list);
		return new ResponseEntity<List<User>>(list, httpHeader, HttpStatus.OK);
		}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/getNewUsers")
	public ResponseEntity<?> getNewUsers(){
		logger.info("inside registerController getNewUsers()");
		HttpHeaders httpHeader= new HttpHeaders();
		List<NewUser> list = registerService.getNewUsers();
		logger.info("all users list: "+list);
		System.out.println("all users list: "+list);
		return new ResponseEntity<List<NewUser>>(list, httpHeader, HttpStatus.OK);
		}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/approveOrReject")
	public ResponseEntity<?> approveOrReject(@RequestBody NewUser user){
		logger.info("inside registerController approveOrReject()");
		HttpHeaders httpHeader= new HttpHeaders();
		Result res=new Result();
		String ret= registerService.approveOrReject(user);
		res.setResult(ret);
		logger.info("all users list: "+res);
		return new ResponseEntity<Result>(res, httpHeader, HttpStatus.OK);
		}

}