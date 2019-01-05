package com.shopping.dao;

import java.util.List;

import com.shopping.pojo.City;
import com.shopping.pojo.County;
import com.shopping.pojo.Province;

public interface AddressDao {
	// 获取所有的省
	List<Province> getProvinceList();

	// 获取所有的市
	List<City> getCityListByPid(int pid);

	// 获取所有的县
	List<County> getCountyListByCid(int cid);

	// 根据省id获取省
	Province queryProvinceById(int id);

	// 根据省id获取市
	City queryCityById(int id);

	// 根据市id获取县
	County queryCountiesById(int id);

}
