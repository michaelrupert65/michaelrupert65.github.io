package com.arteach.main.models;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	private String mFirstName;
	private String mLastName;
	private String mAddress;
	private String mCity;
	private String mState;
	private String mCountry;
	private String mRegion;
	private String mPassword;
	private String mZipCode;
	private String mRole;
	@Column(unique=true)	
	@Email(message = "Email must be in correct format" )
	private String memberEmail;
	@OneToMany(targetEntity = Course.class)
	private List<Course> mCourse;
	
	//Constructors
	public Member() {
		
	}


	public Member(Integer memberId, String mFirstName, String mLastName,
			String mAddress, String mCity, String mState, String mCountry, String mRegion, String mPassword,
			String mZipCode, String mRole,  String memberEmail) {
		
		this.memberId = memberId;
		this.mFirstName = mFirstName;
		this.mLastName = mLastName;
		this.mAddress = mAddress;
		this.mCity = mCity;
		this.mState = mState;
		this.mCountry = mCountry;
		this.mRegion = mRegion;
		this.mPassword = mPassword;
		this.mZipCode = mZipCode;
		this.mRole = mRole;
		this.memberEmail = memberEmail;
	}
	public Member( String mFirstName, String mLastName,
			String mAddress, String mCity, String mState, String mCountry, String mRegion, String mPassword,
			String mZipCode, String mRole,  String memberEmail) {
		
	
		this.mFirstName = mFirstName;
		this.mLastName = mLastName;
		this.mAddress = mAddress;
		this.mCity = mCity;
		this.mState = mState;
		this.mCountry = mCountry;
		this.mRegion = mRegion;
		this.mPassword = mPassword;
		this.mZipCode = mZipCode;
		this.mRole = mRole;
		this.memberEmail = memberEmail;
	}

	public String getmRole() {
		return mRole;
	}


	public void setmRole(String mRole) {
		this.mRole = mRole;
	}


	public Member(String mPassword, String memberEmail) {
		
		this.mPassword = mPassword;
		this.memberEmail = memberEmail;
	}


	public Member(@NotNull(message = "Field is required!") Integer memberId, String firstName, String lastName,
			String memberEmail, List<Course> course) {
		this();
		this.memberId = memberId;
		this.mFirstName = firstName;
		this.mLastName = lastName;
		this.memberEmail = memberEmail;
		this.mCourse = course;
	}
	//Getters and Setters

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}	

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public List<Course> getCourse() {
		return mCourse;
	}

	public void setCourse(List<Course> course) {
		this.mCourse = course;
	}

	public String getmFirstName() {
		return mFirstName;
	}

	public void setmFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
	}

	public String getmLastName() {
		return mLastName;
	}

	public void setmLastName(String mLastName) {
		this.mLastName = mLastName;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public String getmCity() {
		return mCity;
	}

	public void setmCity(String mCity) {
		this.mCity = mCity;
	}

	public String getmState() {
		return mState;
	}

	public void setmState(String mState) {
		this.mState = mState;
	}

	public String getmCountry() {
		return mCountry;
	}

	public void setmCountry(String mCountry) {
		this.mCountry = mCountry;
	}

	public String getmRegion() {
		return mRegion;
	}

	public void setmRegion(String mRegion) {
		this.mRegion = mRegion;
	}

	public List<Course> getmCourse() {
		return mCourse;
	}

	public void setmCourse(List<Course> mCourse) {
		this.mCourse = mCourse;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}


	public String getmZipCode() {
		return mZipCode;
	}


	public void setmZipCode(String mZipCode) {
		this.mZipCode = mZipCode;
	}
	
	
	

}
