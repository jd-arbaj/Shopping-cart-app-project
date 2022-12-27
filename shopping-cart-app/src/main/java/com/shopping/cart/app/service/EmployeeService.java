package com.shopping.cart.app.service;

import java.util.List;
import java.util.Optional;

import com.shopping.cart.app.model.Employee;

public interface EmployeeService {


	Optional<Employee> findById(long id);

	Employee save(Employee entity);
	
	void delete(long id);

	List<Employee> findAll();
	
	List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Employee> findByFirstNameAndEmail(String firstName, String email);
	
	List<Employee> findByJobTitle(String jobTitle);
	
	List<Employee> findAllEmployeeOrderByCreditLimit();
	
	List<Employee> findByOfficeCode(int officeCode);

	List<Employee> findByFirstNameContains(String likePattern);


}
