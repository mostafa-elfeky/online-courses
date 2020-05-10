package com.seniorsteps.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.seniorsteps.app.service.AppUserDetailsService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.inMemoryAuthentication()
//			.withUser("student@gmail.com")
//			.password("$2y$11$UL8p0.Jczr.8uUbmZEQdaeQbWobJoqU3AXTuzxsK6wb2ou5bXHOJy")
//			.roles("STUDENT");
//		auth.inMemoryAuthentication()
//			.withUser("instructor@gmail.com")
//			.password("$2y$11$UL8p0.Jczr.8uUbmZEQdaeQbWobJoqU3AXTuzxsK6wb2ou5bXHOJy")
//			.roles("INSTRUCTOR");
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
			.antMatchers("/", "/login", "/logout", "/403").permitAll()
			.antMatchers("/courses").hasAuthority("STUDENT")
			.anyRequest()
			.authenticated()
		.and()
			.formLogin().loginPage("/login")
		.and()
			.logout().logoutUrl("/logout")
		.and()
			.httpBasic()
		.and()
			.csrf().disable()
			.exceptionHandling().accessDeniedPage("/403")
			.and()
				.userDetailsService(appUserDetailsService);
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web.ignoring().antMatchers("/resources/*");
	}
	
}
