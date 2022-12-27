package com.shopping.cart.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.app.model.ProductLine;
import com.shopping.cart.app.repository.ProductLineRepository;
import com.shopping.cart.app.service.ProductLineService;

@Service

public class ProductLineServiceImpl implements ProductLineService {

	@Autowired
	private ProductLineRepository productLineRepository;

	@Override
	public List<ProductLine> findAllByTextDescriptionAndHtmlDescription(String textDescription,
			String htmlDescription) {
		List<ProductLine> productLines = productLineRepository.findAllByTextDescriptionAndHtmlDescription(textDescription, htmlDescription); 
		return productLines;
	}

	@Override
	public List<ProductLine> findByImageLike(String image) {
		
		List<ProductLine> productLines = productLineRepository.findByImageLike(image);
		
		return productLines;
	}

	@Override
	public List<ProductLine> findByTextDescriptionContains(String likePattern) {

		List<ProductLine> productLines = productLineRepository.findByTextDescriptionContains(likePattern);
		return productLines;
	}

	

	@Override
	public void delete(long id) {
		
		productLineRepository.deleteById(id);
		
	}

	@Override
	public Optional<ProductLine> findById(long id) {

		Optional<ProductLine> productLines = productLineRepository.findById(id);
		
		return productLines;
	}

	@Override
	public ProductLine save(ProductLine entity) {

		ProductLine productLine = productLineRepository.save(entity);
		
		return productLine;
	}

	@Override
	public List<ProductLine> findAll() {
		
		List<ProductLine> productLines = productLineRepository.findAll();
		
		return productLines;
	}

	@Override
	public List<ProductLine> findByTextDescriptionOrHtmlDescription(String textDescription, String htmlDescription) {
		// TODO Auto-generated method stub
		return null;
	}


}
