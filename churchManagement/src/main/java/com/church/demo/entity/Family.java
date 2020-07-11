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
@Table(name="tb_family")
public class Family {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="familyId")
	private Integer familyId;
	
	@Column(name="familyName")
	private String familyName;

	@Column(name="city")
	private String city;
	
	@Column(name="addressLn1")
	private String addressLn1;
	
	@Column(name="addressLn2")
	private String addressLn2;
	
	@Column(name="zip")
	private Integer zip;
	
	@Column(name="state")
	private String state;
	
	@Column(name="nativePlace")
	private String nativePlace;
	
	@Column(name="userId")
	private String userId;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "family")
	List<Member> memberList;
	
	public List<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	
	public Family() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getFamilyId() {
		return familyId;
	}
	
	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddressLn1() {
		return addressLn1;
	}
	public void setAddressLn1(String addressLn1) {
		this.addressLn1 = addressLn1;
	}
	public String getAddressLn2() {
		return addressLn2;
	}
	public void setAddressLn2(String addressLn2) {
		this.addressLn2 = addressLn2;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
