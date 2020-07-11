package com.church.demo.service;

import java.util.Date;
import java.util.List;

import com.church.demo.dto.FamilyDto;
import com.church.demo.dto.MemberDto;
import com.church.demo.dto.Reading_MemberMapDto;

public interface ReadingMemberMapService {

	public List<Reading_MemberMapDto> findFamilyReadingsMapfromCurrentDate(Date date, FamilyDto familyDto);

	public List<Reading_MemberMapDto> getAllReadingMapList();

	public void saveReadingMap(Reading_MemberMapDto reading_MemberMapDto);

	public Reading_MemberMapDto findReadingMapById(Integer id);

	public void deleteReadingMap(Integer id);
}
