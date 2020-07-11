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
@Table(name="tb_ward")
public class Ward {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="wardId")
	private Integer wardId;
	@Column(name="wardName")
	private String wardName;

	@OneToMany(mappedBy = "ward")
	List<Events> eventList;
	
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
