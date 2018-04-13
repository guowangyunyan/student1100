package com.training.service;

import com.training.data.UserData;
import com.training.form.UserForm;
import com.training.model.UserModel;

public interface UserService {

	// 注册用户
	void saveUser(UserForm userForm);

	// 验证用户的唯一性
	UserModel queryUserByUserName(UserForm userForm);

	// 用户登录
	UserData queryUser(UserForm userForm);
}
