package com.stella.alephart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.alephart.models.EventCategory;
import com.stella.alephart.repository.EventCategoryRepository;


@Service
public class EventCategoryService {
	
	@Autowired
	private EventCategoryRepository eventCategoryRepository;
	
	public List<EventCategory> findAllEventCategorys(){
		return eventCategoryRepository.findAll();
	}
	
	public Optional<EventCategory> findEventCategoryById(Long id){
		return eventCategoryRepository.findById(id);
	}

}
