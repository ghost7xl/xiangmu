package com.shopping.dao;

import java.util.List;

import com.shopping.pojo.Order;

public interface OrderDao {
	// 增
	int addNewOrder(Order order);

	// 删
	int delOrder(int id);

	// 改
	int editOrder(Order order);

	// 查所有
	List<Order> queryAllOrder();

	// 根据id查单个
	Order queryOrderById(int id);

	// 根据id查所有
	List<Order> queryAllOrderById(int id);
}
