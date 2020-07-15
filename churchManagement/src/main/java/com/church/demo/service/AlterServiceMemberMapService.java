package com.church.demo.service;

import java.util.Date;
import java.util.List;

import com.church.demo.dto.AlterService_MemberMapDto;
import com.church.demo.dto.FamilyDto;
import com.church.demo.dto.MemberDto;
import com.church.demo.dto.Reading_MemberMapDto;

public interface AlterServiceMemberMapService {

	public List<AlterService_MemberMapDto> findFamilyAlterServiceMapfromCurrentDate(Date date, FamilyDto familyDto);

	public List<AlterService_MemberMapDto> getAllAlterServiceMapList();

	public void saveAlterServiceMap(AlterService_MemberMapDto alterService_MemberMapDto);

	public AlterService_MemberMapDto findAlterServiceMapById(Integer id);

	public void deleteAlterServiceMap(Integer id);
}
