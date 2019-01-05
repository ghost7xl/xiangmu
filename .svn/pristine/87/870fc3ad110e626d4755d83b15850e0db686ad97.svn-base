package com.shopping.service.impl;

import java.util.List;

import com.shopping.dao.GoodsTypeDao;
import com.shopping.dao.impl.GoodsTypeDaoImpl;
import com.shopping.pojo.GoodsType;
import com.shopping.service.GoodsTypeManageService;

public class GoodsTypeManageServiceImpl implements GoodsTypeManageService {

	@Override
	public List<GoodsType> queryAllGoodsType() {
		return new GoodsTypeDaoImpl().queryAllGoodsType();
	}

	@Override
	public int editGoodsType(GoodsType goodsType) {
		return new GoodsTypeDaoImpl().editGoodsType(goodsType);
	}

	@Override
	public int addGoodsType(GoodsType goodsType) {
		return new GoodsTypeDaoImpl().addGoodsType(goodsType);
	}

	@Override
	public int delGoodsTypeAndGood(int id) {
		if (new GoodsTypeDaoImpl().delGoodsType(id) > 0
				&& new GoodsTypeDaoImpl().delGoodsTypeByParentId(id) > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<GoodsType> queryGoodsTypeByLN(int level, String name) {
		// TODO Auto-generated method stub
		GoodsTypeDao gtd = new GoodsTypeDaoImpl();
		List<GoodsType> gtList = gtd.queryGoodsTypeByLN(level, name);
		return gtList;
	}

	@Override
	public List<GoodsType> queryGoodsTypeByLevel(int level) {
		// TODO Auto-generated method stub
		GoodsTypeDao gtd = new GoodsTypeDaoImpl();
		List<GoodsType> gtList = gtd.queryGoodsTypeByLevel(level);
		return gtList;
	}

	@Override
	public List<GoodsType> queryGoodsTypeByName(String name) {
		// TODO Auto-generated method stub
		GoodsTypeDao gtd = new GoodsTypeDaoImpl();
		List<GoodsType> gtList = gtd.queryGoodsTypeByName(name);
		return gtList;
	}

	@Override
	public GoodsType queryGoodsTypeById(int id) {
		// TODO Auto-generated method stub
		GoodsTypeDao gtd = new GoodsTypeDaoImpl();
		GoodsType gt = gtd.queryGoodsTypeById(id);
		return gt;
	}

}
