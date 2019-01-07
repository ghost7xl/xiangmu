package com.shopping.dao;

import java.util.List;

import com.shopping.pojo.GoodsType;

public interface GoodsTypeDao {
	// 增
	int addGoodsType(GoodsType goodsType);

	// 删
	int delGoodsType(int id);

	// 根据parentid删除
	int delGoodsTypeByParentId(int parentId);

	// 改
	int editGoodsType(GoodsType goodsType);

	// 查所有
	List<GoodsType> queryAllGoodsType();

	// 根据id查单个
	GoodsType queryGoodsTypeById(int id);

	// 根据id查所有
//	List<GoodsType> queryAllGoodsTypeById(int id);

	// 根据level和name查询goodstype信息
	List<GoodsType> queryGoodsTypeByLN(int level, String name);

	// 根据level查询goodstype信息
	List<GoodsType> queryGoodsTypeByLevel(int level);

	// 根据name查询goodstype信息
	List<GoodsType> queryGoodsTypeByName(String name);

}
