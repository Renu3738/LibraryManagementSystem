package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.entity.BookUser;
import com.library.entity.GeneralError;
import com.library.repository.BookUserRepository;
import com.library.repository.IssueRepository;
import com.library.services.IssueNowService;
import com.library.validation.IssueValidation;

@Controller
public class IssuenNowController {

	@Autowired
	private IssueRepository issueRepository;

	@Autowired
	private IssueValidation issueValidation;

	@Autowired
	private IssueNowService issueNowService;

	@Autowired
	private BookUserRepository bookUserRepository;

	@GetMapping("/user/issuenow")
	public String issuenow(ModelMap modelMap, long cid, long bid) {
		List<BookUser> lu = (List<BookUser>) issueRepository.findAll();
		modelMap.put("issue", lu);
		modelMap.put("cid", cid);
		modelMap.put("bid", bid);
		return "issuenow";
	}

	@PostMapping("/user/issuenow")
	public String issuenow(long cid, long bid, String fromDate, String toDate, RedirectAttributes redirectAttribute) {

		GeneralError ge = issueValidation.validateIssue(cid, bid, fromDate, toDate);

		if (ge.isValid()) {
			issueNowService.issueBook(cid, bid, fromDate, toDate);
			return "redirect:/user/issuelist";
		} else {
			redirectAttribute.addFlashAttribute("emessage", ge.getMessage());
		}

		redirectAttribute.addFlashAttribute("fromDate", fromDate);
		redirectAttribute.addFlashAttribute("toDate", toDate);

		return "redirect:/user/issuenow?cid=" + cid + "&bid=" + bid;
	}

	@GetMapping("/user/issuelist")
	public String issueList(ModelMap modelMap) {

		modelMap.put("issuedBooks", bookUserRepository.orderByDesc());

		return "issuelist";
	}

	@GetMapping("/user/returnbook")
	public String returnbook(long bid, ModelMap modelMap) {

		modelMap.put("bookUserId", bid);
		return "return";
	}

	@PostMapping("/user/returnbook")
	public String issuenow(long bookUserId, String returnDate, RedirectAttributes redirectAttribute) {

		GeneralError ge = issueValidation.validationReturn(bookUserId, returnDate);

		if (ge.isValid()) {
			issueNowService.bookReturn(bookUserId, returnDate);
			return "redirect:/user/issuelist";
		} else {
			redirectAttribute.addFlashAttribute("emessage", ge.getMessage());
		}

		redirectAttribute.addFlashAttribute("returnDate", returnDate);

		return "redirect:/user/returnbook?bid=" + bookUserId;
	}

}
