package com.church.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.church.demo.entity.Family;

public class MemberDto {
	private Integer memberId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String relationshipToFamily;
	private Boolean activeStatus;
	private Date dob;
	private Date baptismDate;
	private Date marriageDate;
	private Date holycommunionDate;
	private Date confirmationDate;
	private Boolean BibleReadingInterest;
	private Boolean altarService;
	private Boolean sendMail;
	private String age;
	private String sex;
	private String maritalStatus;
	private FamilyDto family;
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public String getFullName() {
		return firstName+" "+lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRelationshipToFamily() {
		return relationshipToFamily;
	}
	public void setRelationshipToFamily(String relationshipToFamily) {
		this.relationshipToFamily = relationshipToFamily;
	}
	public Boolean getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getBaptismDate() {
		return baptismDate;
	}
	public void setBaptismDate(Date baptismDate) {
		this.baptismDate = baptismDate;
	}
	public Date getMarriageDate() {
		return marriageDate;
	}
	public void setMarriageDate(Date marriageDate) {
		this.marriageDate = marriageDate;
	}
	public Date getHolycommunionDate() {
		return holycommunionDate;
	}
	public void setHolycommunionDate(Date holycommunionDate) {
		this.holycommunionDate = holycommunionDate;
	}
	public Date getConfirmationDate() {
		return confirmationDate;
	}
	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}
	public Boolean getBibleReadingInterest() {
		return BibleReadingInterest;
	}
	public void setBibleReadingInterest(Boolean bibleReadingInterest) {
		BibleReadingInterest = bibleReadingInterest;
	}
	public Boolean getAltarService() {
		return altarService;
	}
	public void setAltarService(Boolean altarService) {
		this.altarService = altarService;
	}
	public Boolean getSendMail() {
		return sendMail;
	}
	public void setSendMail(Boolean sendMail) {
		this.sendMail = sendMail;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public FamilyDto getFamily() {
		return family;
	}
	public void setFamily(FamilyDto family) {
		this.family = family;
	}
	
	
}
