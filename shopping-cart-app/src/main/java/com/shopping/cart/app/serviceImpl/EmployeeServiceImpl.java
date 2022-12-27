package com.shopping.cart.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.app.model.Employee;
import com.shopping.cart.app.repository.EmployeeRepository;
import com.shopping.cart.app.service.EmployeeService;

@Service

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Optional<Employee> findById(long id) {
		
		Optional<Employee> employees = employeeRepository.findById(id);
		return employees;
	}

	@Override
	public Employee save(Employee entity) {
		
		Employee employee = employeeRepository.save(entity);
		return employee;
	}

	@Override
	public void delete(long id) {

		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findAll() {

		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public List<Employee> findByFirstNameAndLastName(String firstName, String lastName) {
		
		List<Employee> employees = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		return employees;
	}

	
	@Override
	public List<Employee> findByJobTitle(String jobTitle) {

		List<Employee> employees = employeeRepository.findByJobTitle(jobTitle);
		return employees;
	}

	@Override
	public List<Employee> findAllEmployeeOrderByCreditLimit() {

		List<Employee> employees = employeeRepository.findAllEmployeeOrderByCreditLimit();
		return employees;
	}

	@Override
	public List<Employee> findByOfficeCode(int officeCode) {
		
		List<Employee> employees = employeeRepository.findByOfficeCode(officeCode);
		return employees;
	}

	@Override
	public List<Employee> findByFirstNameAndEmail(String firstName, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findByFirstNameContains(String likePattern) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
