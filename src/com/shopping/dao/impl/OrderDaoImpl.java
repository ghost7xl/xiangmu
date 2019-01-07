package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.shopping.dao.OrderDao;
import com.shopping.pojo.Order;
import com.shopping.util.DBUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
	public int addNewOrder(Order order) {
		Connection conn = DBUtil.getConnection();
		int i = 0;
		String sql = "insert into t_order values(null,?,?,null,?,1)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, order.getUid());
			pstmt.setInt(2, order.getUaid());
			pstmt.setDouble(3, order.getMoney());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				i = rs.getInt(1);
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int editOrder(Order order) {
		Connection conn = DBUtil.getConnection();
		int i = 0;
		String sql = "update t_order set uid=?, uaid=?,money=?,flag=? where id = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getUid());
			pstmt.setInt(2, order.getUaid());
			pstmt.setDouble(3, order.getMoney());
			pstmt.setInt(4, order.getFlag());
			pstmt.setInt(5, order.getId());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Order> queryAllOrder() {
		List<Order> list = new ArrayList<Order>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_order";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Order o = null;
			while (rs.next()) {
				o = new Order();
				o.setId(rs.getInt("id"));
				o.setUid(rs.getInt("uid"));
				o.setUaid(rs.getInt("uaid"));
				o.setMoney(rs.getDouble("money"));
				o.setCreatetime(rs.getDate("createtime"));
				o.setFlag(rs.getInt("flag"));
				list.add(o);

			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Order queryOrderById(int id) {
		Order o = null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_order where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				o = new Order();
				o.setId(rs.getInt("id"));
				o.setUid(rs.getInt("uid"));
				o.setUaid(rs.getInt("uaid"));
				o.setMoney(rs.getDouble("money"));
				o.setCreatetime(rs.getDate("createtime"));
				o.setFlag(rs.getInt("flag"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}

	@Override
	public List<Order> queryAllOrderById(int id) {
		List<Order> or = new ArrayList<Order>();
		Order o = null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_order where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				o = new Order();
				o.setId(rs.getInt("id"));
				o.setUid(rs.getInt("uid"));
				o.setUaid(rs.getInt("uaid"));
				o.setMoney(rs.getDouble("money"));
				o.setCreatetime(rs.getDate("createtime"));
				o.setFlag(rs.getInt("flag"));
				or.add(o);

			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return or;
	}

	@Override
	public int delOrder(int id) {
		int i = 0;
		Connection conn = DBUtil.getConnection();
		String sql = "delete * from t_order where id =?";
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

}
