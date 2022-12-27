package com.shopping.cart.app.service;

import java.util.List;
import java.util.Optional;

import com.shopping.cart.app.model.Product;

public interface ProductService {

	Product create(Product product);

	Optional<Product> findById(long id);

	void deleteProduct(Long id);

	List<Product> findAll();
	
	List<Product> findAllByProductNameAndBuyPrice(String productName, double buyPrice);
	
	List<Product> findAllOrderByBuyPrice();
	
	List<Product> findByPriceLessThan(double buyPrice);
	
	List<Product> findByPriceGreaterThan(double buyPrice);                  
	
	List<Product> findByNameStartingWith(String prefix);
	
	List<Product> findByNameLike(String likePattern);
}
