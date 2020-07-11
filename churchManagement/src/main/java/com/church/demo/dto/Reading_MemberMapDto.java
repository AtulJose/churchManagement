package com.church.demo.dto;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;


public class Reading_MemberMapDto {
	
	private Integer readingMapId;

	@NotNull(message = "Date is not in correct format MM/DD/YYYY")
	@Future
	private Date readingDate;
	
	private MemberDto member;
	
	private ReadingDto reading;

	private String readingDesc;

	public Integer getReadingMapId() {
		return readingMapId;
	}

	public void setReadingMapId(Integer readingMapId) {
		this.readingMapId = readingMapId;
	}

	public Date getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(Date readingDate) {
		this.readingDate = readingDate;
	}

	public MemberDto getMember() {
		return member;
	}

	public void setMember(MemberDto member) {
		this.member = member;
	}

	public ReadingDto getReading() {
		return reading;
	}

	public void setReading(ReadingDto reading) {
		this.reading = reading;
	}

	public String getReadingDesc() {
		return readingDesc;
	}

	public void setReadingDesc(String readingDesc) {
		this.readingDesc = readingDesc;
	}
	

}
