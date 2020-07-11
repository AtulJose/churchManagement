package com.church.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_member")
public class Member {
	@Id
	@Column(name="memberId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer memberId;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	@Column(name="relationshipToFamily")
	private String relationshipToFamily;
	@Column(name="activeStatus")
	private Boolean activeStatus;
	@Column(name="dob")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name="baptismDate")
	@Temporal(TemporalType.DATE)
	private Date baptismDate;
	@Column(name="marriageDate")
	@Temporal(TemporalType.DATE)
	private Date marriageDate;
	@Column(name="holycommunionDate")
	@Temporal(TemporalType.DATE)
	private Date holycommunionDate;
	@Column(name="confirmationDate")
	@Temporal(TemporalType.DATE)
	private Date confirmationDate;
	@Column(name="bibleReadingInterest")
	private Boolean BibleReadingInterest;
	@Column(name="altarService")
	private Boolean altarService;
	@Column(name="sendMail")
	private Boolean sendMail;
	@Column(name="age")
	private Integer age;
	@Column(name="sex")
	private String sex;
	@Column(name="maritalStatus")
	private String maritalStatus;
	
	@ManyToOne
	@JoinColumn(name = "familyId")
	private Family family;
	
	@OneToMany(mappedBy = "member")
	List<Reading_MemberMap> readingMemberMapList;
	
	public List<Reading_MemberMap> getReadingMemberMapList() {
		return readingMemberMapList;
	}
	public void setReadingMemberMapList(List<Reading_MemberMap> readingMemberMapList) {
		this.readingMemberMapList = readingMemberMapList;
	}
	public Family getFamily() {
		return family;
	}
	public void setFamily(Family family) {
		this.family = family;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getFirstName() {
		return firstName;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
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
	
}
