package com.shopping.dao;

import java.util.List;

import com.shopping.pojo.User;

public interface UserDao {
	// 增
	int addUser(User user);

	// 删
	int delUser(int id);

	// 改
	int editUser(User user);

	// 查所有
	List<User> queryAllUser();

	// 根据id查单个
	User queryUser(int id);

	// 根据帐号密码查
	User queryUser(String name, String password);

	// 模糊查询 根据名字和性别查询
	List<User> queryUserList(String name, String gender);

	// 只根据名字查询
	List<User> queryUserListByUserName(String name);

	// 只根据性别查询
	List<User> queryUserListByGender(String gender);
}
