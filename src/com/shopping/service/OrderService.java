package com.shopping.service;

import java.util.List;

import com.shopping.pojo.City;
import com.shopping.pojo.County;
import com.shopping.pojo.Goods;
import com.shopping.pojo.OrderDetail;
import com.shopping.pojo.Province;
import com.shopping.pojo.User;
import com.shopping.pojo.UserAddress;
import com.shopping.view.GoodsOrderDetailView;
import com.shopping.view.OrderView;

public interface OrderService {
	// 订单查看
	// 查看订单列表
	List<OrderView> queryAllOrder();

	// 查看订单详情
	OrderView queryOrderView(int id);

	// 查看订单用户信息
	User queryOrderUser(int id);

	// 查看订单用户地址信息
	UserAddress queryOrderUserAddress(int id);

	// 查看订单商品信息
	Goods queryOrderGoods(int id);

	// 查询一个订单的所有商品的集合
	List<GoodsOrderDetailView> queryAllListGoods(List<OrderDetail> odList);

	// 查询一个订单的所有detail
	List<OrderDetail> queryAllOrderDetailsById(int id);

	// 搜索订单模糊查询
	List<OrderView> queryOrder(String name,String flag);

	// 修改订单状态 修改已支付订单状态至发货状态
	int editOrder(int id, int state);

	// 根据id查省份
	Province queryProvinceById(int id);

	// 根据id查城市
	City queryCityById(int id);

	County queryCountyById(int id);
	// 根据id查县城

}
