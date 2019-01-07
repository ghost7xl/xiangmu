package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.tribes.util.Logs;

import com.mysql.jdbc.log.Log;
import com.shopping.dao.GoodsViewDao;
import com.shopping.util.DBUtil;
import com.shopping.view.GoodsView;

import sun.util.logging.resources.logging;

public class GoodsViewDaoImpl implements GoodsViewDao {

	@Override
	public List<GoodsView> queryAllGoodsViews() {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "select * from goodsview where goodsflag = 2";
		List<GoodsView> gvList = new ArrayList<GoodsView>();
		GoodsView gv = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				gv = new GoodsView();
				gv.setTypeid(rs.getInt("typeid"));
				gv.setTypename(rs.getString("typename"));
				gv.setLevel(rs.getInt("level"));
				gv.setParentid(rs.getInt("parentid"));
				gv.setTypeflag(rs.getInt("typeflag"));
				gv.setGoodsid(rs.getInt("goodsid"));
				gv.setGoodsname(rs.getString("goodsname"));
				gv.setGoodsprice(rs.getDouble("goodsprice"));
				gv.setGoodspubdate(rs.getDate("goodspubdate"));
				gv.setGoodsintro(rs.getString("goodsintro"));
				gv.setPicture(rs.getString("picture"));
				gv.setGoodsstar(rs.getInt("goodsstar"));
				gv.setGoodsflag(rs.getInt("goodsflag"));
				gvList.add(gv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gvList;
	}

	/**
	 * 根据商品id查询信息
	 */
	@Override
	public GoodsView queryGoodsView(int id) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "select * from goodsview where goodsid = ?";
		GoodsView gv = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				gv = new GoodsView();
				gv.setTypeid(rs.getInt("typeid"));
				gv.setTypename(rs.getString("typename"));
				gv.setLevel(rs.getInt("level"));
				gv.setParentid(rs.getInt("parentid"));
				gv.setTypeflag(rs.getInt("typeflag"));
				gv.setGoodsid(rs.getInt("goodsid"));
				gv.setGoodsname(rs.getString("goodsname"));
				gv.setGoodsprice(rs.getDouble("goodsprice"));
				gv.setGoodspubdate(rs.getDate("goodspubdate"));
				gv.setGoodsintro(rs.getString("goodsintro"));
				gv.setPicture(rs.getString("picture"));
				gv.setGoodsstar(rs.getInt("goodsstar"));
				gv.setGoodsflag(rs.getInt("goodsflag"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gv;
	}

	@Override
	public List<GoodsView> queryGoodsViewByName(String name) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		String sql = "select * from goodsview where goodsname = ?";
		List<GoodsView> gvList = new ArrayList<GoodsView>();
		GoodsView gv = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				gv = new GoodsView();
				gv.setTypeid(rs.getInt("typeid"));
				gv.setTypename(rs.getString("typename"));
				gv.setLevel(rs.getInt("level"));
				gv.setParentid(rs.getInt("parentid"));
				gv.setTypeflag(rs.getInt("typeflag"));
				gv.setGoodsid(rs.getInt("goodsid"));
				gv.setGoodsname(rs.getString("goodsname"));
				gv.setGoodsprice(rs.getDouble("goodsprice"));
				gv.setGoodspubdate(rs.getDate("goodspubdate"));
				gv.setGoodsintro(rs.getString("goodsintro"));
				gv.setPicture(rs.getString("picture"));
				gv.setGoodsstar(rs.getInt("goodsstar"));
				gv.setGoodsflag(rs.getInt("goodsflag"));
				gvList.add(gv);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gvList;
	}

	@Override
	public List<GoodsView> queryAllGoodsByName(String typename, String goodsname) {
		List<GoodsView> l = new ArrayList<GoodsView>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from goodsview where typename like ? or goodsname like ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + typename + "%");
			pstmt.setString(2, "%" + goodsname + "%");
			ResultSet rs = pstmt.executeQuery();
			GoodsView g = null;
			while (rs.next()) {
				g = new GoodsView();
				g.setTypeid(rs.getInt("typeid"));
				g.setTypename(rs.getString("typename"));
				g.setLevel(rs.getInt("level"));
				g.setParentid(rs.getInt("parentid"));
				g.setTypeflag(rs.getInt("typeflag"));
				g.setGoodsid(rs.getInt("goodsid"));
				g.setGoodsname(rs.getString("goodsname"));
				g.setGoodsprice(rs.getDouble("goodsprice"));
				g.setGoodspubdate(rs.getDate("goodspubdate"));
				g.setGoodsintro(rs.getString("goodsintro"));
				g.setPicture(rs.getString("picture"));
				g.setGoodsstar(rs.getInt("goodsstar"));
				g.setGoodsflag(rs.getInt("goodsflag"));
				l.add(g);
			}
			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

}
