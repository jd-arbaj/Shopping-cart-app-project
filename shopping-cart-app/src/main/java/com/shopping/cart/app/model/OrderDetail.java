package com.shopping.cart.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderdetails")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="order_number")
	private long orderNumber;
	
	@Column(name="quantity_ordered")
	private int quantityOrdered;
	
	@Column(name="price_each")
	private double priceEach;
	
	@Column(name="order_line_number")
	private int orderLineNumber;
	
	@OneToOne
	@JoinColumn(name="product_code")
	private Product product;
	
	@OneToOne
	@JoinColumn(name="order_number")
	private Order order;

	
	public OrderDetail() {
		super();
	}


	public OrderDetail(long orderNumber, int quantityOrdered, double priceEach, int orderLineNumber,
			Product product, Order order) {
		this.orderNumber = orderNumber;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
		this.product = product;
		this.order = order;
	}
	
	public OrderDetail(int quantityOrdered, double priceEach, int orderLineNumber,
			Product product, Order order) {
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
		this.product = product;
		this.order = order;
	}


	public long getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}


	public int getQuantityOrdered() {
		return quantityOrdered;
	}


	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}


	public double getPriceEach() {
		return priceEach;
	}


	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}


	public int getOrderLineNumber() {
		return orderLineNumber;
	}


	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}


	public Product getProductCode() {
		return product;
	}


	public void setProductCode(Product product) {
		this.product = product;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "OrderDetail [orderNumber=" + orderNumber + ", quantityOrdered=" + quantityOrdered + ", priceEach="
				+ priceEach + ", orderLineNumber=" + orderLineNumber + ", ProductCode=" + product + ", order="
				+ order + "]";
	}
	
	
}

