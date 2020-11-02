package com.arteach.main.models;

import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Michael Rupert
 * Class/model for all things in an event
 */
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eventId;
	private String eventName;
	private String eventAddress;
	private String eventCity;
	private String eventState;
	private String eventZip;
	private String eventCountry;
	private String eventRegion;
	private String eDescription;
	private String eTeacherName;
	//@ManyToOne(targetEntity = Teacher.class)
	private String eTeacherEmail;
	private String eFacilityName;
	@ManyToOne(targetEntity = Facility.class)
	private List<Facility> facility;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date eventDate;
	//Constructors
	public Event() {
		
	}

	public Event(@NotNull(message = "Field is required!") Integer eventId, String eventName, String eventAddress,
			String eventCity, String eventState, String eventZip, String eventCountry, String eventRegion,
			String eDescription, List<Facility> facility, Date eventDate) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventAddress = eventAddress;
		this.eventCity = eventCity;
		this.eventState = eventState;
		this.eventZip = eventZip;
		this.eventCountry = eventCountry;
		this.eventRegion = eventRegion;
		this.eDescription = eDescription;
		this.facility = facility;
		this.eventDate = eventDate;
	}

	//Getters and Setters

	public Integer getEventId() {
		return eventId;
	}

	public String geteDescription() {
		return eDescription;
	}

	public void seteDescription(String eDescription) {
		this.eDescription = eDescription;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public String geteTeacherName() {
		return eTeacherName;
	}

	public void seteTeacherName(String eTeacherName) {
		this.eTeacherName = eTeacherName;
	}

	public String geteTeacherEmail() {
		return eTeacherEmail;
	}

	public void seteTeacherEmail(String eTeacherEmail) {
		this.eTeacherEmail = eTeacherEmail;
	}
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventAddress() {
		return eventAddress;
	}

	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}

	public String getEventCity() {
		return eventCity;
	}

	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}

	public String getEventState() {
		return eventState;
	}

	public void setEventState(String eventState) {
		this.eventState = eventState;
	}

	public String getEventZip() {
		return eventZip;
	}

	public void setEventZip(String eventZip) {
		this.eventZip = eventZip;
	}

	public String getEventCountry() {
		return eventCountry;
	}

	public void setEventCountry(String eventCountry) {
		this.eventCountry = eventCountry;
	}

	public String getEventRegion() {
		return eventRegion;
	}

	public void setEventRegion(String eventRegion) {
		this.eventRegion = eventRegion;
	}

	public List<Facility> getFacility() {
		return facility;
	}

	public void setFacility(List<Facility> facility) {
		this.facility = facility;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String geteFacilityName() {
		return eFacilityName;
	}

	public void seteFacilityName(String eFacilityName) {
		this.eFacilityName = eFacilityName;
	}
	
	
	
}
