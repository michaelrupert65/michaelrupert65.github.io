package com.arteach.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arteach.main.models.Teacher;

@Repository
public interface ITeacherRepo extends JpaRepository<Teacher, Integer> {
	Teacher findByTeacherEmail(String teacherEmail);
}
