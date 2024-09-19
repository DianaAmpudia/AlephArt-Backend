package com.stella.alephart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stella.alephart.models.EventCategory;
import com.stella.alephart.services.EventCategoryService;


@RestController
@RequestMapping("/api/EventCategory")
public class EventCategoryController {
	
	@Autowired
	private EventCategoryService eventCategoryService;
	
	@GetMapping
	public List<EventCategory> getAllEventCategorys() {
			return eventCategoryService.findAllEventCategorys();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EventCategory> getEventCategoryById(@PathVariable("id") Long id) {
		return eventCategoryService.findEventCategoryById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());}


}
