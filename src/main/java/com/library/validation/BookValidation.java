package com.library.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.entity.BookDetail;
import com.library.entity.BookError;
import com.library.repository.BookRepository;



@Component
public class BookValidation {
	@Autowired
	private BookRepository bookRepository;
	public BookError bookRegistration(BookDetail bd){
		BookError be=new BookError();
		be.setValid(true);
		if(bd.getIsbn()==null){
			be.setIsbn("Isbn is required");
			be.setValid(false);
		}else if(bd.getIsbn().equals("")){
			be.setIsbn("Isbn is empty");
			be.setValid(false);
		}
		
		if(bd.getBookname()==null){
			be.setBookname("Bookname is required");
			be.setValid(false);
		}else if(bd.getBookname().equals("")){
			be.setBookname("Bookname is empty");
			be.setValid(false);
		}
		
		if(bd.getAuthorname()==null){
			be.setAuthorname("Authorname is required");
			be.setValid(false);
		}else if(bd.getAuthorname().equals("")){
			be.setAuthorname("Authorname is empty");
			be.setValid(false);
		}
		
		if(bd.getEdition()==null){
			be.setEdition("Edition is required");
			be.setValid(false);
		}else if(bd.getEdition().equals("")){
			be.setEdition("Edition is empty");
			be.setValid(false);
		}
		
		if(bd.getPublication()==null){
			be.setPublication("Publication is required");
			be.setValid(false);
		}else if(bd.getPublication().equals("")){
			be.setPublication("Publication is empty");
			be.setValid(false);
		}
	 
		BookDetail b=bookRepository.getDataByIsbn(bd.getIsbn());
		if (b != null) {
			be.setIsbn("Book already exist. Isbn Should be unique.");
			be.setValid(false);
		}
		return be;
		
	} 
}
