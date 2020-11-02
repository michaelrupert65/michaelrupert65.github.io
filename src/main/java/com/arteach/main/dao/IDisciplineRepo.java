package com.arteach.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arteach.main.models.Discipline;


@Repository
public interface IDisciplineRepo extends JpaRepository<Discipline, Integer> {
	Discipline findByDisciplineName(String dName);
}
