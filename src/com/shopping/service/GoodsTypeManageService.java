package com.shopping.service;

import java.util.List;

import com.shopping.pojo.GoodsType;

public interface GoodsTypeManageService {
	// 商品类别查看
	List<GoodsType> queryAllGoodsType();

	// 搜索类别

	// 商品类别修改
	int editGoodsType(GoodsType goodsType);

	// 增加商品类别
	int addGoodsType(GoodsType goodsType);

	// 删除类别及其子类别
	int delGoodsTypeAndGood(int id);

	// 根据level和name查询goodstype信息
	List<GoodsType> queryGoodsTypeByLN(int level, String name);

	// 根据level查询goodstype信息
	List<GoodsType> queryGoodsTypeByLevel(int level);

	// 根据name查询goodstype信息
	List<GoodsType> queryGoodsTypeByName(String name);

	// 根据id查单个
	GoodsType queryGoodsTypeById(int id);

}
