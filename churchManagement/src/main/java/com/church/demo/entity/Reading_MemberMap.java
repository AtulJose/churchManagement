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
@Table(name="tb_reading_Memb_map")
public class Reading_MemberMap {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="readingMapId")
	private Integer readingMapId;


	@Column(name="readingDate")
	@Temporal(TemporalType.DATE)
	private Date readingDate;
	
	@ManyToOne
	@JoinColumn(name = "fk_memberId")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "fk_readingId")
	private Reading reading;

	@Column(name="readingDesc")
	private String readingDesc;
	
	public Date getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(Date readingDate) {
		this.readingDate = readingDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Reading getReading() {
		return reading;
	}

	public void setReading(Reading reading) {
		this.reading = reading;
	}
	public Integer getReadingMapId() {
		return readingMapId;
	}

	public void setReadingMapId(Integer readingMapId) {
		this.readingMapId = readingMapId;
	}

	public String getReadingDesc() {
		return readingDesc;
	}

	public void setReadingDesc(String readingDesc) {
		this.readingDesc = readingDesc;
	}
}
