package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.OrderDetailDao;
import com.shopping.pojo.OrderDetail;
import com.shopping.util.DBUtil;

public class OrderDetailDaoImpl implements OrderDetailDao {

	@Override
	public int addNewOrder(OrderDetail orderDetail) {
		Connection conn = DBUtil.getConnection();
		int i = 0;
		String sql = "insert into t_orderdetail values(null,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderDetail.getOid());
			pstmt.setInt(2, orderDetail.getGid());
			pstmt.setInt(3, orderDetail.getNum());
			pstmt.setDouble(4, orderDetail.getMoney());
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
	public int delOrder(int id) {
		int i = 0;
		Connection conn = DBUtil.getConnection();
		String sql = "delete * from t_orderdetail where oid =?";
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

	@Override
	public int editOrder(OrderDetail orderDetail) {
		Connection conn = DBUtil.getConnection();
		int i = 0;
		String sql = "update from t_orderdetail set gid=?,num=?,money=? where oid = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderDetail.getGid());
			pstmt.setInt(2, orderDetail.getNum());
			pstmt.setDouble(3, orderDetail.getMoney());
			pstmt.setInt(4, orderDetail.getOid());
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
	public List<OrderDetail> queryAllOrderDetail() {
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_orderdetail";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			OrderDetail o = null;
			while(rs.next()){
				o = new OrderDetail();
				o.setId(rs.getInt("id"));
				o.setOid(rs.getInt("oid"));
				o.setGid(rs.getInt("gid"));
				o.setNum(rs.getInt("num"));
				o.setMoney(rs.getDouble("money"));
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
	public OrderDetail queryOrderDetailById(int id) {
		OrderDetail o = null;
		Connection conn  = DBUtil.getConnection();
		String sql = "select * from t_orderdetail where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				 o = new OrderDetail();
				    o.setId(rs.getInt("id"));
					o.setOid(rs.getInt("oid"));
					o.setGid(rs.getInt("gid"));
					o.setNum(rs.getInt("num"));
					o.setMoney(rs.getDouble("money"));
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
	public List<OrderDetail> queryAllOrderDetailById(int id) {
		List<OrderDetail> or = new ArrayList<OrderDetail>();
		OrderDetail o = null;
		Connection conn  = DBUtil.getConnection();
		String sql = "select * from t_orderdetail where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 o = new OrderDetail();
				 o.setId(rs.getInt("id"));
					o.setOid(rs.getInt("oid"));
					o.setGid(rs.getInt("gid"));
					o.setNum(rs.getInt("num"));
					o.setMoney(rs.getDouble("money"));
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

}
