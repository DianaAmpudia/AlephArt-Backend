package com.stella.alephart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.alephart.models.LocationState;
import com.stella.alephart.repository.LocationStateRepository;

@Service
public class LocationStateService {
	
	@Autowired
	
	private LocationStateRepository locationStateRepository;
	
	public List<LocationState> findAllLocationState(){
		return locationStateRepository.findAll();
	}
			public Optional<LocationState> findLocationStateById(Long id) {
				return locationStateRepository.findById(id);
			} 

}
