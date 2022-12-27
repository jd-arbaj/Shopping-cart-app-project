package com.shopping.cart.app.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_number")
	private long orderNumber;
	
	@Column(name="order_LocalDate")
	private LocalDate orderLocalDate;
	
	@Column(name="required_LocalDate")
	private LocalDate requiredLocalDate;
	
	@Column(name="shipped_LocalDate")
	private LocalDate shippedLocalDate;
	
	@Column(name="status")
	private int status;
	
	@Column(name="comments")
	private String comments;
	
	@ManyToOne
	@JoinColumn(name="customer_number")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="orderDetails_orderNumber")
	private OrderDetail orderDetail;

	public Order() {
		super();
	}

	public Order(long orderNumber, LocalDate orderLocalDate, LocalDate requiredLocalDate, LocalDate shippedLocalDate, int status, String comments,
			Customer customer, OrderDetail orderDetail) {
		this.orderNumber = orderNumber;
		this.orderLocalDate = orderLocalDate;
		this.requiredLocalDate = requiredLocalDate;
		this.shippedLocalDate = shippedLocalDate;
		this.status = status;
		this.comments = comments;
		this.customer = customer;
		this.orderDetail = orderDetail;
	}
	
	public Order(LocalDate orderLocalDate, LocalDate requiredLocalDate, LocalDate shippedLocalDate, int status, String comments,
			Customer customer, OrderDetail orderDetail) {
		this.orderLocalDate = orderLocalDate;
		this.requiredLocalDate = requiredLocalDate;
		this.shippedLocalDate = shippedLocalDate;
		this.status = status;
		this.comments = comments;
		this.customer = customer;
		this.orderDetail = orderDetail;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public LocalDate getOrderLocalDate() {
		return orderLocalDate;
	}

	public void setOrderLocalDate(LocalDate orderLocalDate) {
		this.orderLocalDate = orderLocalDate;
	}

	public LocalDate getRequiredLocalDate() {
		return requiredLocalDate;
	}

	public void setRequiredLocalDate(LocalDate requiredLocalDate) {
		this.requiredLocalDate = requiredLocalDate;
	}

	public LocalDate getShippedLocalDate() {
		return shippedLocalDate;
	}

	public void setShippedLocalDate(LocalDate shippedLocalDate) {
		this.shippedLocalDate = shippedLocalDate;
	}

	public int isStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Customer getcustomer() {
		return customer;
	}

	public void setcustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderLocalDate=" + orderLocalDate + ", requiredLocalDate=" + requiredLocalDate
				+ ", shippedLocalDate=" + shippedLocalDate + ", status=" + status + ", comments=" + comments + ", customer="
				+ customer + ", orderDetail=" + orderDetail + "]";
	}
	
	

	
	
	
}
