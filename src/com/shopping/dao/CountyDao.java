package com.shopping.dao;

import java.util.List;

import com.shopping.pojo.County;

public interface CountyDao {
	// 根据id查所有
	List<County> queryAllCountyById(int id);

	// 根据Id查县城
	County queryById(int id);
}
