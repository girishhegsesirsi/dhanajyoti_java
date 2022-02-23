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

import moneybank.netbanking.beans.Account;
import moneybank.netbanking.beans.Beneficiary;
import moneybank.netbanking.beans.FundTransfer;
import moneybank.netbanking.beans.Result;
import moneybank.netbanking.beans.SavingAccount;
import moneybank.netbanking.beans.TermDepAccount;
import moneybank.netbanking.beans.Transaction;
import moneybank.netbanking.beans.User;
import moneybank.netbanking.service.AccountService;
@RestController
public class AccountController {
	@Autowired
	AccountService accountservice;
	private static final Logger logger = Logger.getLogger(AccountController.class);
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/createAccount")
	public ResponseEntity<?> createAccount(@RequestBody Account acct) {
		logger.info("entering createAccount()");
		System.out.println("inside the AccountController createAccount()");
		System.out.println("incomming values: "+acct);
		boolean flag = false;
		flag=accountservice.createAccount(acct);
		logger.info("exiting createAccount()");
		if (flag==true)
		return ResponseEntity.ok().body("Account Created Successfully");
		else
			return ResponseEntity.ok().body("Account creation Failed");
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/createSBAccount")
	public ResponseEntity<?> createSBAccount(@RequestBody User user) {
		logger.info("entering createSBAccount()");
		HttpHeaders httpHeader = new HttpHeaders ();
		System.out.println("inside the AccountController createSBAccount()");
		logger.info("incomming values: "+user);
		System.out.println("incomming values: "+user);
		SavingAccount account;
		account=accountservice.createAccount(user);
		System.out.println("newly created account details:: "+account);
		logger.info("exiting createSBAccount()");
		return new ResponseEntity(account, httpHeader, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/createTermDepAccount")
	public ResponseEntity<?> createTermDepAccount(@RequestBody TermDepAccount acct) {
		logger.info("entering createTermDepAccount()");
		System.out.println("inside the AccountController createTermDepAccount()");
		logger.info("incomming values: "+acct);
		System.out.println("incomming values: "+acct);
		List<TermDepAccount> list;
		list=accountservice.createAccount(acct);
		logger.info("exiting createTermDepAccount()");
		if (list!=null && !list.isEmpty())
		return ResponseEntity.ok().body(list);
		else
			return ResponseEntity.ok().body("error");
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/fundTransfer")
	public ResponseEntity<?> fundTransfer(@RequestBody FundTransfer fndtrans) {
		logger.info("inside the AccountController fundTransfer()");
		logger.info("incomming values: "+fndtrans);
		HttpHeaders httpHeader = new HttpHeaders ();
		String flag = "";
		flag=accountservice.fundTransfer(fndtrans);
		System.out.println("fund transfer "+flag);
		Result res=new Result();
		if(flag.equals("success")) {
			res.setResult("fund transfer completed successfully");
			return new ResponseEntity(res, httpHeader, HttpStatus.OK);}
		else if(flag.equals("insufficient Balance"))
			{
			logger.info("insufficient Balance");
				res.setResult("Insufficient Balance");
				return new ResponseEntity(res, httpHeader, HttpStatus.OK);
			}
		logger.info("Fund transfer failed");
		res.setResult("Fund transfer failed");
		return new ResponseEntity(res, httpHeader, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/getBalance")
	public ResponseEntity<?> getBalance(@RequestBody Integer acct_id) {
		HttpHeaders httpHeader = new HttpHeaders ();
		logger.info("inside the Logincontroller AuthenticateLogin()");
		logger.info("incomming values: "+acct_id);
		double bal;
		bal=accountservice.getSBAcctBalance(acct_id);
		logger.info("banalce"+bal);
		return new ResponseEntity(bal, httpHeader, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/addBeneficiary")
	public ResponseEntity<?> addBeneficiary(@RequestBody Beneficiary ben) {
		HttpHeaders httpHeader = new HttpHeaders ();
		logger.info("inside the AccountController addBeneficiary()");
		logger.info("incomming values: "+ben);
		Beneficiary newBen;
		newBen=accountservice.saveBeneficiary(ben);
		if (newBen!=null) {
			System.out.println("Beneficiary added successfully, returning success");
			return new ResponseEntity(newBen, httpHeader, HttpStatus.OK);
		}
		else
			return new ResponseEntity(null, httpHeader, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/getSbAccount")
	public ResponseEntity<?> getSbAccount(@RequestBody User user) {
		HttpHeaders httpHeader = new HttpHeaders ();
		logger.info("inside the Logincontroller getSbAccount()");
		logger.info("incomming values: "+user);
		SavingAccount account;
		account=accountservice.getSBAccount(user);
		return new ResponseEntity(account, httpHeader, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/getTermAccount")
	public ResponseEntity<?> getTermAccount(@RequestBody User user) {
		HttpHeaders httpHeader = new HttpHeaders ();
		logger.info("inside the Logincontroller getSbAccount()");
		logger.info("incomming values: "+user);
		List<TermDepAccount> list;
		list=accountservice.getTermAccount(user);
		return new ResponseEntity(list, httpHeader, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/getTransactions")
	public ResponseEntity<?> getTransactions(@RequestBody User user) {
		HttpHeaders httpHeader = new HttpHeaders ();
		logger.info("inside the Logincontroller getTransactions()");
		logger.info("incomming values: "+user);
		List<Transaction> list;
		list=accountservice.getTransactions(user);
		return new ResponseEntity(list, httpHeader, HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/getBeneficiaries")
	public ResponseEntity<?> getBeneficiaries(@RequestBody User user) {
		HttpHeaders httpHeader = new HttpHeaders ();
		logger.info("inside the Logincontroller getBeneficiaries()");
		logger.info("incomming values: "+user);
		List<Beneficiary> list;
		list=accountservice.loadAllBeneficiaries(user);
		return new ResponseEntity(list, httpHeader, HttpStatus.OK);
	}
	


}
