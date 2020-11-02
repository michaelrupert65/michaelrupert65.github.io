package com.arteach.main.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


/**
 * @author Michael
 * Class/Model for handling course information
 *
 */
@Entity
public class Course {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;
	private String courseName;
	@Column(name = "courseDescr",columnDefinition = "TEXT(1500)")
	private String courseDescr;
	@ManyToMany
	@JoinTable(name="course_teacher", joinColumns = @JoinColumn(name = "teacherID"), inverseJoinColumns = @JoinColumn(name="courseId"))
	private Set<Teacher> teacher;
	@ManyToMany
	@JoinTable(name="course_discipline", joinColumns = @JoinColumn(name = "courseId"), inverseJoinColumns = @JoinColumn(name="disciplineId"))
	private Set<Discipline> discipline;
	
	//Constructors
	public Course() {
		this.discipline = new HashSet<>();
		this.teacher = new HashSet<>();
	}

	public Course(Integer courseId, String courseName, String courseDescr,
		Set<Teacher> teacher, Set<Discipline> discipline) {
		this();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescr = courseDescr;
		this.teacher = teacher;
		this.discipline = discipline;
	}
	//Getters and Setters

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescr() {
		return courseDescr;
	}

	public void setCourseDescr(String courseDescr) {
		this.courseDescr = courseDescr;
	}

	public Set<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(Set<Teacher> teacher) {
		this.teacher = teacher;
	}

	public Set<Discipline> getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Set<Discipline> discipline) {
		this.discipline = discipline;
	}


	
}
