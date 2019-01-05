package com.shopping.dao;

import java.util.List;

import com.shopping.pojo.CartDetail;
import com.shopping.view.CartViewPojo;

public interface CartDetailDao {
	// 增
	int addCartDetail(CartDetail cartDetail);

	// 删
	int delCartDetail(int id);

	// 删所有
	int delAllCartDetail(int cid);

	// 改
	int editCartDetail(CartDetail cartDetail);

	// 查所有
	List<CartDetail> queryAllCartDetail();

	// 根据id查单个
	CartDetail queryCartDetailById(int id);

	// 根据id查所有
	List<CartDetail> queryAllCartDetailById(int id);

	// 根据cid查询
	List<CartDetail> queryCartDetailByCid(int id);

	// 通过id查询购物车
	List<CartViewPojo> queryAllCartViewById(int id);

	// 查询是否有数据
	CartDetail querCartDetailByCidAndGid(int cid, int gid);

}
