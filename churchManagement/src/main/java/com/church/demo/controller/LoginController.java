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
import com.church.demo.service.EventService;
import com.church.demo.service.LoginService;


@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "/login")
	public String goToLoginPage()
	{

		return "login";
	}
	
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(Model model,HttpSession session,@RequestParam("userId") String userId,@RequestParam("password") String password)
	{

		FamilyDto familyDto = loginService.getUserByUserIdAndPassword(userId, password);
		
		if(familyDto != null) {
		
			Date currentDate = new Date(); 
			//List<EventsDto> upcomingEventsDtos = eventService.findEventsfromCurrentDate(currentDate);
			

			session.setAttribute("family", familyDto);
			//model.addAttribute("upcomingEventsList", upcomingEventsDtos);
			
			return "redirect:/home";
		}else {
			return "login";
		}
		
	}
}
