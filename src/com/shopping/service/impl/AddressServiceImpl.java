package com.shopping.service.impl;

import java.util.List;

import com.shopping.dao.impl.AddressDaoImpl;
import com.shopping.pojo.City;
import com.shopping.pojo.County;
import com.shopping.pojo.Province;
import com.shopping.service.AddressService;

public class AddressServiceImpl implements AddressService {

	@Override
	public List<Province> queryAllProvince() {
		return new AddressDaoImpl().getProvinceList();
	}

	@Override
	public List<City> queryAllCityById(int id) {
		return new AddressDaoImpl().getCityListByPid(id);
	}

	@Override
	public List<County> queryAllCountiesById(int id) {
		return new AddressDaoImpl().getCountyListByCid(id);
	}

	@Override
	public Province queryProvinceById(int id) {
		return new AddressDaoImpl().queryProvinceById(id);
	}

	@Override
	public City queryCityById(int id) {
		return new AddressDaoImpl().queryCityById(id);
	}

	@Override
	public County queryCountiesById(int id) {
		return new AddressDaoImpl().queryCountiesById(id);
	}

}
