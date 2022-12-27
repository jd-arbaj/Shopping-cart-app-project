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
import com.shopping.cart.app.model.Product;
import com.shopping.cart.app.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {	

	@Autowired
	private ProductRepository productRepository; 

	@PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
	@GetMapping
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
//	@GetMapping
//	public ResponseEntity< List<Product>> getAllProduct(){
//		List<Product> products = productRepository.findAll();
//			
//		return ResponseEntity.ok(products);
//	}
	
	@GetMapping("/{productName}/{buyPrice}")
	public List<Product> getAllProductByProductNameAndBuyPrice(@PathVariable String productName,@PathVariable double buyPrice){
		return productRepository.findAllByProductNameAndBuyPrice(productName, buyPrice);
	}
	
	//find products by ByPrice decending order
	@GetMapping("/buyprice")
	public List<Product> findProductOrderByBuyPrice(){	
		return productRepository.findAllOrderByBuyPrice();
	}
	
	@GetMapping("/priceless/{price}")
	public List<Product> findByPriceLessThan(@PathVariable double price){	
		return productRepository.findByPriceLessThan(price);
	}
	
	@GetMapping("/pricegreater/{price}")
	public List<Product> findByPriceGreaterThan(@PathVariable double price){	
		return productRepository.findByPriceGreaterThan(price);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable  long id) throws ResourceNotFoundException {
		Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));
        return ResponseEntity.ok(product);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody Product product) throws ResourceNotFoundException {
		Product updateProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));
		
		updateProduct.setProductName(product.getProductName());
		updateProduct.setProductScale(product.getProductScale());
		updateProduct.setProductVendor(product.getProductVendor());
		updateProduct.setProductDescription(product.getProductDescription());
		updateProduct.setQuantityInStock(product.getQuantityInStock());
		updateProduct.setBuyPrice(product.getBuyPrice());
		updateProduct.setMSRP(product.getMSRP());        

        productRepository.save(updateProduct);

        return ResponseEntity.ok(updateProduct);
    }

	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long id) throws ResourceNotFoundException{

		Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));

        productRepository.delete(product);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
