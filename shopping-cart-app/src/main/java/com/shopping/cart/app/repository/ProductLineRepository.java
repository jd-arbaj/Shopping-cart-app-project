package com.shopping.cart.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopping.cart.app.model.ProductLine;



@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, Long> {

	@Query("from ProductLine where textDescription = ?1 and htmlDescription = ?2")
	List<ProductLine> findAllByTextDescriptionAndHtmlDescription(String textDescription, String htmlDescription);
	
	@Query("SELECT p FROM ProductLine p WHERE p.image LIKE ?1")
	List<ProductLine> findByImageLike(String image);
	
	@Query("SELECT p FROM ProductLine p WHERE p.textDescription LIKE CONCAT('%',:pDesc,'%')")
	List<ProductLine> findByTextDescriptionContains(@Param("pDesc") String likePattern);
	
}
