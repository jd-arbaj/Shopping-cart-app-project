package com.shopping.cart.app.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.app.model.Office;
import com.shopping.cart.app.repository.OfficeRepository;
import com.shopping.cart.app.service.OfficeService;

@Service

public class OfficeServiceImpl implements OfficeService{

	@Autowired
	private OfficeRepository officeRepository;
	
	@Override
	public Optional<Office> findById(long id) {

		Optional<Office> office = officeRepository.findById(id); 
		
		return office;
	}

	@Override
	public Office save(Office entity) {

		Office office = officeRepository.save(entity);
		
		return office;
	}

	@Override
	public void delete(long id) {

		officeRepository.deleteById(id);
	}

	@Override
	public List<Office> findAll() {
		
		List<Office> offices = officeRepository.findAll();
		return offices;
	}

	@Override
	public List<Office> findByCityAndState(String city, String state) {

		List<Office> offices = officeRepository.findByCityAndState(city, state);
		return offices;
	}

	

	@Override
	public List<Office> findAllOfficeOrderByCity() {

		List<Office> offices = officeRepository.findAllOfficeOrderByCity();
		return offices;
	}

	
	@Override
	public List<Office> findByCountry(String country) {

		List<Office> offices = officeRepository.findByCountry(country);
		return offices;
	}

	@Override
	public List<Office> findByCityStartingWith(String city) {

		List<Office> offices = officeRepository.findByCityStartingWith(city);
		return offices;
	}

	@Override
	public List<Office> findByPhone(String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Office> findByCityAndPostalCode(String city, String postalCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
