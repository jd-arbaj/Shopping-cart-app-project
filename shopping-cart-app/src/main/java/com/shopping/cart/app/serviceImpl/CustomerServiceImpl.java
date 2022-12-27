package com.shopping.cart.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.app.model.Customer;
import com.shopping.cart.app.repository.CustomerRepository;
import com.shopping.cart.app.service.CustomerService;

@Service

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Optional<Customer> findById(long id) {

		Optional<Customer> customers = customerRepository.findById(id); 
		return customers;
	}

	@Override
	public Customer save(Customer entity) {

		Customer customer = customerRepository.save(entity);
		return customer;
	}

	@Override
	public void delete(long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public List<Customer> findAll() {

		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	@Override
	public List<Customer> findByContactFirstNameAndContactLastName(String firstName, String lastName) {

		List<Customer> customers = findByContactFirstNameAndContactLastName(firstName, lastName);
		
		return customers;
	}

	@Override
	public List<Customer> findByCityAndState(String city, String state) {

		List<Customer> customers = customerRepository.findByCityAndState(city, state);
		return customers;
	}

	@Override
	public List<Customer> findByPhoneNumber(String phone) {

		List<Customer> customers = customerRepository.findByPhoneNumber(phone);
		return customers;
	}

	@Override
	public List<Customer> findAllCustomerOrderByCreditLimit() {

		List<Customer> customers = customerRepository.findAllCustomerOrderByCreditLimit();
		return customers;
	}

	@Override
	public List<Customer> findByCreditLimitLessThan(double creditLimit) {
		List<Customer> customers = customerRepository.findByCreditLimitLessThan(creditLimit);
		return customers;
	}

	@Override
	public List<Customer> findByCreditLimitGreaterThan(double creditLimit) {

		List<Customer> customers = customerRepository.findByCreditLimitGreaterThan(creditLimit);
		return customers;
	}

	@Override
	public List<Customer> findByCustomerNameStartingWith(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByCustomerNameContains(String likePattern) {
		// TODO Auto-generated method stub
		return null;
	}



}
