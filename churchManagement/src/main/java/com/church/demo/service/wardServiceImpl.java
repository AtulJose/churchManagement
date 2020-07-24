package com.church.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.church.demo.dto.EventsDto;
import com.church.demo.dto.WardDto;
import com.church.demo.entity.Events;
import com.church.demo.entity.Ward;
import com.church.demo.repository.WardRepository;

@Service
public class wardServiceImpl implements WardService{

	@Autowired
    private WardRepository wardRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	@Override
	@Transactional
	public List<WardDto> getAllWardList() {
		try {
			List<Ward> wardList = wardRepository.findAll();
			
			List<WardDto> wardDtoList = new ArrayList<WardDto>();
			
			if(!(wardList == null || wardList.size() == 0)) {
				for(Ward ward : wardList ){
					
					WardDto wardDto = new WardDto();
					wardDto = modelMapper.map(ward, WardDto.class);
					//BeanUtils.copyProperties(ward, wardDto);
					wardDtoList.add(wardDto);
				}
			}
			return wardDtoList;
		}catch(Exception e) {
			return null;
		}
	}
	
	@Transactional
	public WardDto findWardById(Integer id)
	{
		try {
			Ward ward = wardRepository.getOne(id);
			WardDto wardDto;
			wardDto = modelMapper.map(ward, WardDto.class);
			//BeanUtils.copyProperties(event,eventsDto);
			return wardDto;
		}catch(Exception e) {
			return null;
			
		}
	}

}
