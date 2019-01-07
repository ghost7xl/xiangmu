package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.GoodsTypeDao;
import com.shopping.pojo.GoodsType;
import com.shopping.util.DBUtil;

public class GoodsTypeDaoImpl implements GoodsTypeDao {

	@Override
	public int addGoodsType(GoodsType goodsType) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "insert into t_goodstype values(null,?,?,?,2)";
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, goodsType.getName());
			ps.setInt(2, goodsType.getLevel());
			ps.setInt(3, goodsType.getParentid());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 * 假删除，flag改成1即可
	 */
	@Override
	public int delGoodsType(int id) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "update t_goodstype set flag = 1 where id=?";
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
	public int editGoodsType(GoodsType goodsType) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "update t_goodstype set name = ?,level = ?,parentid=? where id=?";
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, goodsType.getName());
			ps.setInt(2, goodsType.getLevel());
			ps.setInt(3, goodsType.getParentid());
			ps.setInt(4, goodsType.getId());
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
	public List<GoodsType> queryAllGoodsType() {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_goodstype where flag = 2";
		List<GoodsType> gtList = new ArrayList<GoodsType>();
		GoodsType gt = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				gt = new GoodsType();
				gt.setId(rs.getInt("id"));
				gt.setName(rs.getString("name"));
				gt.setLevel(rs.getInt("level"));
				gt.setParentid(rs.getInt("parentid"));
				gt.setFlag(rs.getInt("flag"));
				gtList.add(gt);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gtList;
	}

	@Override
	public GoodsType queryGoodsTypeById(int id) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_goodstype where flag = 2 and id = ?";
		GoodsType gt = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				gt = new GoodsType();
				gt.setId(rs.getInt("id"));
				gt.setName(rs.getString("name"));
				gt.setLevel(rs.getInt("level"));
				gt.setParentid(rs.getInt("parentid"));
				gt.setFlag(rs.getInt("flag"));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gt;
	}

	
	/**
	 * 根据parentid假删除
	 */
	@Override
	public int delGoodsTypeByParentId(int parentId) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "update t_goodstype set flag = 1 where parentid=?";
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, parentId);
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
	public List<GoodsType> queryGoodsTypeByLN(int level, String name) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_goodstype where flag = 2 and level = ? and name = ?";
		List<GoodsType> gtList = new ArrayList<GoodsType>();
		GoodsType gt = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, level);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				gt = new GoodsType();
				gt.setId(rs.getInt("id"));
				gt.setName(rs.getString("name"));
				gt.setLevel(rs.getInt("level"));
				gt.setParentid(rs.getInt("parentid"));
				gt.setFlag(rs.getInt("flag"));
				gtList.add(gt);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gtList;
	}

	@Override
	public List<GoodsType> queryGoodsTypeByLevel(int level) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_goodstype where flag = 2 and level = ?";
		List<GoodsType> gtList = new ArrayList<GoodsType>();
		GoodsType gt = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, level);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				gt = new GoodsType();
				gt.setId(rs.getInt("id"));
				gt.setName(rs.getString("name"));
				gt.setLevel(rs.getInt("level"));
				gt.setParentid(rs.getInt("parentid"));
				gt.setFlag(rs.getInt("flag"));
				gtList.add(gt);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gtList;
	}

	@Override
	public List<GoodsType> queryGoodsTypeByName(String name) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_goodstype where flag = 2 and name = ?";
		List<GoodsType> gtList = new ArrayList<GoodsType>();
		GoodsType gt = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				gt = new GoodsType();
				gt.setId(rs.getInt("id"));
				gt.setName(rs.getString("name"));
				gt.setLevel(rs.getInt("level"));
				gt.setParentid(rs.getInt("parentid"));
				gt.setFlag(rs.getInt("flag"));
				gtList.add(gt);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gtList;
	}

	

}
