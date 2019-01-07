package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.GoodsDao;
import com.shopping.pojo.Goods;
import com.shopping.util.DBUtil;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public int addGoods(Goods goods) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "insert into t_goods values(null,?,?,null,?,?,?,?,2)";
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, goods.getName());
			ps.setDouble(2, goods.getPrice());
			ps.setInt(3, goods.getTid());
			ps.setString(4, goods.getIntro());
			ps.setString(5, goods.getPicture());
			ps.setInt(6, goods.getStar());
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
	public int delGoods(int id) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "update t_goods set flag = 1 where id = ?";
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
	public int editGoods(Goods goods) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "update t_goods set name = ?,price = ?,tid = ?,intro = ?,picture = ?,star = ? where id = ?";
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, goods.getName());
			ps.setDouble(2, goods.getPrice());
			ps.setInt(3, goods.getTid());
			ps.setString(4, goods.getIntro());
			ps.setString(5, goods.getPicture());
			ps.setInt(6, goods.getStar());
			ps.setInt(7, goods.getId());
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
	public List<Goods> queryAllGoods() {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_goods where flag = 2";
		List<Goods> gList = new ArrayList<Goods>();
		Goods g = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				g = new Goods();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPrice(rs.getDouble("price"));
				g.setPubdate(rs.getDate("pubdate"));
				g.setTid(rs.getInt("tid"));
				g.setIntro(rs.getString("intro"));
				g.setPicture(rs.getString("picture"));
				g.setStar(rs.getInt("star"));
				g.setFlag(rs.getInt("flag"));
				gList.add(g);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gList;
	}

	@Override
	public Goods queryGoodsById(int id) {
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_goods where flag = 2 and id =?";
		Goods g = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				g = new Goods();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPrice(rs.getDouble("price"));
				g.setPubdate(rs.getDate("pubdate"));
				g.setTid(rs.getInt("tid"));
				g.setIntro(rs.getString("intro"));
				g.setPicture(rs.getString("picture"));
				g.setStar(rs.getInt("star"));
				g.setFlag(rs.getInt("flag"));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
	}

	/**
	 * 根据所属类别tid查询商品信息
	 */
	@Override
	public List<Goods> queryAllGoodsById(int id) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "select * from t_goods where flag = 2 and tid = ?";
		List<Goods> gList = new ArrayList<Goods>();
		Goods g = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				g = new Goods();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPrice(rs.getDouble("price"));
				g.setPubdate(rs.getDate("pubdate"));
				g.setTid(rs.getInt("tid"));
				g.setIntro(rs.getString("intro"));
				g.setPicture(rs.getString("picture"));
				g.setStar(rs.getInt("star"));
				g.setFlag(rs.getInt("flag"));
				gList.add(g);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gList;
	}

}
