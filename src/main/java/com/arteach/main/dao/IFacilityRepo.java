package com.arteach.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arteach.main.models.Facility;

@Repository
public interface IFacilityRepo extends JpaRepository<Facility, Integer> {

}
