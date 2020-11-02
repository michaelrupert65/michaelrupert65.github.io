package com.arteach.main.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer teacherID;
	private String firstName;
	private String lastName;
	private String tAddress;
	private String tCity;
	private String tState;
	private String tZipCode;
	private String tCountry;
	private String tRegion;
	@Column(unique=true) 		
	@Email(message = "Email must be in correct format" )
	private String teacherEmail;
	@Column(columnDefinition = "boolean default true")
	private Boolean uEnabled;	
	private String tRole;
	private String tPassword;
	@OneToMany(targetEntity = Course.class)
	private List<Course> tCourse;
	@ManyToMany(targetEntity = Discipline.class)
	@JoinTable(name="teacher_discipline", joinColumns = @JoinColumn(name = "teacherID"), inverseJoinColumns = @JoinColumn(name="disciplineId"))
	private Set<Discipline> discipline;
	//constructors
	public Teacher() {
		this.discipline = new HashSet<>();
	}

	public Teacher( Integer teacherID, String firstName, String lastName,
			String tAddress, String tCity, String tState, String tZipCode, String tCountry, String tRegion,
			String teacherEmail, Boolean uEnabled,  String tRole,
			String tPassword, List<Course> tCourse, Set<Discipline> discipline) {
		this();
		this.teacherID = teacherID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tAddress = tAddress;
		this.tCity = tCity;
		this.tState = tState;
		this.tZipCode = tZipCode;
		this.tCountry = tCountry;
		this.tRegion = tRegion;
		this.teacherEmail = teacherEmail;
		this.uEnabled = uEnabled;
		this.tRole = tRole;
		this.tPassword = tPassword;
		this.tCourse = tCourse;
		this.discipline = discipline;
	}

	//getters and setters
	
	public Integer getTeacherID() {
		return teacherID;
	}
	public String gettZipCode() {
		return tZipCode;
	}
	public void settZipCode(String tZipCode) {
		this.tZipCode = tZipCode;
	}
	public void setTeacherID(Integer teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}
	public Boolean getuEnabled() {
		return uEnabled;
	}
	public void setuEnabled(Boolean uEnabled) {
		this.uEnabled = uEnabled;
	}
	public String getuRole() {
		return tRole;
	}
	public void setuRole(String uRole) {
		this.tRole = uRole;
	}
	public String getuPassword() {
		return tPassword;
	}
	public void setuPassword(String uPassword) {
		this.tPassword = uPassword;
	}
	public List<Course> getCourse() {
		return tCourse;
	}
	public void setCourse(List<Course> course) {
		this.tCourse = course;
	}
	public Set<Discipline> getDiscipline() {
		return discipline;
	}
	public void setDiscipline(Set<Discipline> discipline) {
		this.discipline = discipline;
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
	public String gettAddress() {
		return tAddress;
	}
	public void settAddress(String tAddress) {
		this.tAddress = tAddress;
	}
	public String gettCity() {
		return tCity;
	}
	public void settCity(String tCity) {
		this.tCity = tCity;
	}
	public String gettState() {
		return tState;
	}
	public void settState(String tState) {
		this.tState = tState;
	}
	public String gettCountry() {
		return tCountry;
	}
	public void settCountry(String tCountry) {
		this.tCountry = tCountry;
	}
	public String gettRegion() {
		return tRegion;
	}
	public void settRegion(String tRegion) {
		this.tRegion = tRegion;
	}
	public String gettRole() {
		return tRole;
	}
	public void settRole(String tRole) {
		this.tRole = tRole;
	}
	public String gettPassword() {
		return tPassword;
	}
	public void settPassword(String tPassword) {
		this.tPassword = tPassword;
	}
	public List<Course> gettCourse() {
		return tCourse;
	}
	public void settCourse(List<Course> tCourse) {
		this.tCourse = tCourse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discipline == null) ? 0 : discipline.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((tAddress == null) ? 0 : tAddress.hashCode());
		result = prime * result + ((tCity == null) ? 0 : tCity.hashCode());
		result = prime * result + ((tCountry == null) ? 0 : tCountry.hashCode());
		result = prime * result + ((tCourse == null) ? 0 : tCourse.hashCode());
		result = prime * result + ((tPassword == null) ? 0 : tPassword.hashCode());
		result = prime * result + ((tRegion == null) ? 0 : tRegion.hashCode());
		result = prime * result + ((tRole == null) ? 0 : tRole.hashCode());
		result = prime * result + ((tState == null) ? 0 : tState.hashCode());
		result = prime * result + ((tZipCode == null) ? 0 : tZipCode.hashCode());
		result = prime * result + ((teacherEmail == null) ? 0 : teacherEmail.hashCode());
		result = prime * result + ((teacherID == null) ? 0 : teacherID.hashCode());
		result = prime * result + ((uEnabled == null) ? 0 : uEnabled.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (discipline == null) {
			if (other.discipline != null)
				return false;
		} else if (!discipline.equals(other.discipline))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (tAddress == null) {
			if (other.tAddress != null)
				return false;
		} else if (!tAddress.equals(other.tAddress))
			return false;
		if (tCity == null) {
			if (other.tCity != null)
				return false;
		} else if (!tCity.equals(other.tCity))
			return false;
		if (tCountry == null) {
			if (other.tCountry != null)
				return false;
		} else if (!tCountry.equals(other.tCountry))
			return false;
		if (tCourse == null) {
			if (other.tCourse != null)
				return false;
		} else if (!tCourse.equals(other.tCourse))
			return false;
		if (tPassword == null) {
			if (other.tPassword != null)
				return false;
		} else if (!tPassword.equals(other.tPassword))
			return false;
		if (tRegion == null) {
			if (other.tRegion != null)
				return false;
		} else if (!tRegion.equals(other.tRegion))
			return false;
		if (tRole == null) {
			if (other.tRole != null)
				return false;
		} else if (!tRole.equals(other.tRole))
			return false;
		if (tState == null) {
			if (other.tState != null)
				return false;
		} else if (!tState.equals(other.tState))
			return false;
		if (tZipCode == null) {
			if (other.tZipCode != null)
				return false;
		} else if (!tZipCode.equals(other.tZipCode))
			return false;
		if (teacherEmail == null) {
			if (other.teacherEmail != null)
				return false;
		} else if (!teacherEmail.equals(other.teacherEmail))
			return false;
		if (teacherID == null) {
			if (other.teacherID != null)
				return false;
		} else if (!teacherID.equals(other.teacherID))
			return false;
		if (uEnabled == null) {
			if (other.uEnabled != null)
				return false;
		} else if (!uEnabled.equals(other.uEnabled))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Teacher [teacherID=" + teacherID + ", firstName=" + firstName + ", lastName=" + lastName + ", tAddress="
				+ tAddress + ", tCity=" + tCity + ", tState=" + tState + ", tZipCode=" + tZipCode + ", tCountry="
				+ tCountry + ", tRegion=" + tRegion + ", teacherEmail=" + teacherEmail + ", uEnabled=" + uEnabled
				+ ", tRole=" + tRole + ", tPassword=" + tPassword + ", tCourse=" + tCourse + ", discipline="
				+ discipline + "]";
	}
	
}
