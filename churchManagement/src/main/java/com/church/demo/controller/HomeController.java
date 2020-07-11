package com.church.demo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.church.demo.dto.EventsDto;
import com.church.demo.dto.FamilyDto;
import com.church.demo.dto.Reading_MemberMapDto;
import com.church.demo.service.EventService;
import com.church.demo.service.ReadingMemberMapService;

@Controller
public class HomeController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private ReadingMemberMapService readingMemberMapService;
	
	@RequestMapping(value = "/home")
	public String goTohome(Model model,HttpSession session)
	{		
		
			Date currentDate = new Date(); 
			List<EventsDto> upcomingEventsDtos = eventService.findEventsfromCurrentDate(currentDate);
			FamilyDto familyDto = (FamilyDto) session.getAttribute("family");
			List<Reading_MemberMapDto> readingMapDtoList = readingMemberMapService.findFamilyReadingsMapfromCurrentDate(currentDate, familyDto);
			
			model.addAttribute("upcomingEventsList", upcomingEventsDtos);
			model.addAttribute("upcomingReadings", readingMapDtoList);
			return "home";
		
	}
}
