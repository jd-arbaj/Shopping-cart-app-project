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
import com.shopping.cart.app.model.ProductLine;
import com.shopping.cart.app.repository.ProductLineRepository;

@RestController
@RequestMapping("/api/productlines")
public class ProductLineController {
	
	@Autowired
	private ProductLineRepository productLineRepository; 

	@PostMapping("/create")
    public ProductLine createProductLine(@RequestBody ProductLine productLine) {
        return productLineRepository.save(productLine);
    }
	@GetMapping
	public List<ProductLine> getAllProductLine(){
		return productLineRepository.findAll();
	}
	
	@GetMapping("/{textDescription}/{htmlDescription}")
	public List<ProductLine> findAllByTextDescriptionAndHtmlDescription(@PathVariable String textDescription,@PathVariable String htmlDescription){
		return productLineRepository.findAllByTextDescriptionAndHtmlDescription(textDescription, htmlDescription);
	}

	@GetMapping("/startwith/{imageUrl}")
	public List<ProductLine> findByNameImage(@PathVariable String imageUrl){	
		return productLineRepository.findByImageLike(imageUrl);
	}
	
	@GetMapping("/contains/{name}")
	public List<ProductLine> findByTextDescriptionContains(@PathVariable String name){	
		return productLineRepository.findByTextDescriptionContains(name);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductLine> getProductLineById(@PathVariable  long id) throws ResourceNotFoundException {
		ProductLine productLine = productLineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductLine not exist with id: " + id));
        return ResponseEntity.ok(productLine);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<ProductLine> updateProductLine(@PathVariable long id,@RequestBody ProductLine productLine) throws ResourceNotFoundException {
		ProductLine updateProductLine = productLineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductLine not exist with id: " + id));

        updateProductLine.setTextDescription(productLine.getTextDescription());
        updateProductLine.setHtmlDescription(productLine.getHtmlDescription());
        updateProductLine.setImage(productLine.getImage());

        productLineRepository.save(updateProductLine);

        return ResponseEntity.ok(updateProductLine);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProductLine(@PathVariable long id) throws ResourceNotFoundException{

		ProductLine productLine = productLineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductLine not exist with id: " + id));

        productLineRepository.delete(productLine);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
