package com.church.demo.controller;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.church.demo.dto.AlterServiceDto;
import com.church.demo.dto.AlterService_MemberMapDto;
import com.church.demo.dto.FamilyDto;
import com.church.demo.dto.MemberDto;
import com.church.demo.service.FamilyService;

@Controller
public class ContactListController {
	
	
	@Autowired
	private FamilyService familyService;

	@RequestMapping(value = "/contactList")
	public String goToLoginPage(Model model) {
		List<FamilyDto> familyDtoList = familyService.getAllFamilyList();
		FamilyDto familyDto = new FamilyDto();
		model.addAttribute("familyList", familyDtoList);
		model.addAttribute("family", familyDto);
		return "contactList";
	}
	
	@RequestMapping(value = "/processFamily", method = RequestMethod.POST)
	public ModelAndView processEvent(Model model,  @ModelAttribute("family") @Valid FamilyDto familyDto,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("contactList");
		modelAndView.addObject("family", familyDto);
		
		if(result.hasErrors())
		{
			System.out.println("has errors");
			ModelAndView repopulateModelAndView = new ModelAndView("contactList");
			List<FamilyDto> familyDtoList = familyService.getAllFamilyList();
			repopulateModelAndView.addObject("familyList", familyDtoList);
			repopulateModelAndView.addObject("family", familyDto);
			return repopulateModelAndView;
		}
		else
		{ 
			familyService.saveFamily(familyDto);
			System.out.println("All good");
			List<FamilyDto> familyDtoList = familyService.getAllFamilyList();
			familyDto = new FamilyDto();
			modelAndView.addObject("familyList", familyDtoList);
			modelAndView.addObject("family", familyDto);
			return modelAndView;
		}
	}
	@RequestMapping(value = "/editFamily", method = RequestMethod.GET)
	public String editEvent(Model model, @RequestParam("id") Integer id) {
		FamilyDto familyDto = familyService.findFamilyById(id);
		List<FamilyDto> familyDtoList = familyService.getAllFamilyList();
		model.addAttribute("familyList", familyDtoList);
		model.addAttribute("family", familyDto);
		return "contactList";

	}
	@RequestMapping(value = "/deleteFamily", method = RequestMethod.GET)
	public String deleteEvent(Model model, @RequestParam("id") Integer id) {

		familyService.deleteFamily(id);
		goToLoginPage(model);
		
		return "contactList";
	}
	
	@RequestMapping(value = "/clearFamily", method = RequestMethod.GET)
	public void clearFamily(Model model) {
		goToLoginPage(model);

	}
	
}
