package com.arteach.main.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*
	 * 
	 * Spring Security Config file
	 * 
	 */

	// wire services needed
	@Autowired
	UserDetailsService userDetailsService;

	// method to config user details class
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN");
		auth.userDetailsService(userDetailsService);

	}

//	// method to encode password in db

	//	@Bean
//	public DaoAuthenticationProvider daoAuthenticationProvider() {
//		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//		authenticationProvider.setUserDetailsService(userDetailsService);
//		authenticationProvider.setPasswordEncoder(getPasswordEncoder());
//		return authenticationProvider;
//	}
//
	@Bean
	public static PasswordEncoder getPasswordEncoder() {
		 

	    PasswordEncoder defaultEncoder = new BCryptPasswordEncoder();
	    String idForEncode = "bcrypt";

	    Map<String, PasswordEncoder> encoders = new HashMap<>();
	    encoders.put(idForEncode, new BCryptPasswordEncoder());
	    encoders.put("noop", NoOpPasswordEncoder.getInstance());
	    encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
	    encoders.put("scrypt", new SCryptPasswordEncoder());
	    encoders.put("sha256", new StandardPasswordEncoder());
	 
	    DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);
	    passwordEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);
	 
	    return passwordEncoder;
	}

	
	@Bean
	  public AuthenticationProvider daoAuthenticationProvider() {
	    DaoAuthenticationProvider provider = 
	      new DaoAuthenticationProvider();
	    provider.setPasswordEncoder(getPasswordEncoder());
	    provider.setUserDetailsService(this.userDetailsService);
	    return provider;
	  }
	  
	  

	// main config method to allow users to which page
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().
		
		antMatchers("/","/newaccount").permitAll()
				
				
				
				//This is where you add the path mapping names for restricting security
				.antMatchers("/adddiscipline", "/addnewdiscipline", "/addclass", "/addclass","/addrecords","/adddiscipline","/addteacher","/addfacility","/removeevent","/removemember").hasRole("ADMIN")
				.antMatchers("/home").hasAnyRole("ADMIN", "USER","TEACHER")
				.antMatchers("/settings","/addclass").hasAnyRole("ADMIN","TEACHER")
				
				.and()
				
				.httpBasic()

				.and()
				
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
				
				.and()
				///Make an active page...
				.exceptionHandling().accessDeniedPage("/")
				
				.and()
				
				.formLogin().loginPage("/login").loginProcessingUrl("/login/authenticate").permitAll()
				.failureUrl("/login?error=true").defaultSuccessUrl("/").usernameParameter("email")
				.passwordParameter("password");
				
				

				
	}

	// pages not to follow the security
	@Override
	public void configure(final WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

}
