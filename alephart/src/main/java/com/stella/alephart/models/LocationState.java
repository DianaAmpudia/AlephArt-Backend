package com.stella.alephart.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="locationstate")
public class LocationState {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_location_state;
	
	@Column
	private String state_name;
	
	public LocationState() {}
	

	public LocationState(Long id_location_state, String state_name) {
		super();
		this.id_location_state = id_location_state;
		this.state_name = state_name;
	}

	public Long getId_location_state() {
		return id_location_state;
	}

	public void setId_location_state(Long id_location_state) {
		this.id_location_state = id_location_state;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	@Override
	public String toString() {
		return "LocationState [id_location_state=" + id_location_state + ", state_name=" + state_name + "]";
	}
	
	
}
