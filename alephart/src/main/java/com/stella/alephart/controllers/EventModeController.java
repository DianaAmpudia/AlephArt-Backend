package com.stella.alephart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stella.alephart.models.EventMode;
import com.stella.alephart.services.EventModeService;

@RestController
@RequestMapping("/api/eventMode")
public class EventModeController {
	//inyección	
			@Autowired
			private EventModeService eventModeService; 

		//métodos para el CRUD
			
			//GET 
			@GetMapping
			public List<EventMode> getAllEventModes() {
					return eventModeService.findAllEventModes();
			}

			//Get para un sólo book
			@GetMapping("/{id}") 
			public ResponseEntity<EventMode> getEventModeById(@PathVariable Long id) {
					return eventModeService.findEventModeById(id)
							.map(ResponseEntity::ok) 
							.orElse(ResponseEntity.notFound().build()); 
			}
			
}
