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

import com.shopping.cart.app.exception.ResourceNotFoundException;
import com.shopping.cart.app.model.Employee;
import com.shopping.cart.app.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	// Find Employees By FirstName And LastName
	@GetMapping("/{fname}/{lName}")
	public List<Employee> findByFirstNameAndLastName(@PathVariable String fName, String lName) {
		return employeeRepository.findByFirstNameAndLastName(fName, lName);
	}

	//Find Employees By Title;
	@GetMapping("/{jobTitle}")
	public List<Employee> findByJobTitle(@PathVariable String jobTitle) {
		return employeeRepository.findByJobTitle(jobTitle);
	}

	// Find All Employee OrderBy CreditLimit Descending Order
	@GetMapping("/descending")
	public List<Employee> findAllEmployeeOrderByCreditLimit() {
		return employeeRepository.findAllEmployeeOrderByCreditLimit();
	}
	
	// List<Employee> findByOfficeCode(int officeCode);
	@GetMapping("/{officeCode}")
	public List<Employee> findByOfficeCode(@PathVariable int officeCode) {
		return employeeRepository.findByOfficeCode(officeCode);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) throws ResourceNotFoundException {
		Employee Employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
		return ResponseEntity.ok(Employee);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee)
			throws ResourceNotFoundException {
		Employee updateEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

		updateEmployee.setLastName(employee.getLastName());
		updateEmployee.setFirstName(employee.getFirstName());
		updateEmployee.setExtension(employee.getExtension());
		updateEmployee.setEmail(employee.getEmail());
		updateEmployee.setReportTo(employee.getReportTo());
		updateEmployee.setJobTitle(employee.getJobTitle());

		employeeRepository.save(updateEmployee);

		return ResponseEntity.ok(updateEmployee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) throws ResourceNotFoundException {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

		employeeRepository.delete(employee);

		return new ResponseEntity<>(HttpStatus.OK);

	}
}
