package com.shopping.cart.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.app.model.Order;
import com.shopping.cart.app.repository.OrderRepository;
import com.shopping.cart.app.service.OrderService;

@Service

public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Optional<Order> findById(long id) {
		
		Optional<Order> orders = orderRepository.findById(id);   
		return orders;
	}

	@Override
	public Order save(Order entity) {

		Order order = orderRepository.save(entity); 
		return order;
	}

	@Override
	public void delete(long id) {
		orderRepository.deleteById(id);
	}

	@Override
	public List<Order> findAll() {

		List<Order> orders = orderRepository.findAll();
		return orders;
	}

	@Override
	public List<Order> findByCustomerNumber(long customerNumber) {
		
		List<Order> orders = orderRepository.findByCustomerNumber(customerNumber);
		return orders;
	}

	@Override
	public List<Order> findByStatus(int status) {

		List<Order> orders = orderRepository.findByStatus(status);
		return orders;
	}

	@Override
	public List<Order> findAllOrderByOrderDate() {

		List<Order> orders = orderRepository.findAllOrderByOrderDate();
		return orders;
	}

	@Override
	public List<Order> findByCommentsContains(String likePattern) {

		List<Order> orders = orderRepository.findByCommentsContains(likePattern);
		return orders;
	}


}
