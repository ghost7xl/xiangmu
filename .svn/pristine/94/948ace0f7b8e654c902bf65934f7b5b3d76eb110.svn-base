package com.shopping.service.impl;

import java.util.List;

import com.shopping.dao.impl.GoodsDaoImpl;
import com.shopping.dao.impl.GoodsViewDaoImpl;
import com.shopping.pojo.Goods;
import com.shopping.service.GoodsManageService;
import com.shopping.view.GoodsView;

public class GoodsManageServiceImpl implements GoodsManageService {

	@Override
	public List<GoodsView> queryAllGoods() {
		return new GoodsViewDaoImpl().queryAllGoodsViews();
	}

	@Override
	public GoodsView queryAllGoods(int id) {
		return new GoodsViewDaoImpl().queryGoodsView(id);
	}

	@Override
	public int editGoods(Goods goods) {
		return new GoodsDaoImpl().editGoods(goods);
	}

	@Override
	public int addGoods(Goods goods) {
		return new GoodsDaoImpl().addGoods(goods);
	}

	@Override
	public int delGoods(int id) {
		return new GoodsDaoImpl().delGoods(id);
	}

	@Override
	public List<GoodsView> queryGoodsViewByName(String name) {
		// TODO Auto-generated method stub
		return new GoodsViewDaoImpl().queryGoodsViewByName(name);
	}

}
