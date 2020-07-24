package com.church.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.demo.dto.MemberDto;
import com.church.demo.entity.Member;


import com.church.demo.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional
	public List<MemberDto> getAllMemberList() {
		try {
			List<Member> memberList = memberRepository.findAll();

			List<MemberDto> memberDtoList = new ArrayList<MemberDto>();

			if (!(memberList == null || memberList.size() == 0)) {
				for (Member member : memberList) {

					MemberDto memberDto = new MemberDto();
					memberDto = modelMapper.map(member, MemberDto.class);
					// BeanUtils.copyProperties(event, eventsDto);
					memberDtoList.add(memberDto);
				}
			}
			return memberDtoList;
		} catch (Exception e) {
			return null;
		}

	}
	
	@Override
	@Transactional
	public void saveMember(MemberDto memberDto) {
		try {
			Member member = new Member();
			member = modelMapper.map(memberDto, Member.class);
			// BeanUtils.copyProperties(eventsDto,event);
			memberRepository.save(member);
		} catch (Exception e) {

		}
		
	}

	@Override
	@Transactional
	public void deleteMember(Integer id) {
		try {
			memberRepository.deleteById(id);
		} catch (Exception e) {

		}
	}

	@Override
	@Transactional
	public MemberDto findMemberById(Integer id) {
		try {
			Member member = memberRepository.getOne(id);
			MemberDto memberDto = new MemberDto();
			memberDto = modelMapper.map(member, MemberDto.class);
			return memberDto;
		} catch (Exception e) {
			return null;

		}
	}
}
