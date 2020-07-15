package com.church.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.church.demo.dto.AlterService_MemberMapDto;
import com.church.demo.dto.EventsDto;
import com.church.demo.dto.FamilyDto;
import com.church.demo.entity.AlterService_MemberMap;
import com.church.demo.entity.Family;
import com.church.demo.repository.FamilyRepository;

@Service
public class FamilyServiceImpl implements FamilyService{

	@Autowired
	private FamilyRepository familyRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	@Transactional
	public List<FamilyDto> getAllFamilyList() {
		try {
			List<Family> familyList = familyRepository.findAll();
			
			List<FamilyDto> familyDtoList = new ArrayList<FamilyDto>();
			
			if(!(familyList == null || familyList.size() == 0)) {
				for(Family family : familyList ){
					
					FamilyDto familyDto = new FamilyDto();
					familyDto = modelMapper.map(family, FamilyDto.class);
					//BeanUtils.copyProperties(event, eventsDto);
					familyDtoList.add(familyDto);
				}
			}
			return familyDtoList;
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public void saveFamily(FamilyDto familyDto) {
		try {
			Family family = new Family();
			family = modelMapper.map(familyDto, Family.class);
			// BeanUtils.copyProperties(eventsDto,event);
			familyRepository.save(family);
		} catch (Exception e) {

		}
		
	}

	@Override
	@Transactional
	public void deleteFamily(Integer id) {
		try {
			familyRepository.deleteById(id);
		} catch (Exception e) {

		}
	}

	@Override
	@Transactional
	public FamilyDto findFamilyById(Integer id) {
		try {
			Family family = familyRepository.getOne(id);
			FamilyDto familyDto = new FamilyDto();
			familyDto = modelMapper.map(family, FamilyDto.class);
			return familyDto;
		} catch (Exception e) {
			return null;

		}
	}
	

}
