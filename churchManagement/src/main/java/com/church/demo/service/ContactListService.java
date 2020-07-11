package com.church.demo.service;

import java.util.Date;
import java.util.List;

import com.church.demo.dto.EventsDto;
import com.church.demo.dto.FamilyDto;
import com.church.demo.dto.MemberDto;

public interface ContactListService {

	public List<FamilyDto> findActiveFamilyMembers();

	public List<FamilyDto> getAllFamilyList();

	public List<MemberDto> getAllMemberList(Integer familyId);

	public void saveFamily(FamilyDto familyDto);

	public void saveFamily(MemberDto memberDto);

	public FamilyDto findFamilyById(Integer id);

	public MemberDto findMemberById(Integer id);

	public void deleteFamily(Integer id);

	public void deleteMember(Integer id);
}
