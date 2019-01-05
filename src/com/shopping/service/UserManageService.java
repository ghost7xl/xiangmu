package com.shopping.service;

import java.util.List;

import com.shopping.pojo.User;

public interface UserManageService {
	// 会员搜索 根据姓名，性别等进行搜索
	List<User> queryUsers(String name,String gender);

	// 会员列表查看，查看当前可用会员信息
	List<User> queryAllUser();

	// 修改会员信息
	int editUser(Object... o);

	// 会员删除 删除会员信息
	int delUser(int id);

}
