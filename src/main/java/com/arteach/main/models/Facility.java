package com.arteach.main.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Facility {

	/**
	 *  This class/model handles things dealing with facility
	 *  
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer facilityId;
	private String facilityName;
	private String fAddress;
	private String fCity;
	private String fState;
	private String fZipCode;
	private String fCountry;
	private String fRegion;
	@OneToMany(targetEntity = Course.class)
	private List<Course> fCourse;

	// Constructors
	public Facility() {

	}

	public Facility(@NotNull(message = "Field is required!") Integer facilityId, String facilityName, String fAddress,
			String fCity, String fState, String fZipCode, String fCountry, String fRegion, List<Course> fCourse) {
		super();
		this.facilityId = facilityId;
		this.facilityName = facilityName;
		this.fAddress = fAddress;
		this.fCity = fCity;
		this.fState = fState;
		this.fZipCode = fZipCode;
		this.fCountry = fCountry;
		this.fRegion = fRegion;
		this.fCourse = fCourse;
	}
	// Getters and Setters

	public Integer getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getfAddress() {
		return fAddress;
	}

	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
	}

	public String getfCity() {
		return fCity;
	}

	public void setfCity(String fCity) {
		this.fCity = fCity;
	}

	public String getfState() {
		return fState;
	}

	public void setfState(String fState) {
		this.fState = fState;
	}

	public String getfZipCode() {
		return fZipCode;
	}

	public void setfZipCode(String fZipCode) {
		this.fZipCode = fZipCode;
	}

	public String getfCountry() {
		return fCountry;
	}

	public void setfCountry(String fCountry) {
		this.fCountry = fCountry;
	}

	public String getfRegion() {
		return fRegion;
	}

	public void setfRegion(String fRegion) {
		this.fRegion = fRegion;
	}

	public List<Course> getfCourse() {
		return fCourse;
	}

	public void setfCourse(List<Course> fCourse) {
		this.fCourse = fCourse;
	}

}
