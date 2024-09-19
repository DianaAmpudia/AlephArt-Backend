package com.stella.alephart.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="eventcategory")
public class EventCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_event_category;
	
	@Column
	private String category_name;
	
	
	public EventCategory(){}
	
	public EventCategory(Long id_event_category, String category_name) {
		super();
		this.id_event_category = id_event_category;
		this.category_name = category_name;
	}

	public Long getId_event_category() {
		return id_event_category;
	}

	public void setId_event_category(Long id_event_category) {
		this.id_event_category = id_event_category;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	@Override
	public String toString() {
		return "EventCategory [id_event_category=" + id_event_category + ", category_name=" + category_name + "]";
	}	
	
	
	
}
