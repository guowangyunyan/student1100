package com.training.service.impl;

import java.util.List;

import com.training.convert.UserDataConvert;
import com.training.convert.UserModelConvert;
import com.training.dao.UserDao;
import com.training.data.UserData;
import com.training.form.UserForm;
import com.training.model.UserModel;
import com.training.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private UserModelConvert userModelConvert;
	private UserDataConvert userDataConvert;

	// 注册用户用户
	@Override
	public void saveUser(UserForm userForm) {
		UserModel userModel = userModelConvert.convert(userForm);
		userDao.saveUser(userModel);

	}

	// 验证用户的唯一性
	@Override
	public UserModel queryUserByUserName(UserForm userForm) {
		List<UserModel> list = userDao.queryUserByUserName(userForm.getUserName());
		UserModel userModel = null;
		if (list.size() != 0) {
			userModel = list.get(0);
		}
		return userModel;
	}

	// 用户登录
	@Override
	public UserData queryUser(UserForm userForm) {
		UserModel userModel = userModelConvert.convert(userForm);
		List<UserModel> list = userDao.queryUser(userModel);
		UserData userData = null;
		if (list.size() != 0) {
			userData = userDataConvert.convert(list.get(0));
		}
		return userData;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserModelConvert getUserModelConvert() {
		return userModelConvert;
	}

	public void setUserModelConvert(UserModelConvert userModelConvert) {
		this.userModelConvert = userModelConvert;
	}

	public UserDataConvert getUserDataConvert() {
		return userDataConvert;
	}

	public void setUserDataConvert(UserDataConvert userDataConvert) {
		this.userDataConvert = userDataConvert;
	}

}
