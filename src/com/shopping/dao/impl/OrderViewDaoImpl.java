package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.OrderViewDao;
import com.shopping.util.DBUtil;
import com.shopping.view.OrderView;

public class OrderViewDaoImpl implements OrderViewDao {

	@Override
	public List<OrderView> queryOrderView() {
		List<OrderView> ov = new ArrayList<OrderView>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from v_order";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			OrderView o = null;
			while (rs.next()) {
				o = new OrderView();
				o.setId(rs.getInt(1));
				o.setOid(rs.getInt(2));
				o.setUid(rs.getInt(3));
				o.setUsername(rs.getString(4));
				o.setUaid(rs.getInt(5));
				o.setGid(rs.getInt(6));
				o.setNum(rs.getInt(7));
				o.setMoney(rs.getDouble(8));
				o.setCreateTime(rs.getDate(9));
				o.setFlag(rs.getInt(10));
				ov.add(o);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ov;
	}

	@Override
	public OrderView queryOrderViewById(int id) {
		OrderView o = null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from v_order where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				o = new OrderView();
				o.setId(rs.getInt(1));
				o.setOid(rs.getInt(2));
				o.setUid(rs.getInt(3));
				o.setUsername(rs.getString(4));
				o.setUaid(rs.getInt(5));
				o.setGid(rs.getInt(6));
				o.setNum(rs.getInt(7));
				o.setMoney(rs.getDouble(8));
				o.setCreateTime(rs.getDate(9));
				o.setFlag(rs.getInt(10));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public List<OrderView> queryAllOrderView(String name, int flag) {
		List<OrderView> ov = new ArrayList<OrderView>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from v_order where username like ? and flag=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + name + '%');
			pstmt.setInt(2, flag);
			ResultSet rs = pstmt.executeQuery();
			OrderView o = null;
			while (rs.next()) {
				o = new OrderView();
				o.setId(rs.getInt(1));
				o.setOid(rs.getInt(2));
				o.setUid(rs.getInt(3));
				o.setUsername(rs.getString(4));
				o.setUaid(rs.getInt(5));
				o.setGid(rs.getInt(6));
				o.setNum(rs.getInt(7));
				o.setMoney(rs.getDouble(8));
				o.setCreateTime(rs.getDate(9));
				o.setFlag(rs.getInt(10));
				ov.add(o);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ov;
	}

	@Override
	public List<OrderView> queryAllOrderViewByName(String name) {
		List<OrderView> ov = new ArrayList<OrderView>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from v_order where username like ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + name + '%');
			ResultSet rs = pstmt.executeQuery();
			OrderView o = null;
			while (rs.next()) {
				o = new OrderView();
				o.setId(rs.getInt(1));
				o.setOid(rs.getInt(2));
				o.setUid(rs.getInt(3));
				o.setUsername(rs.getString(4));
				o.setUaid(rs.getInt(5));
				o.setGid(rs.getInt(6));
				o.setNum(rs.getInt(7));
				o.setMoney(rs.getDouble(8));
				o.setCreateTime(rs.getDate(9));
				o.setFlag(rs.getInt(10));
				ov.add(o);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ov;
	}

	@Override
	public List<OrderView> queryAllOrderViewByFlag(int flag) {
		List<OrderView> ov = new ArrayList<OrderView>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from v_order where flag=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, flag);
			ResultSet rs = pstmt.executeQuery();
			OrderView o = null;
			while (rs.next()) {
				o = new OrderView();
				o.setId(rs.getInt(1));
				o.setOid(rs.getInt(2));
				o.setUid(rs.getInt(3));
				o.setUsername(rs.getString(4));
				o.setUaid(rs.getInt(5));
				o.setGid(rs.getInt(6));
				o.setNum(rs.getInt(7));
				o.setMoney(rs.getDouble(8));
				o.setCreateTime(rs.getDate(9));
				o.setFlag(rs.getInt(10));
				ov.add(o);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ov;
	}

	@Override
	public List<OrderView> queryOrderViewByUid(int id) {
		List<OrderView> ov = new ArrayList<OrderView>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from v_order where uid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			OrderView o = null;
			while (rs.next()) {
				o = new OrderView();
				o.setId(rs.getInt(1));
				o.setOid(rs.getInt(2));
				o.setUid(rs.getInt(3));
				o.setUsername(rs.getString(4));
				o.setUaid(rs.getInt(5));
				o.setGid(rs.getInt(6));
				o.setNum(rs.getInt(7));
				o.setMoney(rs.getDouble(8));
				o.setCreateTime(rs.getDate(9));
				o.setFlag(rs.getInt(10));
				ov.add(o);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ov;
	}
}
