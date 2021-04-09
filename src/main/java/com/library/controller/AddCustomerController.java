package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.entity.BookError;
import com.library.entity.Customer;
import com.library.entity.CustomerError;
import com.library.repository.CustomerRepository;
import com.library.validation.CustomerValidation;

@Controller
public class AddCustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerValidation customerValidation;

	@GetMapping("/user/listcustomer")
	public String listcustomer(ModelMap modelMap) {
		List<Customer> cl = (List<Customer>) customerRepository.findAll();
		modelMap.put("customerList", cl);
		return "customer";
	}

	@PostMapping("/user/savecustomer")
	public String savecustomer(Customer c, String customername, String mobile, String address,
			RedirectAttributes redirectAttrs) {
		CustomerError ce = customerValidation.customerRegistration(c);
		if (ce.isValid() == false) {
			redirectAttrs.addFlashAttribute("message", ce.getCustomername());
			redirectAttrs.addFlashAttribute("mmessage", ce.getMobile());
			redirectAttrs.addFlashAttribute("amessage", ce.getAddress());
			redirectAttrs.addFlashAttribute("previousData", c);

		} else {
			c.setCustomername(customername);
			c.setMobile(mobile);
			c.setAddress(address);
			customerRepository.save(c);

		}
		return "redirect:/user/listcustomer";
	}

}
