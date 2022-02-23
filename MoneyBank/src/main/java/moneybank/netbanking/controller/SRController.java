package moneybank.netbanking.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import moneybank.netbanking.beans.Result;
import moneybank.netbanking.beans.ServiceRequest;
import moneybank.netbanking.beans.User;
import moneybank.netbanking.service.SRService;

@RestController
public class SRController {
	@Autowired
SRService srService;
	private static final Logger logger = Logger.getLogger(SRController.class);
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/createSR")
	public ResponseEntity<?> createSR(@RequestBody ServiceRequest sr) {
		
		logger.info("inside the SRController createSR()");
		HttpHeaders httpHeader = new HttpHeaders ();
		logger.info("incomming values: "+sr);
		String flag = "";
		Result res=new Result();
		flag=srService.save(sr);
		if (flag.equals("success")) {
			res.setResult("Request has been created successfully, it will be despatched within 7 working days");
		 return new ResponseEntity(res, httpHeader, HttpStatus.OK);
		}
		else {
			res.setResult("Sorry, insufficient balance");
			return new ResponseEntity(res, httpHeader, HttpStatus.OK);
		}
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/getAllSRs")
	public ResponseEntity<?> getAllSRs(@RequestBody User user){
		logger.info("inside SRController getAllSRs()");
		HttpHeaders httpHeader= new HttpHeaders();
		List<ServiceRequest> list = srService.getAll(user.getUser_id());
		logger.info("all users list: "+list);
		return new ResponseEntity<List<ServiceRequest>>(list, httpHeader, HttpStatus.OK);
		}
}
