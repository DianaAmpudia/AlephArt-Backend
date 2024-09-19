package com.stella.alephart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stella.alephart.models.LocationState;
import com.stella.alephart.services.LocationStateService;

@RestController

@RequestMapping("/api/LocationState")

public class LocationStateController {
	@Autowired
	
	private LocationStateService locationStateService;
	@GetMapping
	
	public List<LocationState> getAllLocationState() {
		return locationStateService.findAllLocationState();
	}
	
	 @GetMapping("/{id}")
	 
	public ResponseEntity<LocationState> getLocationStateById(@PathVariable("id") Long id) {
		return locationStateService.findLocationStateById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());}

}
