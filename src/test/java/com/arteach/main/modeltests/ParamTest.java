package com.arteach.main.modeltests;


import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.arteach.main.models.Member;
import com.arteach.main.services.MemberService;

@SpringBootTest
public class ParamTest {
	@Autowired
	MemberService ms;
	@ParameterizedTest
	@CsvSource({"FirstName1, LastName1, Address1, City1, State1, 01701, Country1, Region1, Password1, Role1, email1@email.com",
		"FirstName2, LastName2, Address2, City2, State2, 01702, Country2, Region2, Password2, Role2, email2@email.com"})
	void testAccountSave(String fname, String lname, String addr, String city, String state, 
			String zip, String ctry, String reg, String pword, String role, String email ) {
		Member test = new Member(fname, lname, addr, city, state, ctry, reg, pword, zip, role, email);
		ms.save(test);
		Member test2 = ms.findById(test.getMemberId());
		Assertions.assertEquals(test2.getmFirstName(), fname);
		ms.deleteById(test.getMemberId());
	}
}
