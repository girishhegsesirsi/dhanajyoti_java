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

import moneybank.netbanking.beans.Kyc;
import moneybank.netbanking.beans.Result;
import moneybank.netbanking.beans.User;
import moneybank.netbanking.service.FileService;

@CrossOrigin(origins="http://localhost:4200")

@RestController
public class FileController {
	
	@Autowired
	FileService fileService;
	private static final Logger logger = Logger.getLogger(FileController.class);
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/fileUpload")
	public ResponseEntity<?> fileUpload(@RequestBody Kyc kyc) {

		logger.info("entering fileUpload()");
		System.out.println("inside the FileController fileUpload()");
		System.out.println("incomming values: "+kyc);
		System.out.println("incomming values: "+kyc.getDocument_file());
		HttpHeaders httpHeader = new HttpHeaders ();
		int kyc_id = -1;
		kyc_id=fileService.fileUpload(kyc);
		logger.info("exiting createAccount()");
		Result res= new Result();
		if (kyc_id!=-1) {
			res.setResult("file uploaded successfully");
			return new ResponseEntity(res, httpHeader, HttpStatus.OK);
			}
		
		else {
			res.setResult("file upload failed");
			return new ResponseEntity(res, httpHeader, HttpStatus.OK);
		}
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/viewAll")
	public ResponseEntity<?> viewAll(@RequestBody User user) {
		HttpHeaders httpHeader = new HttpHeaders ();
		logger.info("inside the Filecontroller viewAll()");
		logger.info("incomming values: "+user);
		List<Kyc> list;
		list=fileService.viewAll(user);
		return new ResponseEntity(list, httpHeader, HttpStatus.OK);
	}
	/*	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/downloadFile")
	public ResponseEntity<?> downloadFile() {}*/

}
