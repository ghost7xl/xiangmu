package com.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.impl.CityDaoImpl;
import com.shopping.dao.impl.CountyDaoImpl;
import com.shopping.dao.impl.GoodsDaoImpl;
import com.shopping.dao.impl.OrderDaoImpl;
import com.shopping.dao.impl.OrderDetailDaoImpl;
import com.shopping.dao.impl.OrderViewDaoImpl;
import com.shopping.dao.impl.ProvinceDaoImpl;
import com.shopping.dao.impl.UserAddressDaoImpl;
import com.shopping.dao.impl.UserDaoImpl;
import com.shopping.pojo.City;
import com.shopping.pojo.County;
import com.shopping.pojo.Goods;
import com.shopping.pojo.Order;
import com.shopping.pojo.OrderDetail;
import com.shopping.pojo.Province;
import com.shopping.pojo.User;
import com.shopping.pojo.UserAddress;
import com.shopping.service.OrderService;
import com.shopping.view.GoodsOrderDetailView;
import com.shopping.view.OrderView;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<OrderView> queryAllOrder() {
		return new OrderViewDaoImpl().queryOrderView();
	}

	@Override
	public OrderView queryOrderView(int id) {
		return new OrderViewDaoImpl().queryOrderViewById(id);
	}

	@Override
	public int editOrder(int id, int flag) {
		Order order = new OrderDaoImpl().queryOrderById(id);
		order.setFlag(flag);
		return new OrderDaoImpl().editOrder(order);
	}

	@Override
	public User queryOrderUser(int id) {
		return new UserDaoImpl().queryUser(id);
	}

	@Override
	public UserAddress queryOrderUserAddress(int id) {
		return new UserAddressDaoImpl().queryUserAddressById(id);
	}

	@Override
	public Goods queryOrderGoods(int id) {
		return new GoodsDaoImpl().queryGoodsById(id);
	}

	@Override
	public List<GoodsOrderDetailView> queryAllListGoods(List<OrderDetail> odList) {
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
	public List<OrderDetail> queryAllOrderDetailsById(int id) {
		return new OrderDetailDaoImpl().queryAllOrderDetailById(id);
	}

	@Override
	public Province queryProvinceById(int id) {
		return new ProvinceDaoImpl().queryById(id);
	}

	@Override
	public City queryCityById(int id) {
		return new CityDaoImpl().queryById(id);
	}

	@Override
	public County queryCountyById(int id) {
		return new CountyDaoImpl().queryById(id);
	}

	@Override
	public List<OrderView> queryOrder(String name, String flag) {
		if (name != null && !" ".equals(flag)) {
			return new OrderViewDaoImpl().queryAllOrderView(name,
					Integer.parseInt(flag));
		} else if (name != null && " ".equals(flag)) {
			return new OrderViewDaoImpl().queryAllOrderViewByName(name);
		} else if (name == null && !" ".equals(flag)) {
			return new OrderViewDaoImpl().queryAllOrderViewByFlag(Integer
					.parseInt(flag));
		} else {
			return null;
		}
	}

}
