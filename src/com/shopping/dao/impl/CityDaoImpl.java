package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.CityDao;
import com.shopping.pojo.City;
import com.shopping.util.DBUtil;

public class CityDaoImpl implements CityDao {

	@Override
	public List<City> queryAllCityById(int id) {
		List<City> c = new ArrayList<City>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_city where pid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			City city = null;
			while(rs.next()){
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public City queryById(int id) {
		City city = null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_city where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				city = new City();
				city.setId(rs.getInt("id"));
				city.setName(rs.getString("name"));
				city.setPid(rs.getInt("pid"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return city;
	}

}
