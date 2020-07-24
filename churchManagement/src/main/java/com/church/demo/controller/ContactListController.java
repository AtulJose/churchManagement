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
import com.church.demo.service.MemberService;

@Controller
public class ContactListController {
	
	
	@Autowired
	private FamilyService familyService;
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/contactList")
	public String goToLoginPage(Model model) {
		List<FamilyDto> familyDtoList = familyService.getAllFamilyList();
		FamilyDto familyDto = new FamilyDto();
		MemberDto memberDto = new MemberDto();
		addModelAttributes(model,familyDto,memberDto,"Family");
		return "contactList";
	}
	
	@RequestMapping(value = "/processFamily", method = RequestMethod.POST)
	public ModelAndView processFamily(Model model,  @ModelAttribute("family") @Valid FamilyDto familyDto,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("contactList");
		modelAndView.addObject("family", familyDto);
		
		if(result.hasErrors())
		{
			System.out.println("has errors");
			ModelAndView repopulateModelAndView = new ModelAndView("contactList");
			MemberDto memberDto = new MemberDto();
			addModelAttributes(repopulateModelAndView,familyDto,memberDto,"Family");
			return repopulateModelAndView;
		}
		else
		{ 
			familyService.saveFamily(familyDto);
			System.out.println("All good");
			familyDto = new FamilyDto();
			MemberDto memberDto = new MemberDto();
			addModelAttributes(modelAndView,familyDto,memberDto,"Family");
			return modelAndView;
		}
	}
	@RequestMapping(value = "/editFamily", method = RequestMethod.GET)
	public String editFamily(Model model, @RequestParam("id") Integer id) {
		FamilyDto familyDto = familyService.findFamilyById(id);
		MemberDto memberDto = new MemberDto();
		addModelAttributes(model,familyDto,memberDto,"Family");
		return "contactList";

	}
	@RequestMapping(value = "/deleteFamily", method = RequestMethod.GET)
	public String deleteFamily(Model model, @RequestParam("id") Integer id) {

		familyService.deleteFamily(id);
		FamilyDto familyDto = new FamilyDto();
		MemberDto memberDto = new MemberDto();
		addModelAttributes(model,familyDto,memberDto,"Family");
		return "contactList";
	}
	
	@RequestMapping(value = "/clearFamily", method = RequestMethod.GET)
	public String clearFamily(Model model) {
		FamilyDto familyDto = new FamilyDto();
		MemberDto memberDto = new MemberDto();
		addModelAttributes(model,familyDto,memberDto,"Family");
		return "contactList";

	}
	
	
	///////////////////Member functions//////////////////
	
	@RequestMapping(value = "/processMember", method = RequestMethod.POST)
	public ModelAndView processMember(Model model,  @ModelAttribute("member") @Valid MemberDto memberDto,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("contactList");
		modelAndView.addObject("member", memberDto);
		FamilyDto familyDto = new FamilyDto();
		if(result.hasErrors())
		{
			System.out.println("has errors");
			ModelAndView repopulateModelAndView = new ModelAndView("contactList");
			addModelAttributes(repopulateModelAndView,familyDto,memberDto,"Member");
			return repopulateModelAndView;
		}
		else
		{ 
			memberService.saveMember(memberDto);
			System.out.println("All good");
			memberDto = new MemberDto();
			addModelAttributes(modelAndView,familyDto,memberDto,"Member");
			return modelAndView;
		}
	}
	@RequestMapping(value = "/editMember", method = RequestMethod.GET)
	public String editMember(Model model, @RequestParam("id") Integer id) {
		MemberDto memberDto = memberService.findMemberById(id);
		FamilyDto familyDto = new FamilyDto();
		addModelAttributes(model,familyDto,memberDto,"Member");
		return "contactList";

	}
	
	@RequestMapping(value = "/addMember", method = RequestMethod.GET)
	public String addMember(Model model, @RequestParam("id") Integer id) {
		
		MemberDto memberDto = new MemberDto();
		
		FamilyDto familyDto = familyService.findFamilyById(id);
		memberDto.setFamily(familyDto);
		addModelAttributes(model,familyDto,memberDto,"Member");
		return "contactList";

	}
	
	@RequestMapping(value = "/deleteMember", method = RequestMethod.GET)
	public String deleteMember(Model model, @RequestParam("id") Integer id) {
		
		MemberDto memberDto = new MemberDto();
		FamilyDto familyDto = new FamilyDto();
		addModelAttributes(model,familyDto,memberDto,"Member");
		memberService.deleteMember(id);
		goToLoginPage(model);
		
		return "contactList";
	}
	
	@RequestMapping(value = "/clearMember", method = RequestMethod.GET)
	public void clearMember(Model model) {
		goToLoginPage(model);

	}
	
	//////adding attributes///////////
	public void addModelAttributes(Model model,FamilyDto familyDto,MemberDto memberDto,String fieldstoDisplay)
	{
		List<FamilyDto> familyDtoList = familyService.getAllFamilyList();
		model.addAttribute("familyList", familyDtoList);
		model.addAttribute("member", memberDto);
		model.addAttribute("family", familyDto);
		model.addAttribute("fieldFlag", fieldstoDisplay);
	}
	
	public void addModelAttributes(ModelAndView modelAndView,FamilyDto familyDto,MemberDto memberDto,String fieldstoDisplay)
	{
		List<FamilyDto> familyDtoList = familyService.getAllFamilyList();
		modelAndView.addObject("familyList", familyDtoList);
		modelAndView.addObject("member", memberDto);
		modelAndView.addObject("family", familyDto);
		modelAndView.addObject("fieldFlag", fieldstoDisplay);
	}
}
