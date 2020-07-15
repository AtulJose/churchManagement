package com.church.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.church.demo.dto.MemberDto;
import com.church.demo.dto.AlterServiceDto;
import com.church.demo.dto.AlterService_MemberMapDto;
import com.church.demo.entity.AlterService;

import com.church.demo.service.MemberService;
import com.church.demo.service.AlterServiceMemberMapService;
import com.church.demo.service.AlterServiceService;


@Controller
public class AlterServiceController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}


	@Autowired
	private AlterServiceMemberMapService alterServiceMemberMapService;
	
	@Autowired
	private AlterServiceService alterServiceService;
	
	@Autowired
	private MemberService memberService;
	

	@RequestMapping(value = "/alterService")
	public String goToAlterServicePage(Model model, HttpSession session) {
		List<AlterService_MemberMapDto> alterServiceMapDtoList = alterServiceMemberMapService.getAllAlterServiceMapList();
		List<AlterServiceDto> alterServiceDtoList = alterServiceService.getAllAlterServicesList();
		List<MemberDto> memberDtoList = memberService.getAllMemberList();
		AlterService_MemberMapDto alterServiceMapDto = new AlterService_MemberMapDto();
		model.addAttribute("alterServiceMapList", alterServiceMapDtoList);
		model.addAttribute("alterServiceTypeList", alterServiceDtoList);
		model.addAttribute("memberList", memberDtoList);
		model.addAttribute("alterServiceMap", alterServiceMapDto);
		return "alterService";
	}
	
	@RequestMapping(value = "/processAlterService", method = RequestMethod.POST)
	public ModelAndView processEvent(Model model,  @ModelAttribute("alterServiceMap") @Valid AlterService_MemberMapDto alterServiceMapDto,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("alterService");
		modelAndView.addObject("alterServiceMap", alterServiceMapDto);
		
		if(result.hasErrors())
		{
			System.out.println("has errors");
			ModelAndView repopulateModelAndView = new ModelAndView("alterService");
			
			List<AlterService_MemberMapDto> alterServiceMapDtoList = alterServiceMemberMapService.getAllAlterServiceMapList();
			List<AlterServiceDto> alterServiceDtoList = alterServiceService.getAllAlterServicesList();
			List<MemberDto> memberDtoList = memberService.getAllMemberList();
			repopulateModelAndView.addObject("alterServiceMapList", alterServiceMapDtoList);
			repopulateModelAndView.addObject("alterServiceTypeList", alterServiceDtoList);
			repopulateModelAndView.addObject("memberList", memberDtoList);
			repopulateModelAndView.addObject("alterServiceMap", alterServiceMapDto);
			return repopulateModelAndView;
		}
		else
		{ 
			alterServiceMemberMapService.saveAlterServiceMap(alterServiceMapDto);
			System.out.println("All good");
			List<AlterService_MemberMapDto> alterServiceMapDtoList = alterServiceMemberMapService.getAllAlterServiceMapList();
			List<AlterServiceDto> alterServiceDtoList = alterServiceService.getAllAlterServicesList();
			List<MemberDto> memberDtoList = memberService.getAllMemberList();
			modelAndView.addObject("alterServiceMapList", alterServiceMapDtoList);
			modelAndView.addObject("memberList", memberDtoList);
			modelAndView.addObject("alterServiceTypeList", alterServiceDtoList);
			alterServiceMapDto = new AlterService_MemberMapDto();
			modelAndView.addObject("alterServiceMap", alterServiceMapDto);
			
			return modelAndView;
		}
		

	}
	
	@RequestMapping(value = "/clearAlterService", method = RequestMethod.GET)
	public String clearAlterService(Model model) {
		List<AlterService_MemberMapDto> alterServiceMapDtoList = alterServiceMemberMapService.getAllAlterServiceMapList();
		List<AlterServiceDto> alterServiceDtoList = alterServiceService.getAllAlterServicesList();
		List<MemberDto> memberDtoList = memberService.getAllMemberList();
		AlterService_MemberMapDto alterServiceMapDto = new AlterService_MemberMapDto();
		model.addAttribute("alterServiceMapList", alterServiceMapDtoList);
		model.addAttribute("alterServiceTypeList", alterServiceDtoList);
		model.addAttribute("memberList", memberDtoList);
		model.addAttribute("alterServiceMap", alterServiceMapDto);
		return "alterService";

	}

	@RequestMapping(value = "/editAlterService", method = RequestMethod.GET)
	public String editEvent(Model model, @RequestParam("id") Integer id) {

		//

		AlterService_MemberMapDto alterServiceMapDto = alterServiceMemberMapService.findAlterServiceMapById(id);

		List<AlterService_MemberMapDto> alterServiceMapDtoList = alterServiceMemberMapService.getAllAlterServiceMapList();
		List<AlterServiceDto> alterServiceDtoList = alterServiceService.getAllAlterServicesList();
		List<MemberDto> memberDtoList = memberService.getAllMemberList();
		 
		model.addAttribute("alterServiceMapList", alterServiceMapDtoList);
		model.addAttribute("alterServiceTypeList", alterServiceDtoList);
		model.addAttribute("memberList", memberDtoList);
		model.addAttribute("alterServiceMap", alterServiceMapDto);
		return "alterService";

	}
	
	@RequestMapping(value = "/deleteAlterService", method = RequestMethod.GET)
	public String deleteEvent(Model model, @RequestParam("id") Integer id) {

		alterServiceMemberMapService.deleteAlterServiceMap(id);
		clearAlterService(model);
		
		return "alterService";
	}

}
