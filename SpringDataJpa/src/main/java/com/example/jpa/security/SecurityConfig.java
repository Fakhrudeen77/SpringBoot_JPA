package com.example.jpa.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Rehana77").password("Rehana77").authorities("ROLE_USER")
		.and()
		.withUser("Fakhrudeen77").password("Shafana77").authorities("ROLE_ADMIN")
		.and()
		.withUser("Manager").password("Manager").authorities("ROLE_MANAGER")		
		.and()		
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// We don't need CSRF for this example
		http.cors().and().csrf().disable()
		.authorizeRequests()
		.antMatchers("/home").authenticated()
		//.antMatchers("/customer/getCustomerList").permitAll()
		.antMatchers("/department/saveDepartment").authenticated()
		//.antMatchers("/customer/getCustomerById").permitAll()
		.antMatchers("/department/getDepartmentList").permitAll()
		.antMatchers("/department/deleteByDeptId").authenticated()
		.antMatchers("/book/getBookList").authenticated()
		
		//.antMatchers("/customer/deleteCustomerByCustId").permitAll()
		//.antMatchers(HttpMethod.DELETE, "/department/deleteByDeptId").permitAll()
		
		/*.antMatchers("/test/balance").authenticated()
		.antMatchers("/profile").authenticated()
				
		.antMatchers("/test/save").authenticated()
		
		.antMatchers("/test/loan").authenticated()
		.antMatchers("/test/statement").authenticated()
		.antMatchers("/test/home").permitAll()
		.antMatchers("/test/contact").permitAll()
		
		//.antMatchers(HttpMethod.GET, "/test/users").authenticated()	
		.antMatchers(HttpMethod.GET, "/test/users/welcome").permitAll()
		.antMatchers(HttpMethod.GET, "/test/users/protect").authenticated()	
		.antMatchers(HttpMethod.POST, "/book/**").authenticated()
		.antMatchers(HttpMethod.GET, "/book/**").authenticated()*/
		
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		
		.and()
		.logout().permitAll()
		.and()
		.httpBasic();
		
		
		
	}
	

}
