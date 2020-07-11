package com.church.demo.dto;

import java.util.List;

import com.church.demo.entity.Events;

public class WardDto {
	private Integer wardId;
	private String wardName;
	private List<Events> eventList;

	public List<Events> getEventList() {
		return eventList;
	}

	public void setEventList(List<Events> eventList) {
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
