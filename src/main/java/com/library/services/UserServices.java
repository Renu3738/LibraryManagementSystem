package com.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.User;
import com.library.repository.UserRepository;


@Service
public class UserServices {
	@Autowired
	private UserRepository userRepository;
	
	public void saveUser(User u){
		u.setRole("ROLE_USER");
		userRepository.save(u);
	}
}
