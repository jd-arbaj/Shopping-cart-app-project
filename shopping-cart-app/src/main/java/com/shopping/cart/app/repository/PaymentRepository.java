package com.shopping.cart.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.cart.app.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

	@Query("select p from Payment p where p.customer = ?1")
	List<Payment> findByCustomerNumber(long customerNumber);
	
	@Query("select p from Payment p order by amount desc")
	List<Payment> findAllPaymentByAmount();
	
	@Query("select p from Payment p where p.amount < ?1")
	List<Payment> findByAmountLessThan(double amount);
	
	@Query("select p from Payment p where p.amount > ?1")
	List<Payment> findByAmountGreaterThan(double amount);
	

}
