package com.shopping.service;

import java.util.List;

import com.shopping.pojo.Cart;
import com.shopping.pojo.CartDetail;
import com.shopping.pojo.Goods;
import com.shopping.pojo.Order;
import com.shopping.pojo.OrderDetail;
import com.shopping.pojo.User;
import com.shopping.pojo.UserAddress;
import com.shopping.view.GoodsOrderDetailView;
import com.shopping.view.UserOrderPojo;

public interface UserService {
	// 用户注册
	int registerUser(User user);

	// 用户登录
	User loginUser(String username, String password);

	// 用户退出 session销毁在servlet里面直接写就行

	// 个人中心查看修改资料写在一起，查看的同时可以修改
	// 查看资料
	User showUser(int id);

	// 修改个人账户
	int editUser(Object... o);

	// 订单管理
	// 根据用户id查看订单详情
	UserOrderPojo queryAllOrderViewByUid(int id);

	// 取消订单
	int cancelOrder(int id);

	// 删除订单(假删除)
	int delOrder(int id);

	// 订单评价(可选)

	// 收货地址管理
	// 增
	int addAddress(UserAddress userAddress);

	// 删
	int delAddress(int id);

	// 改
	int editAddress(UserAddress userAddress);

	// 查
	List<UserAddress> queryAllUserAddressById(int id);

	// 查
	List<UserAddress> queryAllUserAddressByUid(int uid);

	// 购物车
	// 查看购物车
	List<CartDetail> queryAllCartDetailByUserId(int id);

	// 查询是否有数据
	CartDetail querCartDetailByCidAndGid(int uid, int gid);

	// 通过uid查询cart的id
	int queryCartId(int id);

	// 将商品插入购物车购物车
	int addNewCart(CartDetail cartDetail);

	// 购物车商品修改
	int editCartDetail(CartDetail cartDetail);

	// 购物车商品删除
	int delCartDetail(int id);

	// 清空用户的购物车
	int delAllCartDetail(int cid);

	// 含数量修改
	int editCartnum(int id, int num);

	// 提交订单结算
	int subCartResult(int id);

	// 生成新订单
	int createOrder(Order order, OrderDetail orderDetail);

	// 通过uid查购物车列表
	List<GoodsOrderDetailView> queryAllCartViewByUid(int uid);

	// 根据uid查询cart
	Cart queryCartByUid(int id);

	// 根据gid查询goodsname
	Goods queryGoodsById(int gid);

	// 根据cid查询gid
	List<CartDetail> queryGidByCid(int cid);

	// 根据id查cartDetal
	CartDetail queryCartDetail(int id);

	// 根据id查cart
	Cart queryCart(int id);

	// num改动，修改cart
	int editCart(Cart cart);
}
