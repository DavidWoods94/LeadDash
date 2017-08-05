package com.woda.leaddash.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.woda.leaddash.service.UserDetailServiceImp;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private UserDetailServiceImp userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
	         .authorizeRequests()
	             .antMatchers("/vendor/**","/css/**", "/js/**", "/signup", "/saveuser").permitAll()
	             .and()
	         .authorizeRequests()
                 .anyRequest().authenticated()
                 .and()
	         .formLogin()
	             .loginPage("/login")
	             .defaultSuccessUrl("/leads")
	             .permitAll()
	             .and()
	         .logout()
	             .permitAll();
	 }
	 
	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	     auth
	         .inMemoryAuthentication()
	             .withUser("user").password("password").roles("USER");
	     auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	  }
	 
}
