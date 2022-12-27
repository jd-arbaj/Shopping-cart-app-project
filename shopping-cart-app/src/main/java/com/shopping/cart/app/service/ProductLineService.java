package com.shopping.cart.app.service;

import java.util.List;
import java.util.Optional;

import com.shopping.cart.app.model.ProductLine;

public interface ProductLineService {

List<ProductLine> findAllByTextDescriptionAndHtmlDescription(String textDescription, String htmlDescription);
	
	List<ProductLine> findByImageLike(String image);
	
	List<ProductLine> findByTextDescriptionContains(String likePattern);
	
	List<ProductLine> findByTextDescriptionOrHtmlDescription(String textDescription, String htmlDescription);

	Optional<ProductLine> findById(long id);

	ProductLine save(ProductLine productLine);

	List<ProductLine> findAll();

	void delete(long id);
}
