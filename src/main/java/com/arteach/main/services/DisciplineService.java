package com.arteach.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arteach.main.dao.IDisciplineRepo;
import com.arteach.main.models.Discipline;


@Service
public class DisciplineService {
	@Autowired
	IDisciplineRepo disciplineRepo;
	
	public List<Discipline> findAll(){
		return disciplineRepo.findAll();
	}
	public Discipline findById(Integer id) {

		return disciplineRepo.findById(id).get();

	}

	public boolean existsById(Integer id) {

		return disciplineRepo.existsById(id);
	}

	public void deleteById(Integer id) {

		if (existsById(id))
			disciplineRepo.deleteById(id);

	}

	public void save(Discipline disc) {

		disciplineRepo.save(disc);

	}
	public Discipline findByName(String name) {
		return disciplineRepo.findByDisciplineName(name);
	}

}
