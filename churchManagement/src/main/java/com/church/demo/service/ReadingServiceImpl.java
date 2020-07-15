package com.church.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.demo.dto.EventsDto;
import com.church.demo.dto.ReadingDto;
import com.church.demo.entity.Events;
import com.church.demo.entity.Reading;
import com.church.demo.repository.EventsRepository;
import com.church.demo.repository.ReadingRepository;

@Service
public class ReadingServiceImpl implements ReadingService {

	@Autowired
	private ReadingRepository readingsRepository;

	private ModelMapper modelMapper = new ModelMapper();

	
	@Override
	@Transactional
	public List<ReadingDto> getAllReadingsList() {
		try {
			List<Reading> readingList = readingsRepository.findAll();

			List<ReadingDto> readingDtoList = new ArrayList<ReadingDto>();

			if (!(readingList == null || readingList.size() == 0)) {
				for (Reading reading : readingList) {

					ReadingDto readingDto = new ReadingDto();
					readingDto = modelMapper.map(reading, ReadingDto.class);
					// BeanUtils.copyProperties(event, eventsDto);
					readingDtoList.add(readingDto);
				}
			}
			return readingDtoList;
		} catch (Exception e) {
			return null;
		}

	}
}
