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

import com.church.demo.dto.EventsDto;
import com.church.demo.dto.MemberDto;
import com.church.demo.dto.ReadingDto;
import com.church.demo.dto.Reading_MemberMapDto;
import com.church.demo.dto.WardDto;
import com.church.demo.entity.Reading;
import com.church.demo.service.EventService;
import com.church.demo.service.MemberService;
import com.church.demo.service.ReadingMemberMapService;
import com.church.demo.service.ReadingService;
import com.church.demo.service.WardService;

@Controller
public class ReadingsController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}


	@Autowired
	private ReadingMemberMapService readingMemberMapService;
	
	@Autowired
	private ReadingService readingService;
	
	@Autowired
	private MemberService memberService;
	

	@RequestMapping(value = "/reading")
	public String goToReadingPage(Model model, HttpSession session) {
		List<Reading_MemberMapDto> readingMapDtoList = readingMemberMapService.getAllReadingMapList();
		List<ReadingDto> readingDtoList = readingService.getAllReadingsList();
		List<MemberDto> memberDtoList = memberService.getAllMemberList();
		Reading_MemberMapDto readingMapDto = new Reading_MemberMapDto();
		model.addAttribute("readingMapList", readingMapDtoList);
		model.addAttribute("readingTypeList", readingDtoList);
		model.addAttribute("memberList", memberDtoList);
		model.addAttribute("readingMap", readingMapDto);
		return "liturgy";
	}
	
	@RequestMapping(value = "/processReading", method = RequestMethod.POST)
	public ModelAndView processEvent(Model model,  @ModelAttribute("readingMap") @Valid Reading_MemberMapDto readingMapDto,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("liturgy");
		modelAndView.addObject("readingMap", readingMapDto);
		
		if(result.hasErrors())
		{
			System.out.println("has errors");
			ModelAndView repopulateModelAndView = new ModelAndView("liturgy");
			
			List<Reading_MemberMapDto> readingMapDtoList = readingMemberMapService.getAllReadingMapList();
			List<ReadingDto> readingDtoList = readingService.getAllReadingsList();
			List<MemberDto> memberDtoList = memberService.getAllMemberList();
			repopulateModelAndView.addObject("readingMapList", readingMapDtoList);
			repopulateModelAndView.addObject("readingTypeList", readingDtoList);
			repopulateModelAndView.addObject("memberList", memberDtoList);
			repopulateModelAndView.addObject("readingMap", readingMapDto);
			return repopulateModelAndView;
		}
		else
		{ 
			readingMemberMapService.saveReadingMap(readingMapDto);
			System.out.println("All good");
			List<Reading_MemberMapDto> readingMapDtoList = readingMemberMapService.getAllReadingMapList();
			List<ReadingDto> readingDtoList = readingService.getAllReadingsList();
			List<MemberDto> memberDtoList = memberService.getAllMemberList();
			modelAndView.addObject("readingMapList", readingMapDtoList);
			modelAndView.addObject("memberList", memberDtoList);
			modelAndView.addObject("readingTypeList", readingDtoList);
			readingMapDto = new Reading_MemberMapDto();
			modelAndView.addObject("readingMap", readingMapDto);
			
			return modelAndView;
		}
		

	}
	
	@RequestMapping(value = "/clearReading", method = RequestMethod.GET)
	public String clearReading(Model model) {
		List<Reading_MemberMapDto> readingMapDtoList = readingMemberMapService.getAllReadingMapList();
		List<ReadingDto> readingDtoList = readingService.getAllReadingsList();
		List<MemberDto> memberDtoList = memberService.getAllMemberList();
		Reading_MemberMapDto readingMapDto = new Reading_MemberMapDto();
		model.addAttribute("readingMapList", readingMapDtoList);
		model.addAttribute("readingTypeList", readingDtoList);
		model.addAttribute("memberList", memberDtoList);
		model.addAttribute("readingMap", readingMapDto);
		return "liturgy";

	}

	@RequestMapping(value = "/editReading", method = RequestMethod.GET)
	public String editEvent(Model model, @RequestParam("id") Integer id) {

		//

		Reading_MemberMapDto readingMapDto = readingMemberMapService.findReadingMapById(id);

		List<Reading_MemberMapDto> readingMapDtoList = readingMemberMapService.getAllReadingMapList();
		List<ReadingDto> readingDtoList = readingService.getAllReadingsList();
		List<MemberDto> memberDtoList = memberService.getAllMemberList();
		 
		model.addAttribute("readingMapList", readingMapDtoList);
		model.addAttribute("readingTypeList", readingDtoList);
		model.addAttribute("memberList", memberDtoList);
		model.addAttribute("readingMap", readingMapDto);
		return "liturgy";

	}
	
	@RequestMapping(value = "/deleteReading", method = RequestMethod.GET)
	public String deleteEvent(Model model, @RequestParam("id") Integer id) {

		readingMemberMapService.deleteReadingMap(id);
		clearReading(model);
		
		return "liturgy";
	}

}
