package com.shopping.dao;

import java.util.List;

import com.shopping.pojo.SysUser;

public interface SysUserDao {
	// 改
	int editSysUser(SysUser sysUser);

	// 查询所有管理员信息
	List<SysUser> queryAllSysUsers();

	// 删除管理员信息
	int delSysUser(int id);

	// 根据账户密码查
	SysUser querySysUser(String name, String password);
}
