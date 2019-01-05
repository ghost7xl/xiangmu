package com.shopping.service.impl;

import java.util.List;

import com.shopping.dao.impl.UserDaoImpl;
import com.shopping.pojo.User;
import com.shopping.service.UserManageService;

public class UserManageServiceImpl implements UserManageService {

	@Override
	public List<User> queryUsers(String name, String gender) {
		if (name != null && gender != null) {
			return new UserDaoImpl().queryUserList(name, gender);
		} else if (name != null && gender == null) {
			return new UserDaoImpl().queryUserListByUserName(name);
		} else if (name == null && gender != null) {
			return new UserDaoImpl().queryUserListByGender(gender);
		} else {
			return null;
		}
	}

	@Override
	public List<User> queryAllUser() {
		return new UserDaoImpl().queryAllUser();
	}

	@Override
	public int editUser(Object... o) {
		User user2 = new UserDaoImpl().queryUser((int) o[0]);
		System.out.println(o[0]);
		user2.setEmail((String) o[1]);
		user2.setUsername((String) o[2]);
		user2.setGender((String) o[3]);
		user2.setFlag((int) o[4]);
		int i = new UserDaoImpl().editUser(user2);
		return i;
	}

	@Override
	public int delUser(int id) {
		return new UserDaoImpl().delUser(id);
	}

}
