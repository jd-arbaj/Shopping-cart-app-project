package com.shopping.cart.app.service;

import java.util.List;
import java.util.Optional;

import com.shopping.cart.app.model.Order;

public interface OrderService {

	Optional<Order> findById(long id);

	Order save(Order order);
	
	void delete(long id);

	List<Order> findAll();

	List<Order> findByCustomerNumber(long customerNumber);
	
	List<Order> findByStatus(int status);
	
	List<Order> findAllOrderByOrderDate();
	
	List<Order> findByCommentsContains(String likePattern);
}
