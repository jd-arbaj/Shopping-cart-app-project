/**
 * 
 */
package com.shopping.cart.app.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shopping.cart.app.model.Product;

class ProductControllerTest {
	
	@Autowired
	private ProductController productController;

	@Test
	void testCreateProduct() {

			Product p = new Product();
			p.setProductName("Leptop");
			
			assertNotNull(productController.createProduct(p));
	}

	/*@Test
	void testGetAllProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllProductByProductNameAndBuyPrice() {
		fail("Not yet implemented");
	}

	@Test
	void testFindProductOrderByBuyPrice() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByPriceLessThan() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByPriceGreaterThan() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByNameStartingWith() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByNameLike() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProductById() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteProduct() {
		fail("Not yet implemented");
	}
*/
}
