package com.stella.alephart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stella.alephart.models.LocationCity;
import com.stella.alephart.services.LocationCityService;

@RestController
@RequestMapping("/api/locationcity")
public class LocationCityController {
	
	@Autowired
	private LocationCityService locationCityService;
	
	// GET
		@GetMapping
		public List<LocationCity> getAllLocationsCities() {
			return locationCityService.findAllLocationsCities();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<LocationCity> getLocationCityById(@PathVariable("id") Long id) {
			return locationCityService.findLocationCityById(id)
					.map(ResponseEntity::ok)
					.orElse(ResponseEntity.notFound().build());
		}

}
