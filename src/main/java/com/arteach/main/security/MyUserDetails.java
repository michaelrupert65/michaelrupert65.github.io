package com.arteach.main.security;

import java.util.Arrays;
import java.util.Collection;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.arteach.main.models.Member;



public class MyUserDetails implements UserDetails{

	/*
	 * Implementing methods from user details 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	
	
	private List<GrantedAuthority> authorities;
	

	
	public MyUserDetails(Member member) {
		this.email= member.getMemberEmail();
		this.password = member.getmPassword();
		
	this.authorities = Arrays.stream(member.getmRole().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		System.out.println(authorities);
		return authorities;
	}



	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}