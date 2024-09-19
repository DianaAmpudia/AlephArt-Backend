package com.stella.alephart.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="eventmode")
public class EventMode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_event_mode;
	
	@Column
	private String mode_name;
	
	
	public EventMode() {}
	
	public EventMode(Long id_event_mode, String mode_name) {
		super();
		this.id_event_mode = id_event_mode;
		this.mode_name = mode_name;
	}
	
	public Long getId_event_mode() {
		return id_event_mode;
	}
	public void setId_event_mode(Long id_event_mode) {
		this.id_event_mode = id_event_mode;
	}
	public String getMode_name() {
		return mode_name;
	}
	public void setMode_name(String mode_name) {
		this.mode_name = mode_name;
	}
	@Override
	public String toString() {
		return "EventMode [id_event_mode=" + id_event_mode + ", mode_name=" + mode_name + "]";
	}
	
}