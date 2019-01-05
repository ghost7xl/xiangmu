package com.shopping.dao;

import java.util.List;

import com.shopping.view.OrderView;

public interface OrderViewDao {
	// 视图查询
	List<OrderView> queryOrderView();

	// 根据用户id查询所有
	List<OrderView> queryOrderViewByUid(int id);

	// 根据id查单个
	OrderView queryOrderViewById(int id);

	// 模糊查询
	List<OrderView> queryAllOrderView(String name, int flag);

	// name
	List<OrderView> queryAllOrderViewByName(String name);

	// flag
	List<OrderView> queryAllOrderViewByFlag(int flag);
}
