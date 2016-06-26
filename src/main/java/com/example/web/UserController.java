package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.User;
import com.example.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@ModelAttribute
	UserForm setUpForm() {
		return new UserForm();
	}
	
	@RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
	String editForm() {

		return "user/edit";
	}
    
	@RequestMapping(value = "create", method = RequestMethod.POST)
	String create(@Validated UserForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "user/edit";
		}
		
		User user = new User();
		user.setUserid(form.getUserid());
		user.setUsername(form.getUsername());

		PasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setEncodedPassword(encoder.encode(form.getPassword()));
		
		User check = userService.findOne(user.getUserid());
		if(check != null) {
			result.reject("countryForm.global.duplicate");
			return "user/edit";
		}
		
		
		userService.create(user);

		return "redirect:/customers";
	}
	
}
