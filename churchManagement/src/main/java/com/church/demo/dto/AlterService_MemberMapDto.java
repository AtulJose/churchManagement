package com.church.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import com.church.demo.entity.Member;
import com.church.demo.entity.Reading;


public class AlterService_MemberMapDto {
	
	@NotNull(message = "Date is not in correct format MM/DD/YYYY")
	@Future
	private Date alterServiceDate;
	
	private Integer alterServiceMapId;

	private MemberDto member;
	
	private AlterServiceDto alterService;

	public Date getAlterServiceDate() {
		return alterServiceDate;
	}

	public void setAlterServiceDate(Date alterServiceDate) {
		this.alterServiceDate = alterServiceDate;
	}

	public Integer getAlterServiceMapId() {
		return alterServiceMapId;
	}

	public void setAlterServiceMapId(Integer alterServiceMapId) {
		this.alterServiceMapId = alterServiceMapId;
	}

	public MemberDto getMember() {
		return member;
	}

	public void setMember(MemberDto member) {
		this.member = member;
	}

	public AlterServiceDto getAlterService() {
		return alterService;
	}

	public void setAlterService(AlterServiceDto alterService) {
		this.alterService = alterService;
	}

	

}
