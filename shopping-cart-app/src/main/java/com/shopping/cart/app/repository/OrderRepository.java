package com.shopping.cart.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopping.cart.app.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	@Query("select o from Order o where o.customer = ?1")
	List<Order> findByCustomerNumber(long customerNumber);
	
	@Query("select o from Order o where o.status= ?1")
	List<Order> findByStatus(int status);
	
	@Query("from Order order by orderDate desc")
	List<Order> findAllOrderByOrderDate();
	
	@Query("select o from Order o where o.comments LIKE CONCAT('%',:comments,'%')")
	List<Order> findByCommentsContains(@Param("comments") String likePattern);
	
	
}
