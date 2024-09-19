package com.stella.alephart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.alephart.models.LocationCity;
import com.stella.alephart.repository.LocationCityRepository;

@Service
public class LocationCityService {
	
	@Autowired
	private LocationCityRepository locationCityRepository;
	
	public List<LocationCity> findAllLocationsCities(){
		return locationCityRepository.findAll();
	}
	
	public Optional<LocationCity> findLocationCityById(Long id){
		return locationCityRepository.findById(id);
	}

}