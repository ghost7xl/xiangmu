package com.shopping.service;

import java.util.List;

import com.shopping.pojo.Goods;
import com.shopping.view.GoodsView;

//商品管理
public interface GoodsManageService {
	// 商品查看
	// 查看商品列表，
	List<GoodsView> queryAllGoods();

	// 查看商品详情
	GoodsView queryAllGoods(int goodsId);

	// 搜索商品

	// 修改商品类别
	int editGoods(Goods goods);

	// 增加商品信息
	int addGoods(Goods goods);

	// 删除商品
	int delGoods(int id);

	// 按商品名称查找商品详情
	List<GoodsView> queryGoodsViewByName(String name);

}
