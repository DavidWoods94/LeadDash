package com.woda.leaddash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.woda.leaddash.leadrepository.UserRepository;
import com.woda.leaddash.model.User;


@Service
public class UserDetailServiceImp implements UserDetailsService {

	private final UserRepository repository;
	
	@Autowired
	public UserDetailServiceImp(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User curruser = repository.findByUsername(username);
    	
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), true, 
        		true, true, true, AuthorityUtils.createAuthorityList(curruser.getRole()));
        
        System.out.println("ROLE: " + curruser.getRole());
        return user;
	}

}
