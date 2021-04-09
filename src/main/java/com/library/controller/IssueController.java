package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.entity.BookDetail;
import com.library.repository.BookRepository;

@Controller
public class IssueController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/user/issuebook")
	public String issuelist(ModelMap modelMap, @RequestParam(value = "cid", required = false) Long cid,
			@RequestParam(value = "bookname", required = false) String bookname) {

		Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "id"));
		List<BookDetail> bookList = bookRepository.getBootDetailByName(bookname, true, pageable);

		modelMap.put("cid", cid);
		modelMap.put("bookname", bookname);
		modelMap.put("bookList", bookList);

		return "issue";
	}
}
