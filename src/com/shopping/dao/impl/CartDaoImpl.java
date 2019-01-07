package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.CartDao;
import com.shopping.pojo.Cart;
import com.shopping.util.DBUtil;

public class CartDaoImpl implements CartDao {

	@Override
	public int addCart(Cart cart) {
		Connection con = DBUtil.getConnection();
		String sql = "insert into t_cart values(null,?,?)";
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart.getUid());
			ps.setDouble(2, cart.getMoney());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int delCart(int id) {
		Connection con = DBUtil.getConnection();
		String sql = "delete from t_cart where id = ?";
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int editCart(Cart cart) {
		Connection con = DBUtil.getConnection();
		String sql = "update t_cart set uid = ?,money = ? where id = ?";
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart.getUid());
			ps.setDouble(2, cart.getMoney());
			ps.setInt(3, cart.getId());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Cart> queryAllCarts() {
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_cart";
		List<Cart> cartList = new ArrayList<Cart>();
		Cart cart = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setUid(rs.getInt("uid"));
				cart.setMoney(rs.getDouble("money"));
				cartList.add(cart);
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public Cart queryCartById(int id) {
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_cart where id = ?";
		Cart cart = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setUid(rs.getInt("uid"));
				cart.setMoney(rs.getDouble("money"));
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}

	@Override
	public List<Cart> queryAllCartById() {
		// TODO Auto-generated method stub
		return null;
	}

	// 增加数量
	public int addCartnum(int id) {
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE cartdetail SET num = num+1 WHERE id = ?";
		int i = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	// 查看数量
	public int getCartnumById(int id) {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT num FROM cartdetail WHERE id = ?";
		int i = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				i = rs.getInt("num");
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	// 查出gid
	public int getCartgidById(int id) {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT gid FROM cartdetail WHERE id = ?";
		int gid = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				gid = rs.getInt("gid");
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gid;
	}

	// 查看单价
	public double getPriceById(int id) {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT price FROM goods WHERE id = ?";
		Double price = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				price = rs.getDouble("price");
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}

	// 改变金额
	public int changeCartmoney2(int id, Double money) {
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE cartdetail SET money = ? WHERE id = ?";
		int i = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, money);
			pstmt.setInt(2, id);
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Cart queryCartByUid(int id) {
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_cart where uid = ?";
		Cart cart = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setUid(rs.getInt("uid"));
				cart.setMoney(rs.getDouble("money"));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cart;
	}

}
