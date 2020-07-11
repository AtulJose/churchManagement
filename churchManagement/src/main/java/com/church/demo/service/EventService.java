package com.church.demo.service;

import java.util.Date;
import java.util.List;

import com.church.demo.dto.EventsDto;



public interface EventService {

	public List<EventsDto> findEventsfromCurrentDate(Date date);
	
	public List<EventsDto> getAllEventsList();
	
	public void saveEvent(EventsDto eventsDto);
	
	public EventsDto findEventById(Integer id);
	
	public void deleteEvent(Integer id);
}
