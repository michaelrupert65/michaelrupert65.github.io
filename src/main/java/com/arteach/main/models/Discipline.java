package com.arteach.main.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


/**
 * @author Michael
 * This class/models all things discipline
 *
 */
@Entity
public class Discipline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer disciplineId;
	@Column(unique = true)
	private String disciplineName;
	@Column(name = "dDescription",columnDefinition = "TEXT(1500)")
	private String dDescription;
	@ManyToMany(mappedBy="discipline")
	Set<Teacher> teacherDisciple;
	
	//Constructor
	public Discipline() {
		
	}

	public Discipline(Integer disciplineId, String disciplineName,
			String dDescription, Set<Teacher> teacherDisciple) {
		super();
		this.disciplineId = disciplineId;
		this.disciplineName = disciplineName;
		this.dDescription = dDescription;
		this.teacherDisciple = teacherDisciple;
	}

	//Getters and Setters

	public Integer getDisciplineId() {
		return disciplineId;
	}

	public Set<Teacher> getTeacherDisciple() {
		return teacherDisciple;
	}

	public void setTeacherDisciple(Set<Teacher> teacherDisciple) {
		this.teacherDisciple = teacherDisciple;
	}

	public void setDisciplineId(Integer disciplineId) {
		this.disciplineId = disciplineId;
	}

	public String getDisciplineName() {
		return disciplineName;
	}

	public void setDisciplineName(String disciplineName) {
		this.disciplineName = disciplineName;
	}

	public String getdDescription() {
		return dDescription;
	}

	public void setdDescription(String dDescription) {
		this.dDescription = dDescription;
	}	
	
}
