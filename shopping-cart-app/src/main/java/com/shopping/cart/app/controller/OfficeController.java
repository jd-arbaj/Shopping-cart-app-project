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
import com.shopping.cart.app.model.Office;
import com.shopping.cart.app.repository.OfficeRepository;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
	
	@Autowired
	private OfficeRepository officeRepository;
	
	@PostMapping("/create")
    public Office createOffice(@RequestBody Office office) {
        return officeRepository.save(office);
    }
	@GetMapping
	public List<Office> getAllOffice(){
		return officeRepository.findAll();
	}

	// Find Office By City And State
	@GetMapping("/{city}/{state}")
	public List<Office> findByCityAndState(@PathVariable  String city,@PathVariable  String state){
		return officeRepository.findByCityAndState(city, state);
	}
	
	
	// Find All Office OrderBy City in Ascending order
	@GetMapping("/orderbycity")
	public List<Office> findAllOfficeOrderByCity(){
		return officeRepository.findAllOfficeOrderByCity();
	}
		
	// Find Offices By Country name
	@GetMapping("/country/{country}")
	public List<Office> findByCountry(@PathVariable  String country){
		return officeRepository.findByCountry(country);
	}
	
	//Find By City Starting With 
	@GetMapping("/city/{city}")
	public List<Office> findByCityStartingWith(@PathVariable  String city){
		return officeRepository.findByCityStartingWith(city);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Office> getOfficeById(@PathVariable  long id) throws ResourceNotFoundException {
		Office office = officeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Office not exist with id: " + id));
        return ResponseEntity.ok(office);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Office> updateOffice(@PathVariable long id,@RequestBody Office office) throws ResourceNotFoundException {
		Office updateOffice = officeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Office not exist with id: " + id));

        updateOffice.setCity(office.getCity());
        updateOffice.setPhone(office.getPhone());
        updateOffice.setAddressLine1(office.getAddressLine1());
        updateOffice.setAddressLine2(office.getAddressLine2());
        updateOffice.setState(office.getState());
        updateOffice.setCountry(office.getCountry());
        updateOffice.setPostalCode(office.getPostalCode());
        updateOffice.setTerritory(office.getTerritory());

        officeRepository.save(updateOffice);

        return ResponseEntity.ok(updateOffice);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOffice(@PathVariable long id) throws ResourceNotFoundException{

		Office office = officeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Office not exist with id: " + id));

        officeRepository.delete(office);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
