package com.training.convert;

import com.training.data.UserData;
import com.training.model.UserModel;

public class UserDataConvert implements Convert<UserModel, UserData> {

	@Override
	public UserData createTarget() {
		// TODO Auto-generated method stub
		return new UserData();
	}

	@Override
	public UserData convert(UserModel userModel) {
		UserData userData = createTarget();
		userData.setUserName(userModel.getUserName());
		return userData;
	}

}
