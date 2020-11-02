package com.arteach.main.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arteach.main.models.Member;

@Repository
public interface IMemberRepo extends JpaRepository<Member, Integer> {
	Optional<Member> findBymemberEmail(String email);

	void save(Optional<Member> myMember);
	
}
