package com.shopping.dao;

import java.util.List;

import com.shopping.pojo.UserAddress;

public interface UserAddressDao {
	// 增
	int addUserAddress(UserAddress userAddress);

	// 删
	int delUserAddress(int id);

	// 改
	int editUserAddress(UserAddress userAddress);

	// 查所有
	List<UserAddress> queryAllUserAddress();

	// 根据Uid查所有
	List<UserAddress> queryAllUserAddressByUid(int uid);

	// 根据id查单个
	UserAddress queryUserAddressById(int id);

}
