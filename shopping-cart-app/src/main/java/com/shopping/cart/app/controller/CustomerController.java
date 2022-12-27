package com.shopping.cart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.app.exception.CustomerNotFoundException;
import com.shopping.cart.app.model.Customer;
import com.shopping.cart.app.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping("/create")
	public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
	@GetMapping
	public List<Customer> getAllcustomer(){
		return customerRepository.findAll();
	}

	@GetMapping("/cityandstate{firstName}/{lastName}")
	public List<Customer> findByCityAndState(@PathVariable String city,@PathVariable String state){
		return customerRepository.findByCityAndState(city, state);
	}
	
	@GetMapping("/{phone}")
	public List<Customer> findByPhoneNumber(@PathVariable String phone){
		return customerRepository.findByPhoneNumber(phone);
	}
	
	@GetMapping("/descending")
	public List<Customer> findAllCustomerOrderByCreditLimit(){
		return customerRepository.findAllCustomerOrderByCreditLimit();
	}
	
	@GetMapping("/lessthan/{creditLimit}")
	public List<Customer> findByCreditLimitLessThan(@PathVariable double creditLimit){
		return customerRepository.findByCreditLimitLessThan(creditLimit);
	}
	
	@GetMapping("/greaterthan/{creditLimit}")
	public List<Customer> findByCreditLimitGreaterThan(@PathVariable double creditLimit){
		return customerRepository.findByCreditLimitGreaterThan(creditLimit);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable  long id) throws CustomerNotFoundException {
		Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("customer not exist with id: " + id));
        return ResponseEntity.ok(customer);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id,@RequestBody Customer customer) throws CustomerNotFoundException {
		Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("customer not exist with id: " + id));
		
		updateCustomer.setCustomerName(customer.getCustomerName());
		updateCustomer.setContactLastName(customer.getContactLastName());
		updateCustomer.setContactFirstName(customer.getContactFirstName());
		updateCustomer.setPhone(customer.getPhone());
		updateCustomer.setAddressLine1(customer.getAddressLine1());
		updateCustomer.setAddressLine2(customer.getAddressLine2());
		updateCustomer.setCity(customer.getCity());
		updateCustomer.setState(customer.getState());
		updateCustomer.setPostalCode(customer.getPostalCode());
		updateCustomer.setCountry(customer.getCountry());
		updateCustomer.setSalesRepEmployeeNumber(customer.getSalesRepEmployeeNumber());
		updateCustomer.setCreditLimit(customer.getCreditLimit());
		
		
		customerRepository.save(updateCustomer);

        return ResponseEntity.ok(updateCustomer);
    }

	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable long id) throws CustomerNotFoundException{

		Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not exist with id: " + id));

        customerRepository.delete(customer);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
