package com.church.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.church.demo.dto.FamilyDto;
import com.church.demo.dto.MemberDto;
import com.church.demo.dto.WardDto;
import com.church.demo.service.EventService;
import com.church.demo.service.WardService;

@Controller
public class EventsController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@Autowired
	private EventService eventService;

	@Autowired
	private WardService wardService;

	@RequestMapping(value = "/events")
	public String goToLoginPage(Model model, HttpSession session) {
		EventsDto eventsDto = new EventsDto();
		addModelAttributes(model,eventsDto);
		return "events";
	}

	@RequestMapping(value = "/processEvent", method = RequestMethod.POST)
	public ModelAndView processEvent(Model model, @ModelAttribute("event") @Valid EventsDto eventsDto,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("events");
		modelAndView.addObject("event", eventsDto);

		if (result.hasErrors()) {
			System.out.println("has errors");
			ModelAndView repopulateModelAndView = new ModelAndView("events");
			addModelAttributes(repopulateModelAndView,eventsDto);
			return repopulateModelAndView;
		} else {

			eventService.saveEvent(eventsDto);

			System.out.println("All good");
			eventsDto = new EventsDto();
			addModelAttributes(modelAndView,eventsDto);
			return modelAndView;
		}

	}

	@RequestMapping(value = "/clearEvent", method = RequestMethod.GET)
	public String clearEvent(Model model, @ModelAttribute("event") EventsDto eventsDto) {
		eventsDto = new EventsDto();
		addModelAttributes(model,eventsDto);
		return "events";

	}

	@RequestMapping(value = "/editEvent", method = RequestMethod.GET)
	public String editEvent(Model model, @RequestParam("id") Integer id) {

		EventsDto eventsDto = eventService.findEventById(id);
		addModelAttributes(model,eventsDto);
		return "events";

	}

	@RequestMapping(value = "/deleteEvent", method = RequestMethod.GET)
	public String deleteEvent(Model model, @RequestParam("id") Integer id) {

		eventService.deleteEvent(id);
		EventsDto eventsDto = new EventsDto();
		addModelAttributes(model,eventsDto);
		return "events";

	}
	
//////adding attributes///////////
	public void addModelAttributes(Model model,EventsDto eventsDto)
	{
		List<EventsDto> eventsDtoList = eventService.getAllEventsList();
		List<WardDto> wardDtoList = wardService.getAllWardList();
		model.addAttribute("wardList", wardDtoList);
		model.addAttribute("event", eventsDto);
		model.addAttribute("eventsList", eventsDtoList);
		List<String> eventTypeList = new ArrayList<String>();
		eventTypeList.add("Common");
		eventTypeList.add("Ward");
		model.addAttribute("eventTypeList", eventTypeList);
		
	}
	
	public void addModelAttributes(ModelAndView modelAndView,EventsDto eventsDto)
	{
		List<EventsDto> eventsDtoList = eventService.getAllEventsList();
		List<WardDto> wardDtoList = wardService.getAllWardList();
		modelAndView.addObject("wardList", wardDtoList);
		modelAndView.addObject("event", eventsDto);
		modelAndView.addObject("eventsList", eventsDtoList);
		
		List<String> eventTypeList = new ArrayList<String>();
		eventTypeList.add("Common");
		eventTypeList.add("Ward");
		modelAndView.addObject("eventTypeList", eventTypeList);
	}
}
