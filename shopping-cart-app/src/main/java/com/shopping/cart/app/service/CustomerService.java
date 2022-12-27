package com.shopping.cart.app.service;

import java.util.List;
import java.util.Optional;

import com.shopping.cart.app.model.Customer;

public interface CustomerService {

	Optional<Customer> findById(long id);

	Customer save(Customer entity);
	
	void delete(long id);

	List<Customer> findAll();
	
	List<Customer> findByContactFirstNameAndContactLastName(String firstName, String lastName);
	
	List<Customer> findByCityAndState(String city, String state);
	
	List<Customer> findByPhoneNumber(String phone);
	
	List<Customer> findAllCustomerOrderByCreditLimit();
	
	List<Customer> findByCreditLimitLessThan(double creditLimit);
	
	List<Customer> findByCreditLimitGreaterThan(double creditLimit);                  
	
	List<Customer> findByCustomerNameStartingWith(String name);
	
	List<Customer> findByCustomerNameContains(String likePattern);

	

}
