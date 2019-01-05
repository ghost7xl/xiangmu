package com.shopping.service;

import java.util.List;

import com.shopping.pojo.Goods;
import com.shopping.view.GoodsView;

public interface GoodsService {
	//首页商品展示
	List<Goods> queryAllGoods();
	//商品类别筛选
	List<Goods> queryAllGoodsByGoodsTypeId(int id);
	//商品浏览详情
	GoodsView queryGoods(int id);
	//商品搜索列表
    List<GoodsView> queryGoodsByName(String name,String goodsname);

	
}
