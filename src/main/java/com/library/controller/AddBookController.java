package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.entity.BookDetail;
import com.library.entity.BookError;
import com.library.repository.BookRepository;
import com.library.validation.BookValidation;

@Controller
public class AddBookController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookValidation bookValidation;

	@GetMapping("/user/listbook")
	public String booklist(ModelMap modelMap) {
		List<BookDetail> lb = (List<BookDetail>) bookRepository.findAll();
		modelMap.put("bookList", lb);
		return "book";
	}

	@PostMapping("/user/savebook")
	public String savebook(BookDetail bd, String isbn, String bookname, String authorname, String edition,
			String publication, RedirectAttributes redirectAttrs) {
		BookError be = bookValidation.bookRegistration(bd);
		if (be.isValid() == false) {
			redirectAttrs.addFlashAttribute("message", be.getIsbn());
			redirectAttrs.addFlashAttribute("bmessage", be.getBookname());
			redirectAttrs.addFlashAttribute("amessage", be.getAuthorname());
			redirectAttrs.addFlashAttribute("emessage", be.getEdition());
			redirectAttrs.addFlashAttribute("pmessage", be.getPublication());
			redirectAttrs.addFlashAttribute("previousData", bd);
			
		} else {
			bd.setIsbn(isbn);
			bd.setBookname(bookname);
			bd.setAuthorname(authorname);
			bd.setEdition(edition);
			bd.setPublication(publication);
			bd.setAvailability(true);
			bookRepository.save(bd);
		}

		return "redirect:/user/listbook";
	}

	@GetMapping("/user/deletebook")
	private String deletebook(long id) {
		bookRepository.deleteById(id);
		return "redirect:/user/listbook";

	}

	@GetMapping("/user/editbook")
	public String editbook(ModelMap modelMap, long id) {

		BookDetail cd = bookRepository.getDataById(id);

		modelMap.put("bookDetail", cd);

		return "bookedit";
	}

	@PostMapping("/user/editbookpost")
	public String editbookpost(String isbn, String bookname, String authorname, String edition, String publication,
			long id) {

		BookDetail bd = bookRepository.getDataById(id);
		bd.setIsbn(isbn);
		bd.setBookname(bookname);
		bd.setAuthorname(authorname);
		bd.setEdition(edition);
		bd.setPublication(publication);
		bookRepository.save(bd);
		return "redirect:/user/listbook";
	}
}
