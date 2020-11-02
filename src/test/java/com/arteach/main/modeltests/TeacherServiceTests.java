package com.arteach.main.modeltests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arteach.main.models.Teacher;
import com.arteach.main.services.DisciplineService;
import com.arteach.main.services.TeacherService;

/**
 * @author Michael Rupert This class tests the functionality of the Member model
 *         and it's service.
 *
 */
@SpringBootTest
public class TeacherServiceTests {
	@Autowired
	TeacherService ts;
	@Autowired
	DisciplineService ds;
	Teacher teacher = new Teacher();
	String Role = "USER";
	String fName = "Junit";
	String lName = "Test";
	String Addr = "1 TestVille Ave";
	String City = "UnitTest";
	String State = "Hopeful";
	String Zip = "09876";
	String Country = "USA";
	String Region = "Middle";
	String password = "abcde";
	String email = "test@test.tester";
	Integer tId = 0;

	public void seedDB() {		
		teacher.settRole(Role);
		teacher.setFirstName(fName);
		teacher.setLastName(lName);
		teacher.settAddress(Addr);
		teacher.settCity(City);
		teacher.settState(State);
		teacher.settZipCode(Zip);
		teacher.setTeacherEmail(email);
		teacher.settCountry(Country);
		teacher.settRegion(Region);
		teacher.settPassword(password);
		teacher.getDiscipline().add(ds.findById(2));

		ts.save(teacher);
	}

	// Test addition of new Member to DB
	@Test
	@Order(1)
	public void TestSaveNewTeacher() {
		seedDB();

		tId = ts.findByEmail(email).getTeacherID();

		assertEquals(ts.findByEmail(email).getFirstName(), teacher.getFirstName());
		assertEquals(ts.findByEmail(email).getLastName(), teacher.getLastName());
		assertEquals(ts.findByEmail(email).gettAddress(), teacher.gettAddress());
	}

	@Test
	@Order(2)
	public void TestFindById() {
		//if (!ts.existsById(ts.findByEmail(email).getTeacherID())) {
			seedDB();
		//}

		tId = ts.findByEmail(email).getTeacherID();
		assertEquals(ts.findById(tId).getTeacherEmail(), "test@test.tester");
	}
		

	@Test
	@Order(3)
	public void TestExistsById() {
		if (!ts.existsById(ts.findByEmail(email).getTeacherID())) {
			seedDB();
		}
		tId = ts.findByEmail(email).getTeacherID();
		assertTrue(ts.existsById(tId));
	}

	@Test
	@Order(4)
	public void TestFindByEmail() {
		if (!ts.existsById(ts.findByEmail(email).getTeacherID())) {
			seedDB();
		}
		assertTrue(ts.existsById(ts.findByEmail(email).getTeacherID()));
	}

	@Test
	@Order(5)
	public void TestDeleteById() {
		if (!ts.existsById(ts.findByEmail(email).getTeacherID())) {
			seedDB();
		}
		tId = ts.findByEmail(email).getTeacherID();
		ts.deleteById(tId);
		assertFalse(ts.existsById(tId));
		
	}


}
