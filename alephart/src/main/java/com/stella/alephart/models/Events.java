package com.stella.alephart.models;

import java.util.Arrays;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="events")
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_events;
	
	@Column
	private String event_name;
	
	@Column
	private String event_description;
	
	@Column
	@Lob
	private byte[] event_photo;
	
	@Column
	private String event_date; //Checar tipo de dato en BD SQL 
	
	@Column
	private String event_time; //Checar tipo de dato en BD SQL
	
	@ManyToOne
	@JoinColumn(name="user_id_user", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "user_userprofile_id_user_profile", nullable = false)
	private UserProfile userProfile;
	
	@ManyToOne
    @JoinColumn(name = "eventmode_id_event_mode", referencedColumnName = "id_event_mode", nullable = false)
    private EventMode eventMode;
	
	@ManyToOne
	@JoinColumn(name = "eventcategory_id_event_category", referencedColumnName = "id_event_category", nullable = false)
	private EventCategory eventCategory;
	 
	@ManyToOne
	@JoinColumn(name = "locationcity_id_location_city", referencedColumnName = "id_location_city", nullable = false)
	private LocationCity locationCity;
	 
	@ManyToOne
	@JoinColumn(name = "locationstate_id_location_state", referencedColumnName = "id_location_state", nullable = false)
	private LocationState locationState;
	 
	public Events () {}

	public Events(Long id_events, String event_name, String event_description, byte[] event_photo, String event_date,
			String event_time, User user, UserProfile userProfile, EventMode eventMode, EventCategory eventCategory,
			LocationCity locationCity, LocationState locationState) {
		super();
		this.id_events = id_events;
		this.event_name = event_name;
		this.event_description = event_description;
		this.event_photo = event_photo;
		this.event_date = event_date;
		this.event_time = event_time;
		this.user = user;
		this.userProfile = userProfile;
		this.eventMode = eventMode;
		this.eventCategory = eventCategory;
		this.locationCity = locationCity;
		this.locationState = locationState;
	}

	public Long getId_events() {
		return id_events;
	}

	public void setId_events(Long id_events) {
		this.id_events = id_events;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getEvent_description() {
		return event_description;
	}

	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}

	public byte[] getEvent_photo() {
		return event_photo;
	}

	public void setEvent_photo(byte[] event_photo) {
		this.event_photo = event_photo;
	}

	public String getEvent_date() {
		return event_date;
	}

	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}

	public String getEvent_time() {
		return event_time;
	}

	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public EventMode getEventMode() {
		return eventMode;
	}

	public void setEventMode(EventMode eventMode) {
		this.eventMode = eventMode;
	}

	public EventCategory getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(EventCategory eventCategory) {
		this.eventCategory = eventCategory;
	}

	public LocationCity getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(LocationCity locationCity) {
		this.locationCity = locationCity;
	}

	public LocationState getLocationState() {
		return locationState;
	}

	public void setLocationState(LocationState locationState) {
		this.locationState = locationState;
	}

	@Override
	public String toString() {
		return "Events [id_events=" + id_events + ", event_name=" + event_name + ", event_description="
				+ event_description + ", event_photo=" + Arrays.toString(event_photo) + ", event_date=" + event_date
				+ ", event_time=" + event_time + ", user=" + user + ", userProfile=" + userProfile + ", eventMode="
				+ eventMode + ", eventCategory=" + eventCategory + ", locationCity=" + locationCity + ", locationState="
				+ locationState + "]";
	}

	
	 
}
