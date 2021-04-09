package com.library.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.entity.BookDetail;
import com.library.entity.BookError;
import com.library.entity.Customer;
import com.library.entity.CustomerError;
import com.library.repository.BookRepository;



@Component
public class CustomerValidation {
	@Autowired
	private BookRepository bookRepository;
	public CustomerError customerRegistration(Customer c){
		CustomerError ce=new CustomerError();
		ce.setValid(true);
		
		if (c.getCustomername() == null) {
			ce.setCustomername("Customer name missing");
			ce.setValid(false);
		} else if (c.getCustomername().equals("")) {
			ce.setCustomername("Customer name missing");
			ce.setValid(false);
		}

		if (c.getMobile() == null) {
			ce.setMobile("Mobile number missing");
			ce.setValid(false);
		} else if (c.getMobile().equals("")) {
			ce.setMobile("Mobile number missing");
			ce.setValid(false);
		} else if (c.getMobile().trim().length() != 10) {
			ce.setMobile("Mobile number must be ten digit");
			ce.setValid(false);
		}

		if (c.getAddress() == null) {
			ce.setAddress("Address missing");
			ce.setValid(false);
		} else if (c.getAddress().equals("")) {
			ce.setAddress("Address missing");
			ce.setValid(false);
		}
		
		return ce;
		
	} 
}
