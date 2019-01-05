package com.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.impl.CartDaoImpl;
import com.shopping.dao.impl.CartDetailDaoImpl;
import com.shopping.dao.impl.GoodsDaoImpl;
import com.shopping.dao.impl.OrderDaoImpl;
import com.shopping.dao.impl.OrderDetailDaoImpl;
import com.shopping.dao.impl.OrderViewDaoImpl;
import com.shopping.dao.impl.UserAddressDaoImpl;
import com.shopping.dao.impl.UserDaoImpl;
import com.shopping.pojo.Cart;
import com.shopping.pojo.CartDetail;
import com.shopping.pojo.Goods;
import com.shopping.pojo.Order;
import com.shopping.pojo.OrderDetail;
import com.shopping.pojo.User;
import com.shopping.pojo.UserAddress;
import com.shopping.service.UserService;
import com.shopping.view.GoodsOrderDetailView;
import com.shopping.view.OrderView;
import com.shopping.view.UserOrderPojo;

public class UserServiceImpl implements UserService {

	@Override
	public int registerUser(User user) {
		if (new UserDaoImpl().queryUser(user.getUsername(), user.getPassword()) != null) {
			return 0;
		}else {
			// 添加一个用户
			int j =new UserDaoImpl().addUser(user);
			// 插入一个空的购物车
			int usid = new UserDaoImpl().queryUserByname(user.getUsername()).getId();
			int i = new CartDaoImpl().addCart(new Cart(0, usid, 0));
			return i*j; 
		}
	}

	@Override
	public User loginUser(String username, String password) {
		return new UserDaoImpl().queryUser(username, password);
	}

	@Override
	public User showUser(int id) {
		return new UserDaoImpl().queryUser(id);
	}

	@Override
	public int editUser(Object... o) {
		User user2 = new UserDaoImpl().queryUser((int) o[0]);
		user2.setEmail((String) o[1]);
		user2.setUsername((String) o[2]);
		user2.setGender((String) o[3]);
		user2.setPassword((String) o[4]);
		int i = new UserDaoImpl().editUser(user2);
		return i;
	}

	@Override
	public int cancelOrder(int id) {
		Order order = new OrderDaoImpl().queryOrderById(id);
		order.setFlag(1);
		return new OrderDaoImpl().editOrder(order);

	}

	@Override
	public int delOrder(int id) {
		if (new OrderDaoImpl().delOrder(id) > 0
				&& new OrderDetailDaoImpl().delOrder(id) > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int addAddress(UserAddress userAddress) {
		return new UserAddressDaoImpl().addUserAddress(userAddress);
	}

	@Override
	public int delAddress(int id) {
		return new UserAddressDaoImpl().delUserAddress(id);
	}

	@Override
	public int editAddress(UserAddress userAddress) {
		return new UserAddressDaoImpl().editUserAddress(userAddress);
	}

	@Override
	public List<UserAddress> queryAllUserAddressById(int id) {
		return new UserAddressDaoImpl().queryAllUserAddressByUid(id);
	}

	@Override
	public List<CartDetail> queryAllCartDetailByUserId(int id) {
		int cartId = new CartDaoImpl().queryCartById(id).getId();
		return new CartDetailDaoImpl().queryAllCartDetailById(cartId);
	}

	@Override
	public int editCartDetail(CartDetail cartDetail) {
		return new CartDetailDaoImpl().editCartDetail(cartDetail);
	}

	@Override
	public int delCartDetail(int id) {
		return new CartDetailDaoImpl().delCartDetail(id);
	}

	@Override
	public int editCartnum(int id, int num) {
		CartDetail cartDetail = new CartDetailDaoImpl().queryCartDetailById(id);
		cartDetail.setNum(num);
		return new CartDetailDaoImpl().editCartDetail(cartDetail);
	}

	@Override
	public int subCartResult(int id) {
		Order order = new OrderDaoImpl().queryOrderById(id);
		order.setFlag(1);
		return new OrderDaoImpl().editOrder(order);
	}

	@Override
	public int createOrder(Order order, OrderDetail orderDetail) {
		int i = new OrderDaoImpl().addNewOrder(order);
		orderDetail.setOid(i);
		int j = new OrderDetailDaoImpl().addNewOrder(orderDetail);
		if (i > 0 && j > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public UserOrderPojo queryAllOrderViewByUid(int id) {
		// 查询orderView视图并获取的集合数据
		List<OrderView> ovList = new OrderViewDaoImpl().queryOrderViewByUid(id);
		if (ovList == null) {
			return null;
		}
		UserOrderPojo uoPojo = new UserOrderPojo();
		uoPojo.setOid(ovList.get(0).getOid());
		uoPojo.setCreatetime(ovList.get(0).getCreateTime());
		uoPojo.setAddressname(new UserAddressDaoImpl().queryUserAddressById(
				ovList.get(0).getUaid()).getName());
		uoPojo.setTel(new UserAddressDaoImpl().queryUserAddressById(
				ovList.get(0).getUaid()).getPhone());
		uoPojo.setAddress(new UserAddressDaoImpl().queryUserAddressById(
				ovList.get(0).getUaid()).getDetail());
		double price = 0;
		for (int j = 0; j < ovList.size(); j++) {
			price += ovList.get(j).getNum() * ovList.get(j).getMoney();
		}
		uoPojo.setAllprice(price);
		// 获取godvList列表属性
		List<OrderView> odList = new OrderViewDaoImpl().queryOrderViewByUid(id);
		List<GoodsOrderDetailView> godvList = new ArrayList<GoodsOrderDetailView>();
		for (int i = 0; i < odList.size(); i++) {
			GoodsOrderDetailView godv = new GoodsOrderDetailView();
			godv.setId(new GoodsDaoImpl()
					.queryGoodsById(odList.get(i).getGid()).getId());
			godv.setPicture(new GoodsDaoImpl().queryGoodsById(
					odList.get(i).getGid()).getPicture());
			godv.setName(new GoodsDaoImpl().queryGoodsById(
					odList.get(i).getGid()).getName());
			godv.setStar(new GoodsDaoImpl().queryGoodsById(
					odList.get(i).getGid()).getStar());
			godv.setPubdate(new GoodsDaoImpl().queryGoodsById(
					odList.get(i).getGid()).getPubdate());
			godv.setMoney(odList.get(i).getMoney());
			godv.setNum(odList.get(i).getNum());
			godv.setAllmoney(odList.get(i).getMoney() * odList.get(i).getNum());
			godvList.add(godv);
		}
		uoPojo.setGodvList(godvList);
		return uoPojo;
	}

	@Override
	public CartDetail querCartDetailByCidAndGid(int cid, int gid) {
		return new CartDetailDaoImpl().querCartDetailByCidAndGid(cid, gid);
	}

	@Override
	public int queryCartId(int id) {
		return new CartDaoImpl().queryCartByUid(id).getId();
	}

	@Override
	public int addNewCart(CartDetail cartDetail) {
		int i = new CartDetailDaoImpl().addCartDetail(cartDetail);
		if (i > 0) {
			double newprice = cartDetail.getNum() * cartDetail.getMoney();
			Cart cart = new CartDaoImpl().queryCartById(cartDetail.getCid());
			cart.setMoney(cart.getMoney() + newprice);
			return new CartDaoImpl().editCart(cart);
		} else {
			return 0;
		}
	}

	@Override
	public List<GoodsOrderDetailView> queryAllCartViewByUid(int uid) {
		List<OrderView> odList = new OrderViewDaoImpl()
				.queryOrderViewByUid(uid);
		List<GoodsOrderDetailView> godvList = new ArrayList<GoodsOrderDetailView>();
		for (int i = 0; i < odList.size(); i++) {
			GoodsOrderDetailView godv = new GoodsOrderDetailView();
			godv.setId(new GoodsDaoImpl()
					.queryGoodsById(odList.get(i).getGid()).getId());
			godv.setPicture(new GoodsDaoImpl().queryGoodsById(
					odList.get(i).getGid()).getPicture());
			godv.setName(new GoodsDaoImpl().queryGoodsById(
					odList.get(i).getGid()).getName());
			godv.setStar(new GoodsDaoImpl().queryGoodsById(
					odList.get(i).getGid()).getStar());
			godv.setPubdate(new GoodsDaoImpl().queryGoodsById(
					odList.get(i).getGid()).getPubdate());
			godv.setMoney(odList.get(i).getMoney());
			godv.setNum(odList.get(i).getNum());
			godv.setAllmoney(odList.get(i).getMoney() * odList.get(i).getNum());
			godvList.add(godv);
		}
		return godvList;
	}

	@Override
	public Cart queryCartByUid(int id) {
		return new CartDaoImpl().queryCartByUid(id);
	}

	@Override
	public Goods queryGoodsById(int gid) {
		return new GoodsDaoImpl().queryGoodsById(gid);
	}

	@Override
	public List<CartDetail> queryGidByCid(int cid) {
		return new CartDetailDaoImpl().queryCartDetailByCid(cid);
	}

	@Override
	public CartDetail queryCartDetail(int id) {
		return new CartDetailDaoImpl().queryCartDetailById(id);
	}

	@Override
	public Cart queryCart(int id) {
		return new CartDaoImpl().queryCartById(id);
	}

	@Override
	public int editCart(Cart cart) {
		return new CartDaoImpl().editCart(cart);
	}

	@Override
	public int delAllCartDetail(int cid) {
		return new CartDetailDaoImpl().delAllCartDetail(cid);
	}

	@Override
	public List<UserAddress> queryAllUserAddressByUid(int uid) {
		return new UserAddressDaoImpl().queryAllUserAddressByUid(uid);
	}
}
