package com.arteach.main.security;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arteach.main.dao.IMemberRepo;
import com.arteach.main.models.Member;


@Service
public class MyUserDeatilsService implements UserDetailsService {

	// created a query to find user by email
	@Autowired
	IMemberRepo memberRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		// find if user exist
		Optional<Member> member = memberRepo.findBymemberEmail(email);
		// throw an error if not
		member.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + email));
		// get me the user
		
		return member.map(MyUserDetails::new).get();
	}

}
