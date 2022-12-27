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
import com.shopping.cart.app.model.Order;
import com.shopping.cart.app.repository.OrderRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@PostMapping("/create")
	public Order createOrder(@RequestBody Order order) {
		return orderRepository.save(order);
	}

	@GetMapping
	public List<Order> getAllOrder() {
		return orderRepository.findAll();
	}

	// 	List<Order> findByCustomerNumber(long customerNumber);
	@GetMapping("/customernumber/{customerNumber}")
	public List<Order> findByCustomerNumber(@PathVariable long customerNumber) {

		return orderRepository.findByCustomerNumber(customerNumber);
	}
	
	// Find By Status
	@GetMapping("/status/{status}")
	public List<Order> findByStatus(@PathVariable int status) {
		return orderRepository.findByStatus(status);
	}
	
	// Find All Order By OrderDate descending order
	@GetMapping("/descending")
	public List<Order> findAllOrderByOrderDate() {
		return orderRepository.findAllOrderByOrderDate();
	}
	
	// List<Order> findByCommentsContains(@Param("comments") String likePattern);
	@GetMapping("/contains/{likePattern}")
	public List<Order> findByCommentsContains(@PathVariable String likePattern) {
		return orderRepository.findByCommentsContains(likePattern);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable long id) throws ResourceNotFoundException {
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not exist with id: " + id));
		return ResponseEntity.ok(order);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable long id, @RequestBody Order order)
			throws ResourceNotFoundException {
		Order updateOrder = orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not exist with id: " + id));

		updateOrder.setOrderLocalDate(order.getOrderLocalDate());
		updateOrder.setRequiredLocalDate(order.getRequiredLocalDate());
		updateOrder.setShippedLocalDate(order.getShippedLocalDate());
		updateOrder.setStatus(order.isStatus());
		updateOrder.setComments(order.getComments());

		orderRepository.save(updateOrder);

		return ResponseEntity.ok(updateOrder);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteOrder(@PathVariable long id) throws ResourceNotFoundException {

		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not exist with id: " + id));

		orderRepository.delete(order);

		return new ResponseEntity<>(HttpStatus.OK);

	}
}
