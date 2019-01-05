package com.shopping.service.impl;

import java.util.List;

import com.shopping.dao.impl.SysUserDaoImpl;
import com.shopping.pojo.SysUser;
import com.shopping.service.SysUserService;

public class SysUserServiceImpl implements SysUserService {

	@Override
	public int loginSysUser(String adminName, String password) {
		if (new SysUserDaoImpl().querySysUser(adminName, password) == null) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int editSysUser(SysUser sysUser) {
		return new SysUserDaoImpl().editSysUser(sysUser);
	}

	@Override
	public List<SysUser> queryAllSysUsers() {
		return new SysUserDaoImpl().queryAllSysUsers();
	}

	@Override
	public int delSysUser(int id) {
		return new SysUserDaoImpl().delSysUser(id);
	}

}
