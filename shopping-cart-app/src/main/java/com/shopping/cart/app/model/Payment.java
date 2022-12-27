package com.shopping.cart.app.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payments")
public class Payment {

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="customer_number")
	private long customerNumber;
	
	@Column(name="payment_LocalDate")
	private LocalDate paymentLocalDate;

	@Column(name="amount")
	private double amount;

	
	@OneToOne
	@JoinColumn(name="customer_customer_number")
	private Customer customer;

	public Payment() {
		super();
	}

	public Payment(long customerNumber, LocalDate paymentLocalDate, double amount, Customer customer) {
		this.customerNumber = customerNumber;
		this.paymentLocalDate = paymentLocalDate;
		this.amount = amount;
		this.customer = customer;
	}
	
	public Payment(LocalDate paymentLocalDate, double amount, Customer customer) {
		this.paymentLocalDate = paymentLocalDate;
		this.amount = amount;
		this.customer = customer;
	}

	public long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public LocalDate getPaymentLocalDate() {
		return paymentLocalDate;
	}

	public void setPaymentLocalDate(LocalDate paymentLocalDate) {
		this.paymentLocalDate = paymentLocalDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Payment [customerNumber=" + customerNumber + ", paymentLocalDate="
				+ paymentLocalDate + ", amount=" + amount + ", customer=" + customer + "]";
	}
		
}
