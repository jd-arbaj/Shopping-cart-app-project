package com.shopping.cart.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.app.model.OrderDetail;
import com.shopping.cart.app.repository.OrderDetailRepository;
import com.shopping.cart.app.service.OrderDetailService;

@Service

public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Override
	public Optional<OrderDetail> findById(long id) {
		
		Optional<OrderDetail> orderDetail = orderDetailRepository.findById(id);
		
		return orderDetail;
	}

	@Override
	public OrderDetail save(OrderDetail entity) {

		OrderDetail orderDetail = orderDetailRepository.save(entity);
		
		return orderDetail;
	}

	@Override
	public void delete(long id) {
		orderDetailRepository.deleteById(id);
	}

	@Override
	public List<OrderDetail> findAll() {

		List<OrderDetail> orderDetails = orderDetailRepository.findAll();
		
		return orderDetails;
	}

	

	@Override
	public List<OrderDetail> findByPriceEach(double priceEach) {

		List<OrderDetail> orderDetails = orderDetailRepository.findByPriceEach(priceEach);
		return orderDetails;
	}

	@Override
	public List<OrderDetail> findAllOrderDetailOrderByPriceEach() {

		List<OrderDetail> orderDetails = orderDetailRepository.findAllOrderDetailOrderByPriceEach();
		return orderDetails;
	}

	@Override
	public List<OrderDetail> findByQuantityOrderedLessThan(int quantityOrdered) {

		List<OrderDetail> orderDetails = orderDetailRepository.findByQuantityOrderedLessThan(quantityOrdered);
		return orderDetails;
	}

	@Override
	public List<OrderDetail> findByQuantityOrderedGreaterThan(int quantityOrdered) {

		List<OrderDetail> orderDetails = orderDetailRepository.findByQuantityOrderedGreaterThan(quantityOrdered);
		return orderDetails;
	}

	

	@Override
	public List<OrderDetail> findByProductCodeAndQuantityOrdered(long productCode, int quantityOrdered) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> findByOrderLineNumber(int orderLineNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}
