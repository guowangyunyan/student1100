package com.training.dao;

import java.util.List;

import com.training.model.UserModel;

public interface UserDao {
	// 注册用户
	void saveUser(UserModel userModel);

	// 用户登录
	List<UserModel> queryUser(UserModel userModel);

	// 验证用户名唯一
	List<UserModel> queryUserByUserName(String userName);
}
