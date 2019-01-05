package com.shopping.service;

import java.util.List;

import com.shopping.pojo.SysUser;

public interface SysUserService {
	// 管理员登录
	int loginSysUser(String adminName, String password);

	// 管理员修改登录密码
	int editSysUser(SysUser sysUser);

	// 查询所有的管理员
	List<SysUser> queryAllSysUsers();

	// 管理员信息删除
	int delSysUser(int id);
	// 退出登录 直接销毁session
}
