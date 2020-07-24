package com.church.demo.service;

import java.util.List;

import com.church.demo.dto.MemberDto;

public interface MemberService {

	public List<MemberDto> getAllMemberList();

	void saveMember(MemberDto memberDto);

	void deleteMember(Integer id);

	MemberDto findMemberById(Integer id);
}
