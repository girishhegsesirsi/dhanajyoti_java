package moneybank.netbanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import moneybank.netbanking.beans.Customer;
import moneybank.netbanking.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	//Get all the customers
	@GetMapping("/getCustomers")
	public ResponseEntity<List<Customer>> getAll(){
		List<Customer> list= customerService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Create a customer
	@PostMapping("/createCustomer")
	public ResponseEntity<?> saveCustomer(@RequestBody Customer cust){
		
		System.out.println("incomming Customer :"+cust);
		int id = customerService.save(cust);
		return ResponseEntity.ok().body("Customer created with the id: "+id);
		}
	
	//Get a customer
		@GetMapping("/Customer/{id}")
		public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id){
			Customer cust= customerService.get(id);
			return ResponseEntity.ok().body(cust);
		}
	//Update a customer
		@PutMapping("/Customer/{id}")
		public ResponseEntity<?> updateCustomer(@PathVariable("id") int id,@RequestBody Customer cust){
		    customerService.update(id, cust);
		    return ResponseEntity.ok().body("Customer has been updated");
		}
		
	//delete a customer
		@DeleteMapping("/Customer/{id}")
		public ResponseEntity<?> updateCustomer(@PathVariable("id") int id){
			customerService.delete(id);
			return ResponseEntity.ok().body("Customer has been deleted");
		}
}
