package com.shopping.service.impl;

import java.util.List;

import com.shopping.dao.impl.GoodsDaoImpl;
import com.shopping.dao.impl.GoodsViewDaoImpl;
import com.shopping.pojo.Goods;
import com.shopping.service.GoodsService;
import com.shopping.view.GoodsView;

public class GoodsServiceImpl implements GoodsService {

	@Override
	public List<Goods> queryAllGoods() {
		return new GoodsDaoImpl().queryAllGoods();
	}

	@Override
	public List<Goods> queryAllGoodsByGoodsTypeId(int id) {
		return new GoodsDaoImpl().queryAllGoodsById(id);
	}

	@Override
	public GoodsView queryGoods(int id) {
		return new GoodsViewDaoImpl().queryGoodsView(id);
	}

	@Override
	public List<GoodsView> queryGoodsByName(String typename, String goodsname) {

		return new GoodsViewDaoImpl().queryAllGoodsByName(typename, goodsname);
	}

}
