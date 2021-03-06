package com.church.demo.service;

import java.util.List;

import com.church.demo.dto.FamilyDto;


public interface FamilyService {

	List<FamilyDto> getAllFamilyList();

	void saveFamily(FamilyDto familyDto);
	
	void deleteFamily(Integer id);
	
	FamilyDto findFamilyById(Integer id);
}
