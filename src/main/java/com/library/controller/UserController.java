package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.entity.GeneralError;
import com.library.entity.User;
import com.library.services.UserServices;
import com.library.validation.UserValidation;


@Controller
public class UserController {

	@Autowired
	private UserValidation userValidation;

	@Autowired
	private UserServices userService;

	@GetMapping("/registeruser")
	public String registeruser() {
		return "register";
	}

	@PostMapping("/registeruser")
	public String registeruser(User ud, RedirectAttributes redirectAttrs) {
		GeneralError ge = userValidation.validateUserRegistration(ud);
		if (ge.isValid() == false) {
			redirectAttrs.addFlashAttribute("message", ge.getMessage());
			redirectAttrs.addFlashAttribute("previousData", ud);
		} else {
			userService.saveUser(ud);

			redirectAttrs.addFlashAttribute("message", "User Saved Success");
		}
		return "redirect:/registeruser";
	}

	@GetMapping("/user/show")
	public String show() {
		return "usertest";
	}

	@GetMapping("/user/delete")
	public String delete() {
		return "usertest";
	}

	@GetMapping("/user/add")
	public String add() {
		return "usertest";
	}

}
