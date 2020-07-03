package com.church.demo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.church.demo.dto.FamilyDto;
import com.church.demo.entity.Family;
import com.church.demo.repository.FamilyRepository;



@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private FamilyRepository familyRepository;
	
	
	@Transactional
	public FamilyDto getUserByUserIdAndPassword(String userId,String password) {
		
		try {
			Family family = familyRepository.findByUserIdAndPassword(userId,password);
			
			
			if(family == null) {
				return null;
			}else {
				FamilyDto familyDto = new FamilyDto();
				
				BeanUtils.copyProperties(family, familyDto);
				
				return familyDto;
			}
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
		
		
		
	}

}
