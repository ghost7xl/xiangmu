package com.shopping.dao;

import java.util.List;

import com.shopping.pojo.Province;

public interface ProvinceDao {
	// 查所有
	List<Province> queryAllProvince();

	// 根据Id查省份
	Province queryById(int id);
}
