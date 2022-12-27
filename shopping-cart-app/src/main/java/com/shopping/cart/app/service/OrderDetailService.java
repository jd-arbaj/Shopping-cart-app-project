package com.shopping.cart.app.service;

import java.util.List;
import java.util.Optional;

import com.shopping.cart.app.model.OrderDetail;

public interface OrderDetailService {

	Optional<OrderDetail> findById(long id);

	OrderDetail save(OrderDetail orderDetail);
	
	void delete(long id);

	List<OrderDetail> findAll();
	
	List<OrderDetail> findByProductCodeAndQuantityOrdered(long productCode, int quantityOrdered);

	List<OrderDetail> findByPriceEach(double priceEach);
	
	List<OrderDetail> findAllOrderDetailOrderByPriceEach();
	
	List<OrderDetail> findByQuantityOrderedLessThan(int quantityOrdered);
	
	List<OrderDetail> findByQuantityOrderedGreaterThan(int quantityOrdered);                  
	
	List<OrderDetail> findByOrderLineNumber(int orderLineNumber);

}
