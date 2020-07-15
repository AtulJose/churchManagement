package com.church.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.demo.dto.AlterService_MemberMapDto;
import com.church.demo.dto.EventsDto;
import com.church.demo.dto.FamilyDto;
import com.church.demo.dto.MemberDto;
import com.church.demo.dto.AlterServiceDto;
import com.church.demo.dto.AlterService_MemberMapDto;
import com.church.demo.entity.AlterService_MemberMap;
import com.church.demo.entity.Events;
import com.church.demo.entity.Member;
import com.church.demo.entity.AlterService;
import com.church.demo.entity.AlterService_MemberMap;
import com.church.demo.repository.AlterServiceMemberMapRepository;
import com.church.demo.repository.AlterServiceRepository;
import com.church.demo.repository.EventsRepository;
import com.church.demo.repository.AlterServiceMemberMapRepository;

@Service
public class AlterServiceMemberMapServiceImpl implements AlterServiceMemberMapService {

	@Autowired
	private AlterServiceMemberMapRepository alterServiceMemberMapRepository;

	@Autowired
	private FamilyService familyService;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional
	public List<AlterService_MemberMapDto> findFamilyAlterServiceMapfromCurrentDate(Date date, FamilyDto familyDto) {
		try {

			List<AlterService_MemberMapDto> alterServiceMapDtoList = new ArrayList<AlterService_MemberMapDto>();
			// List<AlterService_MemberMap> alterServiceMapList = new ArrayList<AlterService_MemberMap>();
			List<MemberDto> memberDtoList = familyDto.getMemberList();
			for (MemberDto memberDto : memberDtoList) {
				Member member = modelMapper.map(memberDto, Member.class);
				List<AlterService_MemberMap> alterServiceMapList = alterServiceMemberMapRepository
						.findMemberAlterServicegMapfromCurrentDate(date, member.getMemberId());

				if (!(alterServiceMapList == null || alterServiceMapList.size() == 0)) {
					for (AlterService_MemberMap alterServiceMap : alterServiceMapList) {

						AlterService_MemberMapDto alterServiceMapDto = new AlterService_MemberMapDto();
						alterServiceMapDto = modelMapper.map(alterServiceMap, AlterService_MemberMapDto.class);
						// BeanUtils.copyProperties(event, eventsDto);
						alterServiceMapDtoList.add(alterServiceMapDto);
					}
				}
			}
			return alterServiceMapDtoList;
		} catch (Exception e) {
			return null;
		}
	}


	

	@Override
	@Transactional
	public List<AlterService_MemberMapDto> getAllAlterServiceMapList() {
		try {
			List<AlterService_MemberMap> alterServiceMapList = alterServiceMemberMapRepository.findAll();

			List<AlterService_MemberMapDto> alterServiceMapDtoList = new ArrayList<AlterService_MemberMapDto>();

			if (!(alterServiceMapList == null || alterServiceMapList.size() == 0)) {
				for (AlterService_MemberMap AlterServiceMap : alterServiceMapList) {

					AlterService_MemberMapDto alterServiceMapDto = new AlterService_MemberMapDto();
					alterServiceMapDto = modelMapper.map(AlterServiceMap, AlterService_MemberMapDto.class);
					// BeanUtils.copyProperties(event, eventsDto);
					alterServiceMapDtoList.add(alterServiceMapDto);
				}
			}
			return alterServiceMapDtoList;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void saveAlterServiceMap(AlterService_MemberMapDto alterService_MemberMapDto) {
		try {
			AlterService_MemberMap alterServiceMap = new AlterService_MemberMap();
			alterServiceMap = modelMapper.map(alterService_MemberMapDto, AlterService_MemberMap.class);
			// BeanUtils.copyProperties(eventsDto,event);
			alterServiceMemberMapRepository.save(alterServiceMap);
		} catch (Exception e) {

		}
		
	}

	@Override
	@Transactional
	public AlterService_MemberMapDto findAlterServiceMapById(Integer id) {
		try {
			AlterService_MemberMap alterServiceMap = alterServiceMemberMapRepository.getOne(id);
			AlterService_MemberMapDto alterService_MemberMapDto = new AlterService_MemberMapDto();
			alterService_MemberMapDto = modelMapper.map(alterServiceMap, AlterService_MemberMapDto.class);
			// BeanUtils.copyProperties(event,eventsDto);
			return alterService_MemberMapDto;
		} catch (Exception e) {
			return null;

		}
	}

	@Override
	@Transactional
	public void deleteAlterServiceMap(Integer id) {
		try {
			alterServiceMemberMapRepository.deleteById(id);
		} catch (Exception e) {

		}
		
	}

}
