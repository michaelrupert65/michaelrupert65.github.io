package com.arteach.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arteach.main.dao.ICourseRepo;

import com.arteach.main.models.Course;

@Service
public class CourseService {

	@Autowired
	ICourseRepo courseRepo;
	
	public List<Course> findAll(){
		return courseRepo.findAll();
	}
	public Course findById(Integer id) {

		return courseRepo.findById(id).get();

	}

	public boolean existsById(Integer id) {

		return courseRepo.existsById(id);
	}

	public void deleteById(Integer id) {

		if (existsById(id))
			courseRepo.deleteById(id);

	}

	public void save(Course course) {

		courseRepo.save(course);

	}
}
