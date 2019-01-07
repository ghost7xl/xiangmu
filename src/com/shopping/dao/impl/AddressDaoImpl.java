package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.AddressDao;
import com.shopping.pojo.City;
import com.shopping.pojo.County;
import com.shopping.pojo.Province;
import com.shopping.util.DBUtil;

public class AddressDaoImpl implements AddressDao {

	@Override
	public List<Province> getProvinceList() {
		List<Province> pr = new ArrayList<Province>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_province ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Province p = null;
			while (rs.next()) {
				p = new Province();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				pr.add(p);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pr;
	}

	@Override
	public List<City> getCityListByPid(int pid) {
		List<City> c = new ArrayList<City>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_city where pid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			ResultSet rs = pstmt.executeQuery();
			City city = null;
			while (rs.next()) {
				city = new City();
				city.setId(rs.getInt("id"));
				city.setName(rs.getString("name"));
				city.setPid(rs.getInt("pid"));
				c.add(city);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<County> getCountyListByCid(int cid) {
		List<County> c = new ArrayList<County>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_county where cityid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
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
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Province queryProvinceById(int id) {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_province where id=?";
		Province p = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				p = new Province();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public City queryCityById(int id) {

		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_city where id=?";
		City c = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				c = new City();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setPid(rs.getInt("pid"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;

	}

	@Override
	public County queryCountiesById(int id) {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_county where id=?";
		County c = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				c = new County();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setCityid(rs.getInt("cityid"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}
}
