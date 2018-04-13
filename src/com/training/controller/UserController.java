package com.training.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.form.UserForm;
import com.training.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService userService;

	// 注册用户
	@RequestMapping("/registerUser")
	public String registerUser() {
		return "user/register";
	}

	// 注册用户
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(UserForm userForm) {
		userService.saveUser(userForm);
		return "redirect:/login";
	}
}
