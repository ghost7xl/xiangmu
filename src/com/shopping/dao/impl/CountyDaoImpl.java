package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.CountyDao;
import com.shopping.pojo.County;
import com.shopping.util.DBUtil;

public class CountyDaoImpl implements CountyDao {

	@Override
	public List<County> queryAllCountyById(int id) {
		List<County> c = new ArrayList<County>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_county where cityid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			County county = null;
			while (rs.next()) {
				county = new County();
				county.setId(rs.getInt("id"));
				county.setName(rs.getString("name"));
				county.setCityid(rs.getInt("cityid"));
				c.add(county);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;

	}

	@Override
	public County queryById(int id) {
		Connection conn = DBUtil.getConnection();
		County county = null;
		String sql = "select * from t_county where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				county = new County();
				county.setId(rs.getInt("id"));
				county.setName(rs.getString("name"));
				county.setCityid(rs.getInt("cityid"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return county;
	}

}
