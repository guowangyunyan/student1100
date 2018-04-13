package com.training.convert;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.training.form.UserForm;
import com.training.model.UserModel;

public class UserModelConvert implements Convert<UserForm, UserModel> {
	private Md5PasswordEncoder md5Encoder;// md5加密

	@Override
	public UserModel createTarget() {
		// TODO Auto-generated method stub
		return new UserModel();
	}

	@Override
	public UserModel convert(UserForm userForm) {
		String password = md5Encoder.encodePassword(userForm.getPassword(), userForm.getUserName());
		UserModel model = createTarget();
		model.setUserName(userForm.getUserName());
		model.setPassword(password);
		return model;
	}

	public Md5PasswordEncoder getMd5Encoder() {
		return md5Encoder;
	}

	public void setMd5Encoder(Md5PasswordEncoder md5Encoder) {
		this.md5Encoder = md5Encoder;
	}

}
