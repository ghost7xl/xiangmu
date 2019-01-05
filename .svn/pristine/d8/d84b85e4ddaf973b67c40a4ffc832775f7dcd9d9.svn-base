package com.shopping.dao;

import java.util.List;

import com.shopping.pojo.Cart;

public interface CartDao {
	// 增
	int addCart(Cart cart);

	// 删
	int delCart(int id);

	// 改
	int editCart(Cart cart);

	// 查所有
	List<Cart> queryAllCarts();

	// 根据id查单个
	Cart queryCartById(int id);

	// 根据id查所有
	List<Cart> queryAllCartById();

	// 增加数量
	int addCartnum(int id);

	// 查看数量
	int getCartnumById(int id);

	// 查出gid
	int getCartgidById(int id);

	// 查看单价
	double getPriceById(int id);

	// 改变金额
	int changeCartmoney2(int id, Double money);

	// 通过用户id查询所有
	Cart queryCartByUid(int id);

}
