package com.church.demo.dto;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.church.demo.entity.Ward;

public class EventsDto {
	private Integer eventId;
	
	@NotNull
	@Size(min = 2,max = 20, message = "Name must be atleast 2 charecters and less than 20")
	private String eventName;
	
	@NotNull(message = "Date is not in correct format MM/DD/YYYY")
	@Future
	private Date eventDate;
	
	@NotNull(message="Type is required")
	private String eventType;

	private String eventDesc;
	
	private WardDto ward;
	
	public WardDto getWard() {
		return ward;
	}

	public void setWard(WardDto ward) {
		this.ward = ward;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

}
