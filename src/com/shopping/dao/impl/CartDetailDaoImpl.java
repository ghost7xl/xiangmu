package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.CartDetailDao;
import com.shopping.pojo.CartDetail;
import com.shopping.util.DBUtil;
import com.shopping.view.CartViewPojo;

public class CartDetailDaoImpl implements CartDetailDao {

	@Override
	public int addCartDetail(CartDetail cartDetail) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = DBUtil.getConnection();
		String sql = "insert into t_cartdetail values(null,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartDetail.getCid());
			ps.setInt(2, cartDetail.getGid());
			ps.setInt(3, cartDetail.getNum());
			ps.setDouble(4, cartDetail.getMoney());
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
	public int delCartDetail(int id) {
		int i = 0;
		Connection con = DBUtil.getConnection();
		String sql = "delete from t_cartdetail where id = ?";
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
	public int editCartDetail(CartDetail cartDetail) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = DBUtil.getConnection();
		String sql = "update t_cartdetail set cid = ?,gid = ?,num = ?,money = ? where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartDetail.getCid());
			ps.setInt(2, cartDetail.getGid());
			ps.setInt(3, cartDetail.getNum());
			ps.setDouble(4, cartDetail.getMoney());
			ps.setInt(5, cartDetail.getId());
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
	public List<CartDetail> queryAllCartDetail() {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_cartdetail";
		List<CartDetail> cdList = new ArrayList<CartDetail>();
		CartDetail cartDetail = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cartDetail = new CartDetail();
				cartDetail.setId(rs.getInt("id"));
				cartDetail.setCid(rs.getInt("cid"));
				cartDetail.setGid(rs.getInt("gid"));
				cartDetail.setNum(rs.getInt("num"));
				cartDetail.setMoney(rs.getDouble("money"));
				cdList.add(cartDetail);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cdList;
	}

	@Override
	public CartDetail queryCartDetailById(int id) {
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_cartdetail where id = ?";
		CartDetail cartDetail = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cartDetail = new CartDetail();
				cartDetail.setId(rs.getInt("id"));
				cartDetail.setCid(rs.getInt("cid"));
				cartDetail.setGid(rs.getInt("gid"));
				cartDetail.setNum(rs.getInt("num"));
				cartDetail.setMoney(rs.getDouble("money"));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cartDetail;
	}

	@Override
	public List<CartDetail> queryAllCartDetailById(int cid) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_cartdetail where cid = ?";
		List<CartDetail> cdList = new ArrayList<CartDetail>();
		CartDetail cartDetail = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cartDetail = new CartDetail();
				cartDetail.setId(rs.getInt("id"));
				cartDetail.setCid(rs.getInt("cid"));
				cartDetail.setGid(rs.getInt("gid"));
				cartDetail.setNum(rs.getInt("num"));
				cartDetail.setMoney(rs.getDouble("money"));
				cdList.add(cartDetail);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cdList;
	}

	@Override
	public List<CartDetail> queryCartDetailByCid(int id) {
		List<CartDetail> cList = new ArrayList<CartDetail>();
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_cartdetail where cid = ?";
		CartDetail cartDetail = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cartDetail = new CartDetail();
				cartDetail.setId(rs.getInt("id"));
				cartDetail.setCid(rs.getInt("cid"));
				cartDetail.setGid(rs.getInt("gid"));
				cartDetail.setNum(rs.getInt("num"));
				cartDetail.setMoney(rs.getDouble("money"));
				cList.add(cartDetail);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cList;
	}

	@Override
	public List<CartViewPojo> queryAllCartViewById(int id) {
		List<CartViewPojo> cv = new ArrayList<CartViewPojo>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from cartview where id =?";
		CartViewPojo c = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				c = new CartViewPojo();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPrice(rs.getDouble(3));
				c.setNum(rs.getInt(4));
				c.setMoney(rs.getDouble(5));
				cv.add(c);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cv;
	}

	@Override
	public CartDetail querCartDetailByCidAndGid(int cid, int gid) {
		System.out.println("cid is .."+cid+"gid is .."+gid);
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_cartdetail where cid= ? and gid = ?";
		CartDetail cartDetail = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, gid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cartDetail = new CartDetail();
				cartDetail.setId(rs.getInt("id"));
				cartDetail.setCid(rs.getInt("cid"));
				cartDetail.setGid(rs.getInt("gid"));
				cartDetail.setNum(rs.getInt("num"));
				cartDetail.setMoney(rs.getDouble("money"));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartDetail;
	}

	@Override
	public int delAllCartDetail(int id) {
		int i = 0;
		Connection con = DBUtil.getConnection();
		String sql = "delete from t_cartdetail where cid = ?";
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

}
