package com.church.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.demo.dto.AlterServiceDto;
import com.church.demo.entity.AlterService;
import com.church.demo.repository.AlterServiceRepository;

@Service
public class AlterServiceServiceImpl implements AlterServiceService {

	@Autowired
	private AlterServiceRepository alterServicesRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional
	public List<AlterServiceDto> getAllAlterServicesList() {
		try {
			List<AlterService> alterServiceList = alterServicesRepository.findAll();

			List<AlterServiceDto> alterServiceDtoList = new ArrayList<AlterServiceDto>();

			if (!(alterServiceList == null || alterServiceList.size() == 0)) {
				for (AlterService alterService : alterServiceList) {

					AlterServiceDto alterServiceDto = new AlterServiceDto();
					alterServiceDto = modelMapper.map(alterService, AlterServiceDto.class);
					// BeanUtils.copyProperties(event, eventsDto);
					alterServiceDtoList.add(alterServiceDto);
				}
			}
			return alterServiceDtoList;
		} catch (Exception e) {
			return null;
		}

	}
}
