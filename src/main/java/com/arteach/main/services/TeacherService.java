package com.arteach.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arteach.main.dao.ITeacherRepo;
import com.arteach.main.models.Teacher;

@Service
public class TeacherService {
	@Autowired
	ITeacherRepo teacherRepo;
	public List<Teacher> findAll() {

		return teacherRepo.findAll();

	}

	public Teacher findById(Integer id) {

		return teacherRepo.findById(id).get();

	}

	public boolean existsById(Integer id) {

		return teacherRepo.existsById(id);
	}

	public void deleteById(Integer id) {

		if (existsById(id))
			teacherRepo.deleteById(id);

	}

	public void save(Teacher teacher) {

		teacherRepo.save(teacher);

	}
	public Teacher findByEmail(String email) {
		
		return teacherRepo.findByTeacherEmail(email);
	}

}
