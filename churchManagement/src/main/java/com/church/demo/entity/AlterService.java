package com.church.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_alterService")
public class AlterService {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="alterServiceId")
	private Integer alterServiceId;
	@Column(name="alterServiceType")
	private String alterServiceType;
	
	@OneToMany(mappedBy = "alterService")
	private List<AlterService_MemberMap> alterServiceMemberMapList;

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

	public List<AlterService_MemberMap> getAlterServiceMemberMapList() {
		return alterServiceMemberMapList;
	}

	public void setAlterServiceMemberMapList(List<AlterService_MemberMap> alterServiceMemberMapList) {
		this.alterServiceMemberMapList = alterServiceMemberMapList;
	}

	
}
