package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.util.AuthenticationUtil;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {

		if (AuthenticationUtil.getCurrentUser() == null) {
			return "redirect:/login";
		} else {
			return "redirect:/user/dashboard";
		}
	}

	@GetMapping("/user/dashboard")
	public String dashBoard(ModelMap modelMap) {

		modelMap.put("userNmae", AuthenticationUtil.getCurrentUser().getUsername());

		return "dashboard";

	}

}
