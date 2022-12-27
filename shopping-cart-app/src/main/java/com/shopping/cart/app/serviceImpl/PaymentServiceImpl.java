package com.shopping.cart.app.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.app.model.Payment;
import com.shopping.cart.app.repository.PaymentRepository;
import com.shopping.cart.app.service.PaymentService;

@Service

public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public Optional<Payment> findById(long id) {
		
		Optional<Payment> payments = paymentRepository.findById(id); 
		
		return payments;
	}

	@Override
	public Payment save(Payment entity) {
		Payment payment = paymentRepository.save(entity);
		
		return payment;
	}

	@Override
	public List<Payment> findAll() {
		List<Payment> payments = paymentRepository.findAll();
		
		return payments;
	}

	@Override
	public void delete(long id) {
		
		paymentRepository.deleteById(id);
		
	}

	@Override
	public List<Payment> findByCustomerNumber(long customerNumber) {
		
		List<Payment> payments = paymentRepository.findByCustomerNumber(customerNumber);
		return payments;
	}

	@Override
	public List<Payment> findAllPaymentByAmount() {
		
		List<Payment> payments = paymentRepository.findAllPaymentByAmount();
		return payments;
	}

	

	@Override
	public List<Payment> findByAmountLessThan(double amount) {
		
		List<Payment> payments = paymentRepository.findByAmountLessThan(amount);
		return payments;
	}

	@Override
	public List<Payment> findByAmountGreaterThan(double amount) {

		List<Payment> payments = paymentRepository.findByAmountGreaterThan(amount);
		return payments;
	}

	@Override
	public List<Payment> findByPaymentDate(LocalDate localDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
