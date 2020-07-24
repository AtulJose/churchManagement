package com.church.demo.dto;

import java.util.List;


public class WardDto {
	private Integer wardId;
	private String wardName;

	private List<EventsDto> eventList;

	public List<EventsDto> getEventList() {
		return eventList;
	}

	public void setEventList(List<EventsDto> eventList) {
		this.eventList = eventList;
	}

	public Integer getWardId() {
		return wardId;
	}

	public void setWardId(Integer wardId) {
		this.wardId = wardId;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

}
