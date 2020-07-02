package com.church.demo.dto;

import java.io.Serializable;

import javax.persistence.Column;

public class FamilyDto implements Serializable{
	private Integer familyId;
	private String familyName;
	private String street;
	private String city;
	private String addressLn1;
	private String addressLn2;
	private Integer zip;
	private String state;
	private String nativePlace;
	private String userId;
	private String password;
	
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
