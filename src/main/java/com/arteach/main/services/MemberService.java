package com.arteach.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arteach.main.dao.IMemberRepo;

import com.arteach.main.models.Member;
import com.arteach.main.security.SecurityConfiguration;

@Service
public class MemberService {
	@Autowired
	IMemberRepo memberRepo;


	public List<Member> findAll() {

		return memberRepo.findAll();

	}

	public Member findById(Integer id) {

		return memberRepo.findById(id).get();

	}

	public boolean existsById(Integer id) {

		return memberRepo.existsById(id);
	}

	public void deleteById(Integer id) {

		if (existsById(id))
			memberRepo.deleteById(id);

	}

	public void save(Member member) {
		
		member.setmPassword(SecurityConfiguration.getPasswordEncoder().encode(member.getmPassword()));
		memberRepo.save(member);

	}

	public Optional<Member> findByEmail(String email) {
		 
		return memberRepo.findBymemberEmail(email);
		
	}

}
