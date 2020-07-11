package com.church.demo.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.church.demo.dto.FamilyDto;
import com.church.demo.service.FamilyService;

@Controller
public class ContactListController {
	
	
	@Autowired
	private FamilyService familyService;

	@RequestMapping(value = "/contactList")
	public String goToLoginPage(Model model, HttpSession session) {
		List<FamilyDto> familyDtoList = familyService.getAllFamilyList();
		model.addAttribute("familyList", familyDtoList);
		return "contactList";
	}
	
}
