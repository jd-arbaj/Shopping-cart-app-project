package com.shopping.cart.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopping.cart.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{


	@Query("select e from Employee e where e.firstName = ?1 and e.lastName = ?2")
	List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
	
	@Query("select e from Employee e where e.jobTitle= ?1")
	List<Employee> findByJobTitle(String jobTitle);
	
	@Query("from Employee order by lastName desc")
	List<Employee> findAllEmployeeOrderByCreditLimit();
	
	@Query("select e from Employee e where e.office = ?1")
	List<Employee> findByOfficeCode(int officeCode);

}
