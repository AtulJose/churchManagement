package com.church.demo.dto;

import java.util.List;


public class ReadingDto {
	private Integer readingId;
	private String readingType;
	
	private List<Reading_MemberMapDto> readingMemberMapList;

	public Integer getReadingId() {
		return readingId;
	}

	public void setReadingId(Integer readingId) {
		this.readingId = readingId;
	}

	public String getReadingType() {
		return readingType;
	}

	public void setReadingType(String readingType) {
		this.readingType = readingType;
	}

	public List<Reading_MemberMapDto> getReadingMemberMapList() {
		return readingMemberMapList;
	}

	public void setReadingMemberMapList(List<Reading_MemberMapDto> readingMemberMapList) {
		this.readingMemberMapList = readingMemberMapList;
	}
	

}
