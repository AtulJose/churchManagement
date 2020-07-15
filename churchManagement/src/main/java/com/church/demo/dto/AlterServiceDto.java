package com.church.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.church.demo.entity.AlterService_MemberMap;


public class AlterServiceDto {
	private Integer alterServiceId;
	
	private String alterServiceType;
	
	private List<AlterService_MemberMapDto> alterServiceMemberMapList;

	public Integer getAlterServiceId() {
		return alterServiceId;
	}

	public void setAlterServiceId(Integer alterServiceId) {
		this.alterServiceId = alterServiceId;
	}

	public String getAlterServiceType() {
		return alterServiceType;
	}

	public void setAlterServiceType(String alterServiceType) {
		this.alterServiceType = alterServiceType;
	}

	public List<AlterService_MemberMapDto> getAlterServiceMemberMapList() {
		return alterServiceMemberMapList;
	}

	public void setAlterServiceMemberMapList(List<AlterService_MemberMapDto> alterServiceMemberMapList) {
		this.alterServiceMemberMapList = alterServiceMemberMapList;
	}


}
