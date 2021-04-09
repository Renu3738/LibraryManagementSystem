package com.library.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.entity.GeneralError;
import com.library.entity.User;
import com.library.repository.UserRepository;


@Component
public class UserValidation {
	@Autowired
	private UserRepository userRepository;
	public GeneralError validateUserRegistration(User ud){
		GeneralError ge=new GeneralError();
		ge.setValid(true);
		if(ud.getUsername()==null){
			ge.setMessage("User name is required");
			ge.setValid(false);
		}else if(ud.getUsername().equals("")){
			ge.setMessage("User name is empty");
			ge.setValid(false);
		}
		
		if(ud.getPassword()==null){
			ge.setMessage("Password is required");
			ge.setValid(false);
		}else if(ud.getPassword().equals("")){
			ge.setMessage("Password is empty");
			ge.setValid(false);
		}
		
		User u=userRepository.findByUserName(ud.getUsername());
		
		return ge;
		
	} 
}
