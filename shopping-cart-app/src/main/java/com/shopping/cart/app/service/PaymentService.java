package com.shopping.cart.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.shopping.cart.app.model.Payment;

public interface PaymentService {

	Optional<Payment> findById(long id);

	Payment save(Payment payment);
	
	void delete(long id);

	List<Payment> findAll();

	List<Payment> findByCustomerNumber(long customerNumber);
	
	List<Payment> findAllPaymentByAmount();
	
	List<Payment> findByPaymentDate(LocalDate localDate);
	
	List<Payment> findByAmountLessThan(double amount);
	
	List<Payment> findByAmountGreaterThan(double amount);
}
