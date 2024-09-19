package com.stella.alephart.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="locationcity")
public class LocationCity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_location_city")
	private Long id_location_city;
	
	@Column
	private String city_name;
	
	
	public LocationCity() {}

	public LocationCity(Long id_location_city, String city_name) {
		super();
		this.id_location_city = id_location_city;
		this.city_name = city_name;
	}

	public Long getId_location_city() {
		return id_location_city;
	}

	public void setId_location_city(Long id_location_city) {
		this.id_location_city = id_location_city;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	@Override
	public String toString() {
		return "LocationCity [id_location_city=" + id_location_city + ", city_name=" + city_name + "]";
	}	
	
}