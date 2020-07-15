package com.church.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_alterService_Memb_map")
public class AlterService_MemberMap {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="alterServiceMapId")
	private Integer alterServiceMapId;


	@Column(name="alterServiceDate")
	@Temporal(TemporalType.DATE)
	private Date alterServiceDate;
	
	@ManyToOne
	@JoinColumn(name = "fk_memberId")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "fk_alterServiceId")
	private AlterService alterService;

	public Integer getAlterServiceMapId() {
		return alterServiceMapId;
	}

	public void setAlterServiceMapId(Integer alterServiceMapId) {
		this.alterServiceMapId = alterServiceMapId;
	}

	public Date getAlterServiceDate() {
		return alterServiceDate;
	}

	public void setAlterServiceDate(Date alterServiceDate) {
		this.alterServiceDate = alterServiceDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public AlterService getAlterService() {
		return alterService;
	}

	public void setAlterService(AlterService alterService) {
		this.alterService = alterService;
	}

}
