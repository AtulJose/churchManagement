package com.church.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.church.demo.dto.EventsDto;
import com.church.demo.entity.Events;
import com.church.demo.repository.EventsRepository;
import com.church.demo.repository.WardRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
    private EventsRepository eventsRepository;
	
	@Autowired
	private WardService wardService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Transactional
	public List<EventsDto> findEventsfromCurrentDate(Date date) {
		try {
			List<Events> eventsList = eventsRepository.findEventsfromCurrentDate(date);
			
			List<EventsDto> eventsDtos = new ArrayList<EventsDto>();
			
			if(!(eventsList == null || eventsList.size() == 0)) {
				for(Events event : eventsList ){
					
					EventsDto eventsDto = new EventsDto();
					eventsDto = modelMapper.map(event, EventsDto.class);
					//BeanUtils.copyProperties(event, eventsDto);
					eventsDtos.add(eventsDto);
				}
			}
			return eventsDtos;
		}catch(Exception e) {
			return null;
		}
		
	}
	
	@Transactional
	public List<EventsDto> getAllEventsList()
	{
		try {
			List<Events> eventsList = eventsRepository.findAll();
			
			List<EventsDto> eventsDtos = new ArrayList<EventsDto>();
			
			if(!(eventsList == null || eventsList.size() == 0)) {
				for(Events event : eventsList ){
					
					EventsDto eventsDto = new EventsDto();
					eventsDto = modelMapper.map(event, EventsDto.class);
					//BeanUtils.copyProperties(event, eventsDto);
					eventsDtos.add(eventsDto);
				}
			}
			return eventsDtos;
		}catch(Exception e) {
			return null;
		}
	}

	@Transactional
	public void saveEvent(EventsDto eventsDto)
	{
		try {
			if(eventsDto.getWard().getWardId()!=null && eventsDto.getEventType()=="Ward")
				eventsDto.setWard(wardService.findWardById(eventsDto.getWard().getWardId()));
			else
				eventsDto.setWard(null);
			
			Events event = new Events();
			event = modelMapper.map(eventsDto, Events.class);
			//BeanUtils.copyProperties(eventsDto,event);
			eventsRepository.save(event);
		}catch(Exception e) {
			
		}
		
	}
	
	@Transactional
	public EventsDto findEventById(Integer id)
	{
		try {
			Events event = eventsRepository.getOne(id);
			EventsDto eventsDto;
			eventsDto = modelMapper.map(event, EventsDto.class);
			//BeanUtils.copyProperties(event,eventsDto);
			return eventsDto;
		}catch(Exception e) {
			return null;
			
		}
	}
	
	@Transactional
	public void deleteEvent(Integer id)
	{
		try {
			eventsRepository.deleteById(id);
		}catch(Exception e) {
			
		}
		
	}
	
	/*
	 * public EventsDto entityToDtoMap(Events event) { EventsDto eventDto = new
	 * EventsDto(); eventDto.setEventId(event.getEventId());
	 * eventDto.setEventDate(event.getEventDate());
	 * eventDto.setEventDesc(event.getEventDesc());
	 * eventDto.setEventName(event.getEventName());
	 * eventDto.setEventType(event.getEventType());
	 * eventDto.setWardId(event.getWard().getWardId()); return eventDto; }
	 * 
	 * public Events entityToDtoMap(EventsDto eventDto) { Events event = new
	 * Events(); event.setEventId(eventDto.getEventId());
	 * event.setEventDate(eventDto.getEventDate());
	 * event.setEventDesc(eventDto.getEventDesc());
	 * event.setEventName(eventDto.getEventName());
	 * event.setEventType(eventDto.getEventType()); //if(eventDto.getWardId()!=
	 * null) event.setWard(wardRepository.getOne(eventDto.getWardId())); return
	 * event; }
	 */
}
