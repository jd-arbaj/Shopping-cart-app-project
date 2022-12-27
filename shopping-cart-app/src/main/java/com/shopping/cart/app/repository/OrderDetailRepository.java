package com.shopping.cart.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.cart.app.model.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{


	@Query("select od from OrderDetail od where od.priceEach= ?1")
	List<OrderDetail> findByPriceEach(double priceEach);
	
	@Query("from OrderDetail order by priceEach desc")
	List<OrderDetail> findAllOrderDetailOrderByPriceEach();
	
	@Query("select od from OrderDetail od where od.quantityOrdered < ?1")
	List<OrderDetail> findByQuantityOrderedLessThan(int quantityOrdered);
	
	@Query("select od from OrderDetail od where od.quantityOrdered > ?1")
	List<OrderDetail> findByQuantityOrderedGreaterThan(int quantityOrdered);                  
	
}
