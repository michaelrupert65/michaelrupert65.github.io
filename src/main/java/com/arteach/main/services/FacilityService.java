package com.arteach.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arteach.main.dao.IFacilityRepo;

import com.arteach.main.models.Facility;

@Service
public class FacilityService {
	@Autowired
	IFacilityRepo facilityRepo;

	public List<Facility> findAll() {

		return facilityRepo.findAll();

	}

	public Facility findById(Integer id) {

		return facilityRepo.findById(id).get();

	}

	public boolean existsById(Integer id) {

		return facilityRepo.existsById(id);
	}

	public void deleteById(Integer id) {

		if (existsById(id))
			facilityRepo.deleteById(id);

	}

	public void save(Facility facility) {

		facilityRepo.save(facility);

	}
}
