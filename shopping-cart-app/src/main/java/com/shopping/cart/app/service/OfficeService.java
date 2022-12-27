package com.shopping.cart.app.service;

import java.util.List;
import java.util.Optional;

import com.shopping.cart.app.model.Office;

public interface OfficeService {

	Optional<Office> findById(long id);

	Office save(Office office);
	
	void delete(long id);

	List<Office> findAll();
	
	List<Office> findByCityAndState(String city, String state);
	
	List<Office> findByPhone(String phone);
	
	List<Office> findAllOfficeOrderByCity();
	
	List<Office> findByCityAndPostalCode(String city, String postalCode);
	
	List<Office> findByCountry(String country);                  
	
	List<Office> findByCityStartingWith(String city);
	

}
