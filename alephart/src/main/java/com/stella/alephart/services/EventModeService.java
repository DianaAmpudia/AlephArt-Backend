package com.stella.alephart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.alephart.models.EventMode;
import com.stella.alephart.repository.EventModeRepository;

@Service
public class EventModeService {

	// Inyección de dependencias
	@Autowired
	private EventModeRepository eventModeRepository;
	
	// GET all
	public List<EventMode> findAllEventModes(){
		return eventModeRepository.findAll();
	}
	
	// GET single
	public Optional<EventMode> findEventModeById(Long id){
		return eventModeRepository.findById(id);
	}
	
}