package com.stella.alephart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.alephart.dto.EventCreateDTO;
import com.stella.alephart.models.EventCategory;
import com.stella.alephart.models.EventMode;
import com.stella.alephart.models.Events;
import com.stella.alephart.models.LocationCity;
import com.stella.alephart.models.LocationState;
import com.stella.alephart.models.User;
import com.stella.alephart.models.UserProfile;
import com.stella.alephart.repository.EventCategoryRepository;
import com.stella.alephart.repository.EventModeRepository;
import com.stella.alephart.repository.EventsRepository;
import com.stella.alephart.repository.LocationCityRepository;
import com.stella.alephart.repository.LocationStateRepository;
import com.stella.alephart.repository.UserProfileRepository;
import com.stella.alephart.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventsService {
	
	@Autowired
	private EventsRepository eventsRepository;
	
	@Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private EventModeRepository eventModeRepository;
    @Autowired
    private EventCategoryRepository eventCategoryRepository;
    @Autowired
    private LocationCityRepository locationCityRepository;
    @Autowired
    private LocationStateRepository locationStateRepository;
	
	public List<Events> findAllEvents(){
		return eventsRepository.findAll();
	}
		
	public Optional<Events> findEventsById(Long id) {
		return eventsRepository.findById(id);
	}
	
	public Events createEventFromDTO(EventCreateDTO dto) {
	    Events event = new Events();
	    event.setEvent_name(dto.getEvent_name());
	    event.setEvent_description(dto.getEvent_description());
	    event.setEvent_date(dto.getEvent_date());
	    event.setEvent_time(dto.getEvent_time());

	    User user = userRepository.findById(dto.getUserId())
	        .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
	    event.setUser(user);

	    UserProfile userProfile = userProfileRepository.findById(dto.getUserProfileId())
	        .orElseThrow(() -> new EntityNotFoundException("UserProfile no encontrado"));
	    event.setUserProfile(userProfile);

	    EventMode eventMode = eventModeRepository.findById(dto.getEventModeId())
	        .orElseThrow(() -> new EntityNotFoundException("EventMode no encontrado"));
	    event.setEventMode(eventMode);

	    EventCategory eventCategory = eventCategoryRepository.findById(dto.getEventCategoryId())
	        .orElseThrow(() -> new EntityNotFoundException("EventCategory no encontrado"));
	    event.setEventCategory(eventCategory);

	    LocationCity locationCity = locationCityRepository.findById(dto.getLocationCityId())
	        .orElseThrow(() -> new EntityNotFoundException("LocationCity no encontrado"));
	    event.setLocationCity(locationCity);

	    LocationState locationState = locationStateRepository.findById(dto.getLocationStateId())
	        .orElseThrow(() -> new EntityNotFoundException("LocationState no encontrado"));
	    event.setLocationState(locationState);

	    return eventsRepository.save(event);
	}
	
	public Events updateEvent(Long id, Events event) {
        return eventsRepository.findById(id)
            .map(existingEvent -> {
                existingEvent.setEvent_name(event.getEvent_name());
                existingEvent.setEvent_description(event.getEvent_description());
                existingEvent.setEvent_date(event.getEvent_date());
                existingEvent.setEvent_time(event.getEvent_time());

                if (event.getEventMode() != null) {
                    EventMode eventMode = eventModeRepository.findById(event.getEventMode().getId_event_mode())
                        .orElseThrow(() -> new EntityNotFoundException("EventMode no encontrado"));
                    existingEvent.setEventMode(eventMode);
                }

                if (event.getEventCategory() != null) {
                    EventCategory eventCategory = eventCategoryRepository.findById(event.getEventCategory().getId_event_category())
                        .orElseThrow(() -> new EntityNotFoundException("EventCategory no encontrado"));
                    existingEvent.setEventCategory(eventCategory);
                }

                if (event.getLocationCity() != null) {
                    LocationCity locationCity = locationCityRepository.findById(event.getLocationCity().getId_location_city())
                        .orElseThrow(() -> new EntityNotFoundException("LocationCity no encontrado"));
                    existingEvent.setLocationCity(locationCity);
                }

                if (event.getLocationState() != null) {
                    LocationState locationState = locationStateRepository.findById(event.getLocationState().getId_location_state())
                        .orElseThrow(() -> new EntityNotFoundException("LocationState no encontrado"));
                    existingEvent.setLocationState(locationState);
                }

                return eventsRepository.save(existingEvent);
            })
            .orElseThrow(() -> new EntityNotFoundException("Event with id " + id + " not found"));
    }
	
	public void deleteEvent(Long id) {
		eventsRepository.deleteById(id);
	}

}
