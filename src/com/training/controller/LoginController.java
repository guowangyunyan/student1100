package com.training.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.data.UserData;
import com.training.form.UserForm;
import com.training.service.UserService;

@Controller
public class LoginController {
	@Resource
	private UserService userService;

	// 用户登录
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	// 用户登录

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserForm userForm) {
		UserData userData = userService.queryUser(userForm);
		if (null != userData) {
			return "redirect:/loadStudents";
		}
		return "/login";
	}

}
