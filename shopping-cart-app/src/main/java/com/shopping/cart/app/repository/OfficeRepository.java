package com.shopping.cart.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.cart.app.model.Office;


@Repository
public interface OfficeRepository extends JpaRepository<Office, Long>{
	
	@Query("select o from Office o where o.city = ?1 and o.state = ?2")
	List<Office> findByCityAndState(String city, String state);
	
	@Query("from Office order by city asc")
	List<Office> findAllOfficeOrderByCity();
		
	@Query("select o from Office o where o.country= ?1")
	List<Office> findByCountry(String country);                  
	
	@Query("SELECT o FROM Office o WHERE o.city LIKE ?1")
	List<Office> findByCityStartingWith(String city);
	
	
}
