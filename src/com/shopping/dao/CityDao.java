package com.shopping.dao;

import java.util.List;

import com.shopping.pojo.City;

public interface CityDao {

	// 根据id查所有
	List<City> queryAllCityById(int id);

	// 根据Id查城市
	City queryById(int id);
}
