package com.stella.alephart.dto;

import java.util.Arrays;

public class EventCreateDTO {
	private String event_name;
    private String event_description;
    private byte[] event_photo;
    private String event_date;
    private String event_time;
    private Long userId;
    private Long userProfileId;
    private Long eventModeId;
    private Long eventCategoryId;
    private Long locationCityId;
    private Long locationStateId;
    
    public EventCreateDTO() {}

	public EventCreateDTO(String event_name, String event_description, byte[] event_photo, String event_date,
			String event_time, Long userId, Long userProfileId, Long eventModeId, Long eventCategoryId,
			Long locationCityId, Long locationStateId) {
		super();
		this.event_name = event_name;
		this.event_description = event_description;
		this.event_photo = event_photo;
		this.event_date = event_date;
		this.event_time = event_time;
		this.userId = userId;
		this.userProfileId = userProfileId;
		this.eventModeId = eventModeId;
		this.eventCategoryId = eventCategoryId;
		this.locationCityId = locationCityId;
		this.locationStateId = locationStateId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public Long getEventModeId() {
		return eventModeId;
	}

	public void setEventModeId(Long eventModeId) {
		this.eventModeId = eventModeId;
	}

	public Long getEventCategoryId() {
		return eventCategoryId;
	}

	public void setEventCategoryId(Long eventCategoryId) {
		this.eventCategoryId = eventCategoryId;
	}

	public Long getLocationCityId() {
		return locationCityId;
	}

	public void setLocationCityId(Long locationCityId) {
		this.locationCityId = locationCityId;
	}

	public Long getLocationStateId() {
		return locationStateId;
	}

	public void setLocationStateId(Long locationStateId) {
		this.locationStateId = locationStateId;
	}

	@Override
	public String toString() {
		return "EventCreateDTO [event_name=" + event_name + ", event_description=" + event_description
				+ ", event_photo=" + Arrays.toString(event_photo) + ", event_date=" + event_date + ", event_time="
				+ event_time + ", userId=" + userId + ", userProfileId=" + userProfileId + ", eventModeId="
				+ eventModeId + ", eventCategoryId=" + eventCategoryId + ", locationCityId=" + locationCityId
				+ ", locationStateId=" + locationStateId + "]";
	}
    
	

}
