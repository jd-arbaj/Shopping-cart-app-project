package com.shopping.cart.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.app.model.Product;
import com.shopping.cart.app.repository.ProductRepository;
import com.shopping.cart.app.service.ProductService;

@Service

public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product create(Product p) {
		Product product = productRepository.save(p);
		return product;
	}
	
	@Override
	public List<Product> findAll() {
		
		List<Product> products = productRepository.findAll();
		
		return products;
	}

	@Override
	public List<Product> findAllByProductNameAndBuyPrice(String productName, double buyPrice) {
		
		List<Product> products= productRepository.findAllByProductNameAndBuyPrice(productName, buyPrice);
		
		return products;
	}

	@Override
	public List<Product> findAllOrderByBuyPrice() {
		List<Product> products = productRepository.findAllOrderByBuyPrice();
		return products;
	}

	@Override
	public List<Product> findByPriceLessThan(double buyPrice) {
		List<Product> products = productRepository.findByPriceLessThan(buyPrice);
		return products;
	}

	@Override
	public List<Product> findByPriceGreaterThan(double buyPrice) {
		
		List<Product> products = productRepository.findByPriceGreaterThan(buyPrice);
		return products;
	}

	

	@Override
	public Optional<Product> findById(long id) {
		Optional<Product> product = productRepository.findById(id);
		return product;
	}

	@Override
	public void deleteProduct(Long id) {
		
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> findByNameStartingWith(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByNameLike(String likePattern) {
		// TODO Auto-generated method stub
		return null;
	}

}
