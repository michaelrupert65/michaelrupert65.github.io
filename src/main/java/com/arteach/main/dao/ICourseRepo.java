package com.arteach.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arteach.main.models.Course;
@Repository
public interface ICourseRepo extends JpaRepository<Course, Integer> {

}
