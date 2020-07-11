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
@Table(name="tb_reading")
public class Reading {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="readingId")
	private Integer readingId;
	@Column(name="readingType")
	private String readingType;
	
	@OneToMany(mappedBy = "reading")
	private List<Reading_MemberMap> readingMemberMapList;

	
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

	public List<Reading_MemberMap> getReadingMemberMapList() {
		return readingMemberMapList;
	}

	public void setReadingMemberMapList(List<Reading_MemberMap> readingMemberMapList) {
		this.readingMemberMapList = readingMemberMapList;
	}
	
}
