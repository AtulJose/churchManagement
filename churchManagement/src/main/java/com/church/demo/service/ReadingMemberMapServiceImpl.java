package com.church.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.demo.dto.EventsDto;
import com.church.demo.dto.FamilyDto;
import com.church.demo.dto.MemberDto;
import com.church.demo.dto.ReadingDto;
import com.church.demo.dto.Reading_MemberMapDto;
import com.church.demo.entity.Events;
import com.church.demo.entity.Member;
import com.church.demo.entity.Reading;
import com.church.demo.entity.Reading_MemberMap;
import com.church.demo.repository.EventsRepository;
import com.church.demo.repository.ReadingMemberMapRepository;

@Service
public class ReadingMemberMapServiceImpl implements ReadingMemberMapService {

	@Autowired
	private ReadingMemberMapRepository readingMemberMapRepository;

	@Autowired
	private FamilyService familyService;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional
	public List<Reading_MemberMapDto> findFamilyReadingsMapfromCurrentDate(Date date, FamilyDto familyDto) {
		try {

			List<Reading_MemberMapDto> readingMapDtoList = new ArrayList<Reading_MemberMapDto>();
			// List<Reading_MemberMap> readingMapList = new ArrayList<Reading_MemberMap>();
			List<MemberDto> memberDtoList = familyDto.getMemberList();
			for (MemberDto memberDto : memberDtoList) {
				Member member = modelMapper.map(memberDto, Member.class);
				List<Reading_MemberMap> readingMapList = readingMemberMapRepository
						.findMemberReadingMapfromCurrentDate(date, member.getMemberId());

				if (!(readingMapList == null || readingMapList.size() == 0)) {
					for (Reading_MemberMap readingMap : readingMapList) {

						Reading_MemberMapDto readingMapDto = new Reading_MemberMapDto();
						readingMapDto = modelMapper.map(readingMap, Reading_MemberMapDto.class);
						// BeanUtils.copyProperties(event, eventsDto);
						readingMapDtoList.add(readingMapDto);
					}
				}
			}
			return readingMapDtoList;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public List<Reading_MemberMapDto> getAllReadingMapList() {
		try {
			List<Reading_MemberMap> readingMapList = readingMemberMapRepository.findAll();

			List<Reading_MemberMapDto> readingMapDtoList = new ArrayList<Reading_MemberMapDto>();

			if (!(readingMapList == null || readingMapList.size() == 0)) {
				for (Reading_MemberMap ReadingMap : readingMapList) {

					Reading_MemberMapDto readingMapDto = new Reading_MemberMapDto();
					readingMapDto = modelMapper.map(ReadingMap, Reading_MemberMapDto.class);
					// BeanUtils.copyProperties(event, eventsDto);
					readingMapDtoList.add(readingMapDto);
				}
			}
			return readingMapDtoList;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public void saveReadingMap(Reading_MemberMapDto reading_MemberMapDto) {
		try {
			Reading_MemberMap readingMap = new Reading_MemberMap();
			readingMap = modelMapper.map(reading_MemberMapDto, Reading_MemberMap.class);
			// BeanUtils.copyProperties(eventsDto,event);
			readingMemberMapRepository.save(readingMap);
		} catch (Exception e) {

		}

	}

	@Transactional
	public Reading_MemberMapDto findReadingMapById(Integer id) {
		try {
			Reading_MemberMap readingMap = readingMemberMapRepository.getOne(id);
			Reading_MemberMapDto reading_MemberMapDto = new Reading_MemberMapDto();
			reading_MemberMapDto = modelMapper.map(readingMap, Reading_MemberMapDto.class);
			// BeanUtils.copyProperties(event,eventsDto);
			return reading_MemberMapDto;
		} catch (Exception e) {
			return null;

		}
	}

	@Transactional
	public void deleteReadingMap(Integer id) {
		try {
			readingMemberMapRepository.deleteById(id);
		} catch (Exception e) {

		}

	}

}
