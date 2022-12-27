package com.shopping.cart.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopping.cart.app.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("from Product where productName = ?1 and buyPrice = ?2")
	List<Product> findAllByProductNameAndBuyPrice(String productName, double buyPrice);
	
	@Query("from Product order by buyPrice desc")
	List<Product> findAllOrderByBuyPrice();
	
//	@Query(value="select * from Product p where p.buyPrice<:buyPrice", nativeQuery=true)
//	List<Product> findByPriceLessThan(double buyPrice);
	
	@Query("select p from Product p where p.buyPrice < ?1")
	List<Product> findByPriceLessThan(double buyPrice);
	
	@Query("select p from Product p where p.buyPrice > ?1")
	List<Product> findByPriceGreaterThan(double buyPrice);                  
	
	
	
	
}
