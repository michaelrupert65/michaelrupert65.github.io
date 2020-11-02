package com.arteach.main.modeltests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arteach.main.models.Discipline;
import com.arteach.main.services.DisciplineService;

@SpringBootTest
public class DisciplineServiceTest {
	@Autowired
	DisciplineService ds;	
	Discipline disc = new Discipline();
	
	Integer dId = 0;
	String desc =" Testing";
	String dName = "Tester";
	public void seedDB() {
		disc.setdDescription(desc);
		disc.setDisciplineName(dName);
		ds.save(disc);
	}
	
	@Test
	@Order(1)
	public void TestSave() {
		seedDB();
		assertEquals(ds.findByName(dName).getDisciplineName(),dName);
		assertTrue(ds.existsById(ds.findByName(dName).getDisciplineId()));
		
	}
	@Test
	@Order(2)
	public void TestFindAll() {
		if(!ds.existsById(ds.findByName(dName).getDisciplineId()))
		{
			seedDB();
		}
		
		assertEquals(ds.findAll().size(),1);
		assertTrue(ds.existsById(ds.findByName(dName).getDisciplineId()));
	}
	@Test 
	@Order(3)
	public void TestFindById() {
		if(!ds.existsById(ds.findByName(dName).getDisciplineId()))
		{
			seedDB();
		}

		assertTrue(ds.existsById(ds.findByName(dName).getDisciplineId()));	
		ds.deleteById(ds.findByName(dName).getDisciplineId());
	}
	@Test
	@Order(5)
	public void TestDeleteById() {
		if(!ds.existsById(ds.findByName(dName).getDisciplineId()))
		{
			seedDB();
		}
		 
		 assertFalse(ds.existsById(dId));
	}
	@Test
	@Order(4)
	public void TestExistsById() {
		if(!ds.existsById(ds.findByName(dName).getDisciplineId()))
		{
			seedDB();
		}
		assertTrue(ds.existsById(dId));
		ds.deleteById(dId);
	}
	
	
}
