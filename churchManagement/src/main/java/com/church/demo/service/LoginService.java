package com.church.demo.service;

import com.church.demo.dto.FamilyDto;

public interface LoginService {

	public FamilyDto getUserByUserIdAndPassword(String username,String password);
}
