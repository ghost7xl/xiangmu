package com.shopping.dao;

import java.util.List;

import com.shopping.view.GoodsView;

public interface GoodsViewDao {
	// 查询商品全部信息
	List<GoodsView> queryAllGoodsViews();

	// 查询单个商品信息
	GoodsView queryGoodsView(int id);

	// 模糊查询
	List<GoodsView> queryAllGoodsByName(String typename, String goodsname);

	// 按商品名称查找商品信息
	List<GoodsView> queryGoodsViewByName(String name);
}
