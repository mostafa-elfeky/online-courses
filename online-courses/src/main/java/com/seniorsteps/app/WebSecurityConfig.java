package com.seniorsteps.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.seniorsteps.app.service.AppUserDetailsService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	AppUserDetailsService appUserDetailsService; 

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}
	
	/*
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication()
		  	  .withUser("student@gmail.com")
		  	  .password("$2y$11$YYNMT32rr5kaPcZ.NP.0f.4A5YFHobXaQyY8K5JtEzs3YQgB34wnC")
		  	  .roles("STUDENT");
		  auth.inMemoryAuthentication()
		      .withUser("instructor@gmail.com")
		      .password("$2y$11$YYNMT32rr5kaPcZ.NP.0f.4A5YFHobXaQyY8K5JtEzs3YQgB34wnC")
		      .roles("INSTRUCTOR");
	}
	*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		String[] publicResoureces = {"/", "/login", "/logout"};

		http
			.authorizeRequests()
			.antMatchers(publicResoureces).permitAll()
			.antMatchers("/courses").hasAuthority("STUDENT")
			.anyRequest().authenticated()
		.and()
			.formLogin()
			.loginPage("/login")
		.and()
			.logout().logoutUrl("/logout")
		.and()
			.httpBasic()
		.and()
			.csrf().disable()
			.userDetailsService(appUserDetailsService);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

}
