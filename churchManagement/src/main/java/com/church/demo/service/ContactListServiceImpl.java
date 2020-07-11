package com.church.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.church.demo.dto.EventsDto;
import com.church.demo.dto.FamilyDto;
import com.church.demo.dto.MemberDto;
import com.church.demo.entity.Events;
import com.church.demo.entity.Family;
import com.church.demo.repository.EventsRepository;
import com.church.demo.repository.FamilyRepository;
import com.church.demo.repository.MemberRepository;
import org.modelmapper.ModelMapper;

public class ContactListServiceImpl implements ContactListService{

	@Autowired
    private FamilyRepository familyRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	/************************************************************
	@Transactional
	public List<EventsDto> findEventsfromCurrentDate(Date date) {
		try {
			List<Events> eventsList = eventsRepository.findEventsfromCurrentDate(date);
			
			List<EventsDto> eventsDtos = new ArrayList<EventsDto>();
			
			if(!(eventsList == null || eventsList.size() == 0)) {
				for(Events event : eventsList ){
					
					EventsDto eventsDto = new EventsDto();
					BeanUtils.copyProperties(event, eventsDto);
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
					BeanUtils.copyProperties(event, eventsDto);
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
			Events event = new Events();
			BeanUtils.copyProperties(eventsDto,event);
			eventsRepository.save(event);
		}catch(Exception e) {
			
		}
		
	}
	
	@Transactional
	public EventsDto findEventById(Integer id)
	{
		try {
			Events event = eventsRepository.getOne(id);
			EventsDto eventsDto = new EventsDto();
			BeanUtils.copyProperties(event,eventsDto);
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
***************************************************************************/
	@Override
	public List<FamilyDto> findActiveFamilyMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FamilyDto> getAllFamilyList() {
		try {
			List<Family> familyList = familyRepository.findAll();
			
			List<FamilyDto> familyDtoList = new ArrayList<FamilyDto>();
			
			if(!(familyList == null || familyList.size() == 0)) {
				for(Family family : familyList ){
					
					FamilyDto familyDto = new FamilyDto();
					familyDto = modelMapper.map(family, FamilyDto.class);
					//BeanUtils.copyProperties(family, familyDto);
					familyDtoList.add(familyDto);
				}
			}
			return familyDtoList;
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<MemberDto> getAllMemberList(Integer familyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveFamily(FamilyDto familyDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveFamily(MemberDto memberDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FamilyDto findFamilyById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDto findMemberById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFamily(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
